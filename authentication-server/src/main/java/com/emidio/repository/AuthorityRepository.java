package com.emidio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.emidio.model.Authority;



public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}