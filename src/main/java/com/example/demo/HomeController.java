package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String orderForm(Model model) {
        model.addAttribute("order", new PizzaOrder());
        return "orderform";
    }

    @PostMapping("/process")
    public String processOrderForm(@Valid PizzaOrder pizzaOrder, BindingResult result) {
        if (result.hasErrors()) {
            return "orderform";
        }
        orderRepository.save(pizzaOrder);
        return "redirect:/";
    }
}
