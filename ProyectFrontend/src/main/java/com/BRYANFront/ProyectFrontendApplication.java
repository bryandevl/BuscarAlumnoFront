package com.BRYANFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.BRYANFront.Client")
public class ProyectFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectFrontendApplication.class, args);
	}

}
