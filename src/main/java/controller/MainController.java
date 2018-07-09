package controller;

import dao.ItemDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    private static final String INDEX_JSP = "index";

    private final ItemDao idao;

    @Autowired
    public MainController(ItemDao idao) {
        this.idao = idao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest req) {
        User u = (User) req.getSession().getAttribute("user");
        ModelAndView model = new ModelAndView(INDEX_JSP);
        model.addObject("items", idao.get());
        model.addObject("user", u);
        return model;
    }
}
