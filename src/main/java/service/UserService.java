package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    private static final String USER_ATTRIBUTE = "user";

    private final UserDao udao;

    @Autowired
    public UserService(UserDao udao) {
        this.udao = udao;
    }

    public User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(USER_ATTRIBUTE);
    }

    private void removeUserFromSession(HttpSession session) {
        session.removeAttribute(USER_ATTRIBUTE);
    }

    public void checkUserExit(HttpSession session, String exit) {
        if (exit != null) {
            removeUserFromSession(session);
        }
    }

    public User getByLogin(String login) {
        return udao.getByLogin(login);
    }
}
