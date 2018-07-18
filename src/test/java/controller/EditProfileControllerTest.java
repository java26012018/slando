package controller;

import dao.ItemDaoTest;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EditProfileControllerTest {

    @Mock
    private UserService userv;
    @Mock
    private User user;
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;

    @InjectMocks
    private EditProfileController controller;

    @Before
    public void init() {
        when(user.getPass()).thenReturn(ItemDaoTest.TEST_PARAM);
        when(userv.getUserFromSession(any())).thenReturn(user);
    }

    @Test
    public void editPageTestUserIsNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(null);
        ModelAndView model = controller.editPage(req, resp);
        assertNull(model);
        verify(resp, times(1)).sendRedirect(anyString());
    }

    @Test
    public void editPageTestUserNotNull() throws IOException {
        ModelAndView model = controller.editPage(req, resp);
        assertNotNull(model);
        assertEquals(EditProfileController.PROFILE, model.getViewName());
        verify(resp, times(0)).sendRedirect(anyString());
    }

    @Test
    public void editProfileTestUserIsNull() throws IOException {
        when(userv.getUserFromSession(any())).thenReturn(null);
        controller.editProfile(req, resp, ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM,
                ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM);
        verify(userv, times(0)).updateUser(any(), anyString(),
                anyString(), anyString(), anyString());
        verify(resp, times(1)).sendRedirect(anyString());
    }

    @Test
    public void editProfileTestUserNotNull() throws IOException {
        controller.editProfile(req, resp, ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM,
                ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM, ItemDaoTest.TEST_PARAM);
        verify(userv, times(1)).updateUser(any(), anyString(),
                anyString(), anyString(), anyString());
        verify(resp, times(1)).sendRedirect(anyString());
    }
}
