package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;

@Controller
public class ItemController {
    static final String ITEM = "item";

    private final ItemService iserv;

    @Autowired
    public ItemController(ItemService iserv) {
        this.iserv = iserv;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ModelAndView item(@RequestParam String id) {
        ModelAndView model = new ModelAndView(ITEM);
        model.addObject(ITEM, iserv.getById(id));
        return model;
    }
}
