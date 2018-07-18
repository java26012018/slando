package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.AddController.MAIN_URL;

@Controller
public class EditProfileController {
    static final String PROFILE = "profile";

    private final UserService userv;

    @Autowired
    public EditProfileController(UserService userv) {
        this.userv = userv;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView editPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userv.getUserFromSession(req.getSession());
        if (user == null) {
            resp.sendRedirect(MAIN_URL);
            return null;
        } else {
            return new ModelAndView(PROFILE);
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public void editProfile(HttpServletRequest req, HttpServletResponse resp,
                            @RequestParam String pass1,
                            @RequestParam String pass2,
                            @RequestParam String phone,
                            @RequestParam String city,
                            @RequestParam String email) throws IOException {
        User user = userv.getUserFromSession(req.getSession());
        String empty = "";
        if (user != null && pass1.equals(user.getPass())) {
            if(phone.equals(empty)){
                phone = user.getPhone();
            }
            if(city.equals(empty)){
                city = user.getCity();
            }
            if(email.equals(empty)){
                email = user.getEmail();
            }
            if(pass2.equals(empty)){
                pass2 = pass1;
            }
            userv.updateUser(user, pass2, phone, email, city);
        }
        resp.sendRedirect(MAIN_URL);
    }
}
