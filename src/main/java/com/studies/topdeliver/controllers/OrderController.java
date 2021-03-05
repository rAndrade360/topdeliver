package com.studies.topdeliver.controllers;

import com.studies.topdeliver.dto.OrderDTO;
import com.studies.topdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> index(){
        List<OrderDTO> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> store(@Valid @RequestBody OrderDTO dto){
        OrderDTO order = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

}
