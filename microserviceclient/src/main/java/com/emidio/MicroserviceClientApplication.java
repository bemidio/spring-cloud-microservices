package com.emidio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MicroserviceClientApplication {

	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientApplication.class, args);
	}

	@RequestMapping("/greeting")
	public String greeting() {			
		
		return "Hello from EurekaClient!";
	}
	
	@RequestMapping("/porta")
	public String porta() {
		String portaConfigurada = env.getProperty("server.port");
		String portaReal = env.getProperty("local.server.port");
		
		return "Porta configurada: " + portaConfigurada + ". Serviço de execução: " + portaReal;
	}
}
