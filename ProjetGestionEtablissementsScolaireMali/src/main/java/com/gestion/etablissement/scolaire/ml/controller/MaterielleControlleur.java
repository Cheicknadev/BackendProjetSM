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

import com.gestion.etablissement.scolaire.ml.entity.Materiel;
import com.gestion.etablissement.scolaire.ml.services.MaterielServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class MaterielleControlleur {
	@Autowired
	private MaterielServices materielServices;
	
	@PostMapping("/saveMaterielle")
	public ResponseEntity<Materiel> ajouterMaterielle(@RequestBody Materiel materiel){
		return new ResponseEntity<Materiel>(materielServices.saveMateriel(materiel),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateMaterielle")
	public ResponseEntity<Materiel> updateMaterielle(@RequestBody Materiel materiel){
		return new ResponseEntity<Materiel>(materielServices.updateMateriel(materiel),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMaterielleByDesignation/{Designation}")
	public ResponseEntity<Materiel> getMaterielByDesignation(@PathVariable("Designation") String designation){
		return new ResponseEntity<Materiel>(materielServices.getMaterielByDesignation(designation),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMaterielleById/{Id}")
	public ResponseEntity<Materiel> getMaterielById(@PathVariable("Id") Long id){
		return new ResponseEntity<Materiel>(materielServices.getMaterielBy(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllMaterielle")
	public ResponseEntity<List<Materiel>> getAllMateriel(){
		return new ResponseEntity<List<Materiel>>(materielServices.getAllMateriels(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteMarielle")
	public ResponseEntity<?> deleteMateriel(@RequestBody Materiel materiel){
		materielServices.deleteMateriel(materiel);
		return ResponseEntity.ok(Map.of("Message","La materielle est supprimer avec success!!!"));
	}
	@DeleteMapping("/deleteMarielleById/{Id}")
	public ResponseEntity<?> deleteMaterielById(@PathVariable("Id") Long id){
		materielServices.deleteMaterielById(id);
		return ResponseEntity.ok(Map.of("Message","La materielle a ete bien suppprimer avec success!!!"));
	}
}
