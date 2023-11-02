package com.ControleDePedidos.api.repositories;

import com.ControleDePedidos.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
}
