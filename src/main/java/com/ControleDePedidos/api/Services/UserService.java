package com.ControleDePedidos.api.Services;

import com.ControleDePedidos.api.entities.User;
import com.ControleDePedidos.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
  private UserRepository repository;

    public List <User> findByAll(){
       return repository.findAll();
    }

    public User findById(  Long id){
        Optional<User> obj = repository.findById(id);
            return obj.get();

    }




}
