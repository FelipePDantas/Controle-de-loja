package com.ControleDePedidos.api.resources;


import com.ControleDePedidos.api.Services.CategoryService;
import com.ControleDePedidos.api.Services.ProductService;
import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
   private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findByAll();
        return ResponseEntity.ok().body(list);
    }
@GetMapping("/{id}")
    public ResponseEntity<Product>findById(@PathVariable  Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
