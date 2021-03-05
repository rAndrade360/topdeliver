package com.studies.topdeliver.services;

import com.studies.topdeliver.dto.OrderDTO;
import com.studies.topdeliver.entities.Order;
import com.studies.topdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<OrderDTO> findAll(){
        List<Order> orders = repository.findAll();
        return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
