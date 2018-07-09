package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthService {

    private final UserDao udao;

    @Autowired
    public AuthService(UserDao udao) {
        this.udao = udao;
    }

    public void registerNewUser(String login, String pass1, String pass2, String phone, String email, String city) {
        if (!pass1.isEmpty() && pass1.equals(pass2) && !login.isEmpty()
                && !phone.isEmpty() && !email.isEmpty() && !city.isEmpty()) {
            udao.add(new User(UUID.randomUUID().toString(), login, pass1, phone, email, city, new Date()));
        }
    }

    public void usrLogin(User u, String pass, HttpSession session) {
        if (u != null && pass.equals(u.getPass())) {
            session.setAttribute("user", u);
        }
    }
}
