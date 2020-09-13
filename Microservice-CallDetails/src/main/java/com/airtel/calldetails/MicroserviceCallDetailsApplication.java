package com.airtel.calldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
public class MicroserviceCallDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCallDetailsApplication.class, args);
	}

}
