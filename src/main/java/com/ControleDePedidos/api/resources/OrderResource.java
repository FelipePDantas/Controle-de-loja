package com.ControleDePedidos.api.resources;


import com.ControleDePedidos.api.Services.OrderService;
import com.ControleDePedidos.api.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
   private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findByAll();
        return ResponseEntity.ok().body(list);
    }
@GetMapping("/{id}")
    public ResponseEntity<Order>findById(@PathVariable  Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
