package com.usecase.onlineshopping.api.customer.ui.controllers;

import java.util.List;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.onlineshopping.api.customer.messaging.RabbitMQSender;
import com.usecase.onlineshopping.api.customer.data.Customer;
import com.usecase.onlineshopping.api.customer.exception.NoCustomerFound;
import com.usecase.onlineshopping.api.customer.exception.SalesOrderConnectionFailed;
import com.usecase.onlineshopping.api.customer.service.CustomerService;
import com.usecase.onlineshopping.api.customer.ui.model.*;

@RestController()
@RequestMapping()
public class CustomerController {

	@Autowired
	private Environment env;

	@Autowired
	RabbitMQSender rabbitMQSender;

	@Autowired
	CustomerService customerService;

	@GetMapping("/status/check")
	public String status() {
		return "Working on port " + env.getProperty("local.server.port");
	}

	@PostMapping("customer")
	public ResponseEntity<CreateCustomerResponseModel> createUser(
			@Valid @RequestBody CreateCustomerRequestModel customerDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Customer customer = modelMapper.map(customerDetails, Customer.class);
		Customer createdCustomer = customerService.createCustomer(customer);
		CreateCustomerResponseModel responseBody = modelMapper.map(createdCustomer, CreateCustomerResponseModel.class);
		try {
			rabbitMQSender.send(createdCustomer);
		} catch (Exception ex) {
			throw( new SalesOrderConnectionFailed("Connection to Sales order service failed. No data stored.",
					createdCustomer.getId()));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
	}

	@GetMapping("customers")
	public ResponseEntity<List<Customer>> customers() {
		List<Customer> customers = customerService.getAllCustomers();
		if (customers.isEmpty()) {
			throw new NoCustomerFound("No Customer Found in Database");
		}
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}
}
