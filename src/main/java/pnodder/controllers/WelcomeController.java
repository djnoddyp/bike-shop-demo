package pnodder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String getWelcome(Model model) {
        model.addAttribute("message", "Yo what's happening?");
        return "index";
    }

}
