package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@RestController
@RequestMapping("/patient/")
public class PatientController {
	
	@Autowired
	private PatientRepository patientrepository;
	
	//get 
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getAll")
	public List<Patient> getAllPatient(){
		return patientrepository.findAll();
	}
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createPatient")
	public Patient createPatient(@RequestBody Patient patient) throws Exception {
		String emaiId = patient.getEmail();
		if(emaiId != null && !"".equals(emaiId)) {
			Patient	patientobj = patientrepository.findByEmail(emaiId);
		
			if (patientobj != null) {
					throw new Exception("bad credentials");
			}
		}
	
		return patientrepository.save(patient);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
		Patient patient = patientrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Médecin non trouvé avec l'id :"+id));
		return ResponseEntity.ok(patient);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public Patient login(@RequestBody Patient patient) throws Exception {

		String emaiId = patient.getEmail();
		String passwd = patient.getPassword();
		Patient patientobj = null;
		if(emaiId != null && passwd != null) {
			patientobj = patientrepository.findByEmailAndPassword(emaiId, passwd);
		}
		if (patientobj == null) {
			throw new Exception("bad credentials");
		}
		return patientobj;
		}
	
/*	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registration")
	public Patient registration(@RequestBody Patient patient) throws Exception {

		String emaiId = patient.getEmail();
		Patient patientobj = null;
		if(emaiId != null && !"".equals(emaiId)) {
			patientobj = patientrepository.findByEmail(emaiId);
		}
		if (patientobj == null) {
			throw new Exception("bad credentials");
		}
		return patientobj;
		} */
}