package controller;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
public class AuthController {

    private static final String REGISTER_JSP = "register";
    private static final String LOGIN_JSP = "login";

    @Autowired
    private UserDao udao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerView() {
        return new ModelAndView(REGISTER_JSP);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginView() {
        return new ModelAndView(LOGIN_JSP);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestParam String login,
                         @RequestParam String pass1,
                         @RequestParam String pass2,
                         @RequestParam String phone,
                         @RequestParam String email,
                         @RequestParam String city,
                         HttpServletResponse response) throws IOException {
        if (!pass1.isEmpty()
                && pass1.equals(pass2)
                && !login.isEmpty()
                && !phone.isEmpty()
                && !email.isEmpty()
                && !city.isEmpty()) {
            udao.add(new User(
                    UUID.randomUUID().toString(),
                    login,
                    pass1,
                    phone,
                    email,
                    city,
                    new Date()));
        }
        response.sendRedirect("/");
    }
}
