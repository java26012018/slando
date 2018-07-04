package controller;

import dao.UserDao;
import dao.UserValidation;
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
public class AuthController extends UserValidation {

    private static final String REGISTER_JSP = "register";
    private static final String LOGIN_JSP = "login";
    private static final String VALID_JSP ="valid";
    private String valid;
    @Autowired
    private UserDao udao;
   // private UserValidation UV;

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
                && !login.isEmpty()
                && !phone.isEmpty()
                && !email.isEmpty()
                && !city.isEmpty())
            if(       validUser(emailValid(email),phoneValid(phone),cityValid(city),passEq(pass1,pass2)).equals("")) {
            udao.add(new User(
                    UUID.randomUUID().toString(),
                    login,
                    pass1,
                    phone,
                    email,
                    city,
                    new Date()));
                response.sendRedirect("/");
        }else response.sendRedirect("/valid");
       valid =(validUser(emailValid(email),phoneValid(phone),cityValid(city),passEq(pass1,pass2)));

    }
    @RequestMapping(value = "/valid" , method = RequestMethod.GET)
    public ModelAndView validViev (){
        ModelAndView model = new ModelAndView(VALID_JSP);
        model.addObject("validUser", valid);
        return model;
    }
}
