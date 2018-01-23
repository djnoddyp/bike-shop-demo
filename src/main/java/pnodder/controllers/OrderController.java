package pnodder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pnodder.dao.BikeDao;
import pnodder.model.Basket;
import pnodder.model.Bike;
import pnodder.model.Order;
import pnodder.model.OrderItem;
import pnodder.services.BikeService;

@Controller
public class OrderController {

    private BikeService bikeService;

    public OrderController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @ModelAttribute
    public void populateModel(Model model) {
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/bikes")
    public String getBikes() {
        return "bikes";
    }

    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        //bikeService.findAll();
        Bike b = new Bike();
        b.setMake("trek");
        b.setModel("fuel");
        b.setPrice(1499);
        bikeService.save(b);
        //bikeService.findAll();
        return "order";
    }

//    @PostMapping("/addToBasket")
//    public String addToBasket(OrderItem orderItem, BindingResult bindingResult) {
//        System.out.println(orderItem.getEmail());
//        if (!bindingResult.hasErrors()) {
//            if (!basket.getItems().contains(orderItem)) {
//                basket.addToBasket(orderItem);
//            } else {
//                // some error
//            }
//            return "redirect:/order";
//        } else {
//            return "order";
//        }
//    }

//    @PostMapping("/saveOrder")
//    public String saveResident(Order order) {
//        orderRepository.save(order);
//        return "index";
//    }
    
    
}
