package com.example.shop.controller;

import com.example.shop.entity.Order;
import com.example.shop.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @PostMapping("/add_order")
    public String addOrder(Order order) {
        return service.addOrder(order).toString();
    }

    @GetMapping("/orders")
    public void getAllOrders() {

    }
}
