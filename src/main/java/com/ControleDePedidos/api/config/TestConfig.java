package com.ControleDePedidos.api.config;

import com.ControleDePedidos.api.entities.*;
import com.ControleDePedidos.api.entities.enums.OrderStatus;
import com.ControleDePedidos.api.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Eletronicos");
        Category cat2 = new Category(null,"Livros");
        Category cat3 = new Category(null,"Computadores");

        Product p1 = new Product(null,"Clean Code","Livro de código limpa.",100D,"felfle");
        Product p2 = new Product(null,"Ps5","Video-game ultima geração.",5000D,"'-----'");
        Product p3 = new Product(null,"Processador I10","Processadore ultra.",7000D,"looop");
        Product p4 = new Product(null,"Clean Architecture","Livro de Arquitetura limpa.",102D,"saldl");
        Product p5 = new Product(null,"Placa de Video","Placa de vídeo RTX 4060.",4500D,"----'-'");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat1);
        p5.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        User u1 = new User(null,"Felipe","felipedev88@gmail.com","988682153","123456");
        User u2 = new User(null,"Alana","AlanaAle@gmail.com","988652153","654321");
        User u3 = new User(null,"Gojo","satoro@gmail.com","955682153","756545");

        Order o1 = new Order(null, Instant.parse("2023-11-02T13:01:06Z"), OrderStatus.PAGO,u1,"Pedido feito a mão pois a maquina estava quebrada");
        Order o2 = new Order(null, Instant.parse("2023-11-02T13:05:06Z"),OrderStatus.ENVIADO,u2,"O úsuario pagou no cartão mas estava dando problema");
        Order o3 = new Order(null, Instant.parse("2023-11-02T13:10:06Z"),OrderStatus.CANCELADO,u3,"Deu certo e tudo OK");
        Order o4 = new Order(null, Instant.parse("2023-11-03T22:01:06Z"),OrderStatus.ESPERANDO_PAGAMENTO,u1,"hehehehehehehe");


        repository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));

        OrderItem oi1 = new OrderItem(o1,p1,2, p1.getPreco());
        OrderItem oi2 = new OrderItem(o1,p3,3, p4.getPreco());
        OrderItem oi3 = new OrderItem(o2,p3,5, p5.getPreco());
        OrderItem oi4 = new OrderItem(o3,p5,8, p1.getPreco());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));



    }
}
