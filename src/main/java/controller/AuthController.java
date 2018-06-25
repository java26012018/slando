package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    private static final String REGISTER_JSP = "register";
    private static final String LOGIN_JSP = "login";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerView() {
        return new ModelAndView(REGISTER_JSP);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginView() {
        return new ModelAndView(LOGIN_JSP);
    }
}
