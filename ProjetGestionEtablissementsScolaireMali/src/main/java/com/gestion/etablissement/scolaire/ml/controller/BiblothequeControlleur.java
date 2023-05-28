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

import com.gestion.etablissement.scolaire.ml.entity.Livres;
import com.gestion.etablissement.scolaire.ml.services.LivresServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class BiblothequeControlleur {
	@Autowired
	private LivresServices livresServices;
	@GetMapping("/getAllLivres")
	public ResponseEntity<List<Livres>> getAllLivres(){
		return new ResponseEntity<List<Livres>>(livresServices.getAllLivres(),HttpStatus.OK);
	}
	@PostMapping("/saveLivres")
	public ResponseEntity<Livres> ajouterLivres(@RequestBody Livres liv){
		return new ResponseEntity<Livres>(livresServices.saveLivres(liv),HttpStatus.CREATED);
	}
	@PutMapping("/updateLivres")
	public ResponseEntity<Livres> updateLivres(@RequestBody Livres liv){
		return new ResponseEntity<Livres>(livresServices.updatelivres(liv),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteLivresById/{Id}")
	public ResponseEntity<?> deleteLivresById(@PathVariable("Id") Long id){
		livresServices.deleteLivresById(id);
		return ResponseEntity.ok(Map.of("Message","Livre a ete supprimer avec success!!!"));
	}
	@DeleteMapping("/deleteLivres")
	public ResponseEntity<?> deleteLivres(@RequestBody Livres livres){
		livresServices.deleteLivres(livres);
		return ResponseEntity.ok(Map.of("Message","Livre a ete supprimer avec success!!!"));
	}
	@GetMapping("/getLivresByNom/{Nom}")
	public ResponseEntity<Livres> getLivresByNom(@PathVariable("Nom") String nom) {
		return new ResponseEntity<Livres>(livresServices.getLivresByNom(nom),HttpStatus.OK);
	}
	@GetMapping("/getLivresByDesignation/{Designation}")
	public ResponseEntity<Livres> getLivresByDesignation(@PathVariable("Designation") String designation) {
		return new ResponseEntity<Livres>(livresServices.getLivresByDesignation(designation),HttpStatus.OK);
	}
	@GetMapping("/getLivresByNomAuteur/{NomAuteur}")
	public ResponseEntity<List<Livres>> getLivresByNomAuteur(@PathVariable("NomAuteur") String nomAuteur) {
		return new ResponseEntity<List<Livres>>(livresServices.getAllLivresByNomAuteur(nomAuteur),HttpStatus.OK);
	}
	
}
