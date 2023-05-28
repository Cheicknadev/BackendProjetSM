package com.gestion.etablissement.scolaire.ml.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.etablissement.scolaire.ml.entity.Enseignant;
import com.gestion.etablissement.scolaire.ml.services.EnseignantServices;
@Controller
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class EnseignantControlleur {
	@Autowired
	private EnseignantServices enseignantServices;
	@PostMapping("/saveEnseignant")
	public ResponseEntity<Enseignant> ajouterEnseignant(@RequestBody Enseignant enseignant){
		return new ResponseEntity<Enseignant>(enseignantServices.saveEnseignant(enseignant),HttpStatus.CREATED);
	}
	@PutMapping("/updateEnseignant")
	public ResponseEntity<Enseignant> updateEnseignant(@RequestBody Enseignant enseignant){
		return new ResponseEntity<Enseignant>(enseignantServices.updateEnseignant(enseignant),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllEnseignant")
	public ResponseEntity<List<Enseignant>> getAllEnseignant(){
		return new ResponseEntity<List<Enseignant>>(enseignantServices.getAllEnseignant(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteEnseignant")
	public ResponseEntity<?> deleteEnseignant(@RequestBody Enseignant enseignant){
		enseignantServices.deleteEnseignant(enseignant);
		return ResponseEntity.ok(Map.of("Message","Enseignant est supprime avec success!!!!"));
	}
	@DeleteMapping("/deleteEnseignantById/{Id}")
	public ResponseEntity<?> deleteEnseignantById(@PathVariable("Id") Long id){
		enseignantServices.deleteEnseignantById(id);
		return ResponseEntity.ok(Map.of("Message","Enseignant est supprime avec success!!!!"));
	}
}
