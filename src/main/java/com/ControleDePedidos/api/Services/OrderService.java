package com.ControleDePedidos.api.Services;

import com.ControleDePedidos.api.entities.Order;
import com.ControleDePedidos.api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
  private OrderRepository repository;

    public List <Order> findByAll(){
       return repository.findAll();
    }

    public Order findById(  Long id){
        Optional<Order> obj = repository.findById(id);
            return obj.get();

    }
}
