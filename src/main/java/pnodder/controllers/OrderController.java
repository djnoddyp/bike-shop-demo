package pnodder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pnodder.model.Order;
import pnodder.model.Resident;
import pnodder.repositories.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("message", "bike order");
        model.addAttribute("resident", new Resident());
    }

    @GetMapping("/order")
    public String getWelcome() {
        return "index";
    }

    @PostMapping("/saveOrder")
    public String saveResident(Order order) {
        orderRepository.save(order);
        return "index";
    }
    
    
}
