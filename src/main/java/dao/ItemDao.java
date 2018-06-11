package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemDao {
    @Transactional
    public List<Item> get() {
        return HibernateUtil.getSession().createCriteria(Item.class).list();
    }
}
