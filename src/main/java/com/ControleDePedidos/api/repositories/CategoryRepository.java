package com.ControleDePedidos.api.repositories;

import com.ControleDePedidos.api.entities.Category;
import com.ControleDePedidos.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
