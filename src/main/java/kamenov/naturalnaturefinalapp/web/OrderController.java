package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.Order;
import kamenov.naturalnaturefinalapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")

public class OrderController {

    private final OrderService service;
    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }
}