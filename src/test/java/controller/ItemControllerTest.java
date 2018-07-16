package controller;

import entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    private static final String ID = "id";

    @Mock
    private ItemService iserv;
    @Mock
    private Item item;

    @InjectMocks
    private ItemController itemController;

    @Before
    public void init() {
        when(iserv.getById(anyString())).thenReturn(item);
        when(item.getId()).thenReturn(ID);
    }

    @Test
    public void itemTest() {
        ModelAndView model = itemController.item(ID);
        assertNotNull(model);
        assertEquals(ItemController.ITEM, model.getViewName());
        assertEquals(ID, ((Item) model.getModel().get(ItemController.ITEM)).getId());
    }
}
