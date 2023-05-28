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

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;
import com.gestion.etablissement.scolaire.ml.services.PayementScolaireServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class PayementScolaireControlleur {
	@Autowired
	private PayementScolaireServices payementScolaireServices;
	@PostMapping("/savePayementScolaire")
	public ResponseEntity<PayementScolaire> createPayementScolaire(@RequestBody PayementScolaire payementScolaire){
		return new ResponseEntity<PayementScolaire>(payementScolaireServices.savePayementScolaire(payementScolaire),HttpStatus.CREATED);
	}
	@PutMapping("/updatePayementScolaire")
	public ResponseEntity<PayementScolaire> updatePayementScolaire(@RequestBody PayementScolaire payementScolaire){
		return new ResponseEntity<PayementScolaire>(payementScolaireServices.updatePayementScolaire(payementScolaire),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllPayementScolaire")
	public ResponseEntity<List<PayementScolaire>> getAllPayementScolaire(){
		return new ResponseEntity<List<PayementScolaire>>(payementScolaireServices.getAllPayementScolaire(),HttpStatus.OK);
	}
	@DeleteMapping("/deletePayementScolaire")
	public ResponseEntity<?> deletePayementScolaire(@RequestBody PayementScolaire payementScolaire){
		payementScolaireServices.deletePayementScolaire(payementScolaire);
		return ResponseEntity.ok(Map.of("Message","Payement scolaire supprime avec success!!!"));
	}
	@DeleteMapping("/deletePayementScolaireById/{Id}")
	public ResponseEntity<?> deletePayementScolaireById(@PathVariable("Id") Long id){
		payementScolaireServices.deletePayementScolaireById(id);
		return ResponseEntity.ok(Map.of("Message","Payement Scolaire supprime avec success!!!"));
	}
	@GetMapping("/getAllPayementScolaireByEtudiant")
	public ResponseEntity<List<PayementScolaire>> getAllPayementScolaireEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<List<PayementScolaire>>(payementScolaireServices.getAllPayementScolaireByEtudiant(etudiant),HttpStatus.OK);
	}
}
