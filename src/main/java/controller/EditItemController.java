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

import static controller.AddController.MAIN_URL;

@Controller
public class EditItemController {

    static final String EDIT = "edit";

    private final ItemService iserv;
    private final UserService userv;

    @Autowired
    public EditItemController(UserService userv, ItemService iserv) {
        this.userv = userv;
        this.iserv = iserv;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editItemPage(HttpServletRequest req, HttpServletResponse res, @RequestParam String id) throws IOException {
        User user = userv.getUserFromSession(req.getSession());
        if (user == null || !user.getLogin().equals(iserv.getById(id).getOwner())) {
            res.sendRedirect(MAIN_URL);
            return null;
        } else {
            req.getSession().setAttribute("id", id);
            ModelAndView model = new ModelAndView(EDIT);
            model.addObject(EDIT, iserv.getById(id));
            return model;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void updateItem(@RequestParam String iname, @RequestParam String ipic, @RequestParam String iabout,
                           @RequestParam int iprice, @RequestParam String icity, @RequestParam String imail, HttpServletRequest req, HttpServletResponse res) throws IOException {
        String empty = "";
        String id = (String) req.getSession().getAttribute("id");
        Item item = iserv.getById(id);
        req.getSession().removeAttribute("id");
        if (iname.equals(empty)) {
            iname = item.getName();
        }
        if (ipic.equals(empty)) {
            ipic = item.getPic();
        }
        if (iabout.equals(empty)) {
            iabout = item.getAbout();
        }
        if (iprice < 0) {
            iprice = item.getPrice();
        }
        if (icity.equals(empty)) {
            icity = item.getCity();
        }
        iserv.delete(item);
        iserv.add(new Item(UUID.randomUUID().toString(), item.getCat(), iname, iabout, ipic, item.getOwner(),
                item.getPhone(), item.getEmail(), icity, iprice, new Date(), false));
        res.sendRedirect(MAIN_URL);

    }


}
