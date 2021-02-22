package com.ecommercesolution.ecommerceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercesolution.ecommerceapplication.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
