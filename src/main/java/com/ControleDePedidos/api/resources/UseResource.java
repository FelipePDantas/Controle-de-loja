package com.ControleDePedidos.api.resources;


import com.ControleDePedidos.api.Services.UserService;
import com.ControleDePedidos.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UseResource {

    @Autowired
   private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findByAll();
        return ResponseEntity.ok().body(list);
    }
@GetMapping("/{id}")
    public ResponseEntity<User>findById(@PathVariable  Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
