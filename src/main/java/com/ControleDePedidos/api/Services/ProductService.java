package com.ControleDePedidos.api.Services;

import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.Product;
import com.ControleDePedidos.api.repositories.CategoryRepository;
import com.ControleDePedidos.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
  private ProductRepository repository;

    public List <Product> findByAll(){
       return repository.findAll();
    }

    public Product findById( Long id){
        Optional<Product> obj = repository.findById(id);
            return obj.get();

    }




}
