package com.usecase.onlineshopping.api.sos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OnlineShoppingAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingAppConfigServerApplication.class, args);
	}

}
