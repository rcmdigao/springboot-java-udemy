package com.educandoweb.cursojava.repositories;

import com.educandoweb.cursojava.entities.Order;
import com.educandoweb.cursojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
