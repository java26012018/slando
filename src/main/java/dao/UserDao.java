package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserDao {
    public User getByLogin(String login) {
        Session s = HibernateUtil.getSession();
        List<User> users = s.createCriteria(User.class).list();
        s.close();
        for (User item : users) {
            if (item.getLogin().equals(login)) {

                return item;
            }
        }
        return null;
    }

    public boolean add(@NotNull User user) {
        if (getByLogin(user.getLogin()) != null) {
            return false;
        } else {
            Session s = HibernateUtil.getSession();
            s.beginTransaction();
            s.save(user);
            s.getTransaction().commit();
            s.close();
            return true;
        }
    }
    public void updateUser(User u, String pass, String phone, String email, String city){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();

        u.setPass(pass);
        u.setPhone(phone);
        u.setEmail(email);
        u.setCity(city);

        s.update(u);
        s.getTransaction().commit();
        s.close();
    }
}
