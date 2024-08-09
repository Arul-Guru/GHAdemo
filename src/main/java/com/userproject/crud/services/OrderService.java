package com.userproject.crud.services;

import com.userproject.crud.dao.OrderRepository;
import com.userproject.crud.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public Order addOrder(Order order){
        repository.save(order);
        return order;
    }
}
