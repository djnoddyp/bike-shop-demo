package pnodder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pnodder.entities.Order;
import pnodder.repositories.OrderRepository;

@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("message", "bike order");
        model.addAttribute("order", new Order());
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
