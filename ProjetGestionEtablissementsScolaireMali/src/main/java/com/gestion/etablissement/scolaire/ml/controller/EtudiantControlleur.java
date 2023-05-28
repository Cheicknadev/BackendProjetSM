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
import com.gestion.etablissement.scolaire.ml.entity.Notes;
import com.gestion.etablissement.scolaire.ml.services.EtudiantsServices;
import com.gestion.etablissement.scolaire.ml.services.NotesServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class EtudiantControlleur {
	@Autowired
	private EtudiantsServices etudiantsServices;
	@Autowired
	private NotesServices notesServices;
	@PostMapping("/saveEtudiant")
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.saveEtudiant(etudiant),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateEtudiant")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.updateEtudiant(etudiant),HttpStatus.OK);
	}
	@GetMapping("/getEtudiantById/{Id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("Id") Long id){
		return new ResponseEntity<Etudiant>(etudiantsServices.getEtudiantById(id),HttpStatus.OK); 
	}
	@GetMapping("/getEtudiantByNumeroMatricule/{Numero}")
	public ResponseEntity<Etudiant> getEtudiantByNumeroMatricule(@PathVariable("Numero") String numero){
		return new ResponseEntity<Etudiant>(etudiantsServices.getEtudiantByNumeroMatricule(numero),HttpStatus.OK); 
	}
	@GetMapping("/getAllEtudiant")
	public ResponseEntity<List<Etudiant>> getAllEtudiant(){
		return new ResponseEntity<List<Etudiant>>(etudiantsServices.getAllEtudiant(),HttpStatus.OK);
	}
 	@DeleteMapping("/deleteEtudiant")
	public ResponseEntity<?> deleteEtudiant(@RequestBody Etudiant etudiant){
		etudiantsServices.deleteEtudiant(etudiant);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprime avec success..."));
	}
	@DeleteMapping("/deleteEtudiantByid/{Id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable("Id") Long id){
		etudiantsServices.deleteEtudiantById(id);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprimer avec success..."));
	}
	@GetMapping("/getAllNotesEtudiants")
	public ResponseEntity<List<Notes>> getAllNotesEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<List<Notes>>(notesServices.getAllNoteEtudiant(etudiant),HttpStatus.OK);
	}
//	@GetMapping("/getAllEtudiantByClasse")
//	public ResponseEntity<List<Etudiant>> getAllEtudiantByClasse(@RequestBody Classe classe){
//		return new ResponseEntity<List<Etudiant>>(etudiantsServices.getAllEtudiantByClasse(classe),HttpStatus.OK);
//	}
//	@GetMapping("/getAllEtudiantByLibelleClasse/{Libelle}")
//	public ResponseEntity<List<Etudiant>> getAllEtudiantBylLibelleClasse(@PathVariable("Libelle") String libelle){
//		return new ResponseEntity<List<Etudiant>>(etudiantsServices.getAllEtudiant(libelle),HttpStatus.OK);
//	}
}
