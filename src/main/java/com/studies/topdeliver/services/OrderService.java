package com.studies.topdeliver.services;

import com.studies.topdeliver.dto.OrderDTO;
import com.studies.topdeliver.dto.ProductDTO;
import com.studies.topdeliver.entities.Order;
import com.studies.topdeliver.entities.OrderStatus;
import com.studies.topdeliver.entities.Product;
import com.studies.topdeliver.repositories.OrderRepository;
import com.studies.topdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository Productrepository;

    public List<OrderDTO> findAll(){
        List<Order> orders = repository.findAll();
        return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for(ProductDTO p : dto.getProducts()){
            Product product = Productrepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
