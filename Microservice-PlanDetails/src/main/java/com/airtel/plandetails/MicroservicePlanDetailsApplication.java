package com.airtel.plandetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableResourceServer
public class MicroservicePlanDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePlanDetailsApplication.class, args);
	}

}
