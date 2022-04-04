package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Secretaire;
import com.example.demo.model.Therapie;
import com.example.demo.repository.TherapieRepository;

@RestController
@RequestMapping("/therapie/")
public class TherapieController {
	@Autowired
	private TherapieRepository therapieRepository;
	//get all therapies
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getAll")
	
	public List<Therapie> getAllTherapie(){
		return therapieRepository.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createTherapie")
	public Therapie createTherapie(@RequestBody Therapie therapie) {
		return therapieRepository.save(therapie);
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<Therapie> getTherapieById(@PathVariable Long id){
		Therapie therapie = therapieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Therapie non trouvé avec l'id :"+id));
		return ResponseEntity.ok(therapie);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/update/{id}")
	public ResponseEntity<Therapie> updateTherapie(@PathVariable Long id,@RequestBody Therapie therapieInfo){
		Therapie therapie = therapieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Therapie non trouvé avec l'id :"+id));
		therapie.setNom(therapieInfo.getNom());
		therapie.setDescription(therapieInfo.getDescription());
		Therapie therapieAjour = therapieRepository.save(therapie);
		return ResponseEntity.ok(therapieAjour);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMedecin(@PathVariable Long id){
		
		Therapie therapie = therapieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Thérapie non trouvé avec l'id :"+id));
		therapieRepository.delete(therapie);
		//retourne void c'est pour cela qu'on a créer the map pour retourner une réponse
		
		Map<String,Boolean>  rep = new HashMap<>();
		rep.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(rep);
		
	}
	
	
	
	
}
