package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Secretaire;

@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long>{
	
	public Secretaire findByEmailAndPassword(String email , String password);

}