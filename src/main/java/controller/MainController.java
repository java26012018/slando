package controller;

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

@Controller
public class MainController {
    private static final String INDEX_JSP = "index";
    private static final String USER_ATTRIBUTE = "user";
    private static final String ITEMS_ATTRIBUTE = "items";


    private final UserService userv;
    private final ItemService iserv;

    @Autowired
    public MainController(UserService userv, ItemService iserv) {
        this.userv = userv;
        this.iserv = iserv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(@RequestParam(required = false) String exit,
                             @RequestParam(required = false) String owner,
                             HttpServletRequest req) {
        userv.checkUserExit(req.getSession(), exit);
        User u = userv.getUserFromSession(req.getSession());
        ModelAndView model = new ModelAndView(INDEX_JSP);
        model.addObject(ITEMS_ATTRIBUTE, owner == null ? iserv.get() : iserv.getByOwner(owner));
        model.addObject(USER_ATTRIBUTE, u);
        return model;
    }
}
