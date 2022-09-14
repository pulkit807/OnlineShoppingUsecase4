package com.usecase.onlineshopping.api.customer.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.usecase.onlineshopping.api.customer.data.Customer;


@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Customer customer) {
		rabbitTemplate.convertAndSend(exchange, routingkey, customer);
		System.out.println("Successfuly Sent - "+customer.toString());
	    
	}
}
