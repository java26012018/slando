package controller;

import entity.Item;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
public class AddController {
    static final String MAIN_URL = "/";
    static final String ADD = "add";

    private final UserService userv;
    private final ItemService iserv;

    @Autowired
    public AddController(UserService userv, ItemService iserv) {
        this.userv = userv;
        this.iserv = iserv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userv.getUserFromSession(req.getSession());
        if (user == null) {
            resp.sendRedirect(MAIN_URL);
            return null;
        } else {
            return new ModelAndView(ADD);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addItem(HttpServletRequest req, HttpServletResponse resp,
                        @RequestParam String cat,
                        @RequestParam String name,
                        @RequestParam String about,
                        @RequestParam String pic,
                        @RequestParam int price) throws IOException {
        User user = userv.getUserFromSession(req.getSession());
        if (user != null) {
            iserv.add(new Item(UUID.randomUUID().toString(), cat, name, about, pic,
                    user.getLogin(), user.getPhone(), user.getEmail(), user.getCity(),
                    price, new Date(), false));
        }
        resp.sendRedirect(MAIN_URL);
    }
}
