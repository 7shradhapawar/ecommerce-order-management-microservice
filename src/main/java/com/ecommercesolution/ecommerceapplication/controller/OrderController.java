package com.ecommercesolution.ecommerceapplication.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommercesolution.ecommerceapplication.model.Order;
import com.ecommercesolution.ecommerceapplication.repository.ItemRepository;
import com.ecommercesolution.ecommerceapplication.repository.OrderRepository;
import com.ecommercesolution.ecommerceapplication.service.OrderService;



@RestController
@RequestMapping("/api")
public class OrderController {

	private OrderRepository orderRepository;

	private OrderService orderService;

	
	private ItemRepository itemRepository;

	@Autowired
	private OrderController(OrderService orderService, OrderRepository orderRepository,
			 ItemRepository itemRepository) {
		super();
		this.orderRepository = orderRepository;
		this.itemRepository = itemRepository;
		this.orderService = orderService;
	}
	
	@GetMapping("/orders")
	List<Order> orders(){
		return orderRepository.findAll();
		
	}
	
	@GetMapping("/orders/{id}")
	Optional<Order> getOneOrder(@PathVariable Long id) {
		return orderRepository.findById(id);
	}
	
	@PostMapping("/order")
	ResponseEntity<Order> createOrder(@Validated @RequestBody Order orderDetail) throws URISyntaxException{
		Order result= orderRepository.save(orderDetail);
	  return ResponseEntity.created(new URI("/api/order" + result.getId())).body(result); 
	
	}
	
	@DeleteMapping("/order/{id}")
	ResponseEntity<Order>deleteOrder(@PathVariable Long id){
		orderRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
