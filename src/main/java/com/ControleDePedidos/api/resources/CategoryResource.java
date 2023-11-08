package com.ControleDePedidos.api.resources;


import com.ControleDePedidos.api.Services.CategoryService;
import com.ControleDePedidos.api.Services.UserService;
import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryResource {

    @Autowired
   private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findByAll();
        return ResponseEntity.ok().body(list);
    }
@GetMapping("/{id}")
    public ResponseEntity<Category>findById(@PathVariable  Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
