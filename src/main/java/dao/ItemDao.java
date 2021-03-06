package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    public void add(Item i) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
    }

    public void delete(Item i) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.delete(i);
        s.getTransaction().commit();
        s.close();
    }


    public List<Item> getByOwner(String owner) {
        Session s = HibernateUtil.getSession();
        List<Item> out = s.createQuery("FROM Item WHERE owner='" + owner + "'").list();
        s.close();
        return out;
    }

    public List<Item> getBySearchRequest(String search) {
        List<Item> allItems = get();
        LinkedList items = new LinkedList<>();
        for (Item i : allItems) {
            if (i.getName().toLowerCase().contains(search.toLowerCase()) || i.getAbout().toLowerCase().contains(search.toLowerCase())) {
                items.add(i);
            }
        }
        return items;
    }

    public List<Item> getByCat(String cat) {
        List<Item> allItems = get();
        LinkedList listByCat = new LinkedList();

        for (Item i : allItems) {
            if (i.getCat().equals(cat)) {
                listByCat.add(i);
            }
        }
        return listByCat;
    }
}
