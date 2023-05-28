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

import com.gestion.etablissement.scolaire.ml.entity.EmploiDuTemps;
import com.gestion.etablissement.scolaire.ml.services.EmploiDuTempsServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class EmploiDuTempsControlleur {
	@Autowired
	private EmploiDuTempsServices emploiDuTempsServices;
	@PostMapping("/SaveEmploiDuTemps")
	public ResponseEntity<EmploiDuTemps> ajouterEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps){
		return new ResponseEntity<EmploiDuTemps>(emploiDuTempsServices.saveEmploiDuTemps(emploiDuTemps),HttpStatus.CREATED);
	}
	@PutMapping("/updateEmploiDuTemps")
	public ResponseEntity<EmploiDuTemps> updateEmpoiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps){
		return new ResponseEntity<EmploiDuTemps>(emploiDuTempsServices.updateEmploiDuTemps(emploiDuTemps),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllEmploiDuTemps")
	public ResponseEntity<List<EmploiDuTemps>> getAllEmploiDuTemps(){
		return new ResponseEntity<List<EmploiDuTemps>>(emploiDuTempsServices.getAllEmploiDuTemps(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmploiDuTemps")
	public ResponseEntity<?> deleteEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps){
		emploiDuTempsServices.deleteEmploiDuTemps(emploiDuTemps);
		return ResponseEntity.ok(Map.of("Message","Emploi du temps supprime avec success!!!"));
	}
	@DeleteMapping("/deleteEmploiDuTempsById/{Id}")
	public ResponseEntity<?> deleteEmploiDuTempsById(@PathVariable("Id") Long id){
		emploiDuTempsServices.deleteEmploiDuTempsById(id);
		return ResponseEntity.ok(Map.of("Message","Emploi du temps supprime avec success!!!"));
	}
	
}
