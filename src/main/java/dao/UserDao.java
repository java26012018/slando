package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
public class UserDao {
    @Transactional
    public User getByLogin(String login) {
        return (User) HibernateUtil.getSession().createQuery(String.format("FROM User WHERE login='%s'", login)).uniqueResult();
    }

    @Transactional
    public boolean add(@NotNull User user) {
        if (getByLogin(user.getLogin()) != null) {
            return false;
        } else {
            HibernateUtil.getSession().save(user);
            return true;
        }
    }
}
