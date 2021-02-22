package com.ecommercesolution.ecommerceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercesolution.ecommerceapplication.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
