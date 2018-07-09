package service;

import entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    private static final String USER_ATTRIBUTE = "user";

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
}
