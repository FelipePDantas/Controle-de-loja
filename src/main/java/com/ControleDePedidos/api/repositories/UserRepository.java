package com.ControleDePedidos.api.repositories;

import com.ControleDePedidos.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
