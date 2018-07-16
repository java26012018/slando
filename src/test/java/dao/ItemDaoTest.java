package dao;

import entity.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDaoTest {
    private static final String CORRECT_ID = "c8dfc9a2-f92e-4c20-bf52-0adc32af3378";
    private static final String CAT_KITCHEN = "kitchen";
    private static final String OWNER_VALERA = "Valera";
    private static final String INCORRECT_ID = "incorrect";

    private ItemDao idao = new ItemDao();

    @Test
    public void getByIdTestCorrectId() {
        Item i = idao.getById(CORRECT_ID);
        assertNotNull(i);
        assertEquals(CAT_KITCHEN, i.getCat());
        assertEquals(OWNER_VALERA, i.getOwner());
    }

    @Test
    public void getByIdTestIncorrectId() {
        Item i = idao.getById(INCORRECT_ID);
        assertNull(i);
    }
}
