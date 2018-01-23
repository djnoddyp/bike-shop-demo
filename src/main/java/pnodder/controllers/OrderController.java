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

@Controller
public class OrderController {

    private BikeDao bikeDao;
    private Basket basket;

    public OrderController(BikeDao bikeDao) {
        this.bikeDao = bikeDao;
        basket = new Basket();
    }

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("allBikes", bikeDao.findAll());
        model.addAttribute("basketItems", basket.getItems());
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
        for (OrderItem o : basket.getItems()) {
            System.out.println(o.getBike());
        }
        model.addAttribute("orderItem", new OrderItem());
        return "order";
    }

    @PostMapping("/addToBasket")
    public String addToBasket(OrderItem orderItem, BindingResult bindingResult) {
        System.out.println(orderItem.getEmail());
        if (!bindingResult.hasErrors()) {
            if (!basket.getItems().contains(orderItem)) {
                basket.addToBasket(orderItem);
            } else {
                // some error
            }   
            return "redirect:/order";
        } else {
            return "order";
        }
    }

//    @PostMapping("/saveOrder")
//    public String saveResident(Order order) {
//        orderRepository.save(order);
//        return "index";
//    }
    
    
}
