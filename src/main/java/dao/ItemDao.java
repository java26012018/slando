package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDao {


    public List<Item> get() {
        Session s = HibernateUtil.getSession();
        Criteria c = s.createCriteria(Item.class);
        List<Item> out = c.list();
        s.close();
        return out;
    }

    public Item getById(String id) {
        Session s = HibernateUtil.getSession();
        Item out = (Item) s.createQuery("FROM Item WHERE id='" + id + "'").uniqueResult();
        s.close();
        return out;
    }
}
