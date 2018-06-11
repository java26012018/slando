package controller;

import dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private static final String INDEX_JSP = "index";

    @Autowired
    private ItemDao idao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView(INDEX_JSP);
        model.addObject("items", idao.get());
        return model;
    }
}
