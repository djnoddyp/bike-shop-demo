package pnodder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pnodder.model.Resident;

@Controller
public class WelcomeController {

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("message", "Yo");
        model.addAttribute("resident", new Resident());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String getWelcome() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveResident")
    public String saveResident(Resident resident) {
        System.out.println("Created: " + resident.getName() + " " + resident.getAddress());
        return "index";
    }

}
