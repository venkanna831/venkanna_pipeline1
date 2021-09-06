package com.mindtree.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.customer.model.Customer;
import com.mindtree.customer.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping("/")
	@ResponseBody
	public String welcomePage() {
		return "Welcome to Customer Application";
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return service.viewAllCustomers();
	}

	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return service.viewSpecificCustomer(id);
	}

	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		return service.insertCustomer(customer);
	}

}
