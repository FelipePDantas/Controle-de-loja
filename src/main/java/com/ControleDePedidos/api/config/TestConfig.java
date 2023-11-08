package com.ControleDePedidos.api.config;

import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.Order;
import com.ControleDePedidos.api.entities.User;
import com.ControleDePedidos.api.entities.enums.OrderStatus;
import com.ControleDePedidos.api.repositories.CategoryRepository;
import com.ControleDePedidos.api.repositories.OrderRepository;
import com.ControleDePedidos.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Eletronicos");
        Category cat2 = new Category(null,"Livros");
        Category cat3 = new Category(null,"Computadores");



        User u1 = new User(null,"Felipe","felipedev88@gmail.com","988682153","123456");
        User u2 = new User(null,"Alana","AlanaAle@gmail.com","988652153","654321");
        User u3 = new User(null,"Gojo","satoro@gmail.com","955682153","756545");

        Order o1 = new Order(null, Instant.parse("2023-11-02T13:01:06Z"), OrderStatus.PAGO,u1,"Pedido feito a mão pois a maquina estava quebrada");
        Order o2 = new Order(null, Instant.parse("2023-11-02T13:05:06Z"),OrderStatus.ENVIADO,u2,"O úsuario pagou no cartão mas estava dando problema");
        Order o3 = new Order(null, Instant.parse("2023-11-02T13:10:06Z"),OrderStatus.CANCELADO,u3,"Deu certo e tudo OK");
        Order o4 = new Order(null, Instant.parse("2023-11-03T22:01:06Z"),OrderStatus.ESPERANDO_PAGAMENTO,u1,"hehehehehehehe");





        repository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));



    }
}
