package com.ms.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceCustomerOnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCustomerOnSpringBootApplication.class, args);
	}

}
