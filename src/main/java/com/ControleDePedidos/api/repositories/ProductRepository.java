package com.ControleDePedidos.api.repositories;

import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
