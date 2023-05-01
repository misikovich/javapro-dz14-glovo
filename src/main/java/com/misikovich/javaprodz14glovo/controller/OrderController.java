package com.misikovich.javaprodz14glovo.controller;

import com.misikovich.javaprodz14glovo.model.Order;
import com.misikovich.javaprodz14glovo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return this.orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @PostMapping()
    public Order addOrder(@RequestBody Order order) {
        return this.orderService.addOrder(order);
    }
    @PostMapping("/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody Order order) {
        return this.orderService.updateOrder(id, order);
    }
    @DeleteMapping("/{id}/delete")
    public Order deleteOrder(@PathVariable long id) {
        return this.orderService.deleteOrder(id);
    }
}
