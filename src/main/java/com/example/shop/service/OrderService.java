package com.example.shop.service;

import com.example.shop.entity.Order;
import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    List<Order> getAll();
}
