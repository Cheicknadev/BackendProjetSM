package com.gestion.etablissement.scolaire.ml.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.gestion.etablissement.scolaire.ml.entity.Classe;
import com.gestion.etablissement.scolaire.ml.services.ClasseServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class ClasseControlleur {
	@Autowired
	private ClasseServices classeServices;
	@PostMapping("/saveClasse")
	public ResponseEntity<Classe> ajouterClasse(@RequestBody Classe classe) {
		return new ResponseEntity<Classe>(classeServices.saveClasse(classe),HttpStatus.CREATED);
	}
	@PutMapping("/updateClasse")
	public ResponseEntity<Classe> updateClasse(@RequestBody Classe classe){
		return new ResponseEntity<Classe>(classeServices.updateClasse(classe),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllClasse")
	public ResponseEntity<List<Classe>> getAllClasse(){
		return new ResponseEntity<List<Classe>>(classeServices.getAllClasse(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteClasse")
	public ResponseEntity<?> deleteClasse(@RequestBody Classe classe){
		classeServices.deleteclasse(classe);
		return ResponseEntity.ok(Map.of("Message","Classe suppprime avec success!!!"));
	}
	@DeleteMapping("/deleteClasseById/{Id}")
	public ResponseEntity<?> deleteClasseById(@PathVariable("Id") Long id){
		classeServices.deleteClasseById(id);
		return ResponseEntity.ok(Map.of("Message","Classe suppprime avec success!!!"));
	}
	
}
