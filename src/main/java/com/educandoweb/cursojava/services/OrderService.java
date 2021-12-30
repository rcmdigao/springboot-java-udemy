package com.educandoweb.cursojava.services;

import com.educandoweb.cursojava.entities.Order;
import com.educandoweb.cursojava.entities.User;
import com.educandoweb.cursojava.repositories.OrderRepository;
import com.educandoweb.cursojava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }


}
