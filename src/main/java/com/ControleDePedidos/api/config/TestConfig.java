package com.ControleDePedidos.api.config;

import com.ControleDePedidos.api.entities.User;
import com.ControleDePedidos.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null,"Felipe","felipedev88@gmail.com","988682153","123456");
        User u2 = new User(null,"Alana","AlanaAle@gmail.com","988652153","654321");
        User u3 = new User(null,"Gojo","satoro@gmail.com","955682153","756545");

        repository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
