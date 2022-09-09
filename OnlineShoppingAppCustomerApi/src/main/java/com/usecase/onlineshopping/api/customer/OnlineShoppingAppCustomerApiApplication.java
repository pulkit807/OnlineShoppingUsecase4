package com.usecase.onlineshopping.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineShoppingAppCustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingAppCustomerApiApplication.class, args);
	}

}
