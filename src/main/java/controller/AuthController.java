package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AuthService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class AuthController {

    private static final String REGISTER_JSP = "register";
    private static final String LOGIN_JSP = "login";

    private final AuthService authserv;
    private final UserService userv;

    @Autowired
    public AuthController(AuthService authserv, UserService userv) {
        this.authserv = authserv;
        this.userv = userv;
    }

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
        authserv.registerNewUser(login, pass1, pass2, phone, email, city);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam String login,
                      @RequestParam String pass,
                      HttpServletResponse response,
                      HttpServletRequest req) throws IOException {

        authserv.usrLogin(userv.getByLogin(login), pass, req.getSession());
        response.sendRedirect("/");
    }
}
