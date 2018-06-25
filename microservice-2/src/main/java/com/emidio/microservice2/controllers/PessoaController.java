package com.emidio.microservice2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.emidio.microservice2.entidades.Pessoa;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

	@GetMapping()
	public ResponseEntity<Pessoa> listarPessoas(){
		
//		List<Pessoa> lista = new ArrayList<Pessoa>();
//		
//		for(int x = 1; x <= 5; x++) {
//			Pessoa p = new Pessoa();
//			p.setId(x);
//			p.setNome("Nome" + x);
//			
//			lista.add(p);
//		}
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p.setNome("Fernando B. Emidio");
		
		return ResponseEntity.ok(p);
		
	}
	
}
