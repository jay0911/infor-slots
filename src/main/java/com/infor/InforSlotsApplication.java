package com.infor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InforSlotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InforSlotsApplication.class, args);
	}
}
