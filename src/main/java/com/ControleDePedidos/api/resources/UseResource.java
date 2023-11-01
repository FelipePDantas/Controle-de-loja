package com.ControleDePedidos.api.resources;


import com.ControleDePedidos.api.entities.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UseResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(10L,"Maria","Maria@Hotmail.com","8868-2153","1234");
        return ResponseEntity.ok().body(u);
    }
}
