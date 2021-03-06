package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

//import com.example.cabinetbackend.model.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Patient findByEmailAndPassword(String email , String password);
	public Patient findByEmail(String email );
}