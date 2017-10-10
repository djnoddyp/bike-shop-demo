package pnodder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pnodder.model.Resident;

@Controller
public class WelcomeController {

    private Validator validator;

    public WelcomeController(Validator validator) {
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(this.validator);
    }

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("message", "Yo");
        model.addAttribute("resident", new Resident());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String getWelcome() {
        return "index";
    }

    @PostMapping("/saveResident")
    public String saveResident(@Validated Resident resident, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("some errors");
        } else {
            System.out.println("Created: " + resident.getName() + " " + resident.getAddress());
        }
        return "index";
    }

}
