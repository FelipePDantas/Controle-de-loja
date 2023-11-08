package com.ControleDePedidos.api.Services;

import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.User;
import com.ControleDePedidos.api.repositories.CategoryRepository;
import com.ControleDePedidos.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
  private CategoryRepository repository;

    public List <Category> findByAll(){
       return repository.findAll();
    }

    public Category findById( Long id){
        Optional<Category> obj = repository.findById(id);
            return obj.get();

    }




}
