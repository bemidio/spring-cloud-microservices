package com.emidio;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
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
	
	 //
	 //public ResponseEntity<EmpresaDTO> 
	
	@HystrixCommand(fallbackMethod = "retornoAmigavel")
	@RequestMapping("pessoas")
	public String buscarPessoa() {
		
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://192.168.1.103:8090/microservice-response/api/pessoas");
	    
	    
	    String result = "O json resultante é " + restTemplate.getForObject(uri, String.class);
	    
	    return result;
	}
	
	public String retornoAmigavel() {
		
		return "A chamada falhou, mas você não precisa ficar triste.";
	}
}
