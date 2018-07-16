package controller;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static dao.ItemDaoTest.TEST_PARAM;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddControllerTest {
    @Mock
    private ItemService iserv;
    @Mock
    private UserService userv;
    @Mock
    private User user;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    @InjectMocks
    private AddController controller;

    @Before
    public void init() {
        when(request.getSession()).thenReturn(session);
        when(user.getLogin()).thenReturn(TEST_PARAM);
        when(user.getCity()).thenReturn(TEST_PARAM);
        when(user.getEmail()).thenReturn(TEST_PARAM);
        when(user.getPhone()).thenReturn(TEST_PARAM);
    }

    @Test
    public void addPageTestUserIsNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(null);
        ModelAndView model = controller.addPage(request, response);
        assertNull(model);
        verify(response).sendRedirect(AddController.MAIN_URL);
    }

    @Test
    public void addPageTestUserNotNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(user);
        ModelAndView model = controller.addPage(request, response);
        verify(response, times(0)).sendRedirect(AddController.MAIN_URL);
        assertNotNull(model);
        assertEquals(AddController.ADD, model.getViewName());
    }

    @Test
    public void addItemTestUserIsNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(null);
        controller.addItem(request, response, TEST_PARAM, TEST_PARAM, TEST_PARAM,
                TEST_PARAM, 500);
        verify(response).sendRedirect(anyString());
        verify(iserv, times(0)).add(any());
    }

    @Test
    public void addItemTestUserNotNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(user);
        controller.addItem(request, response, TEST_PARAM, TEST_PARAM, TEST_PARAM,
                TEST_PARAM, 500);
        verify(response).sendRedirect(anyString());
        verify(iserv).add(any());
    }
}
