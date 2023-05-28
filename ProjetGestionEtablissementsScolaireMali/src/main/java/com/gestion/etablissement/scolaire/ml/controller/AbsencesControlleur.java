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

import com.gestion.etablissement.scolaire.ml.entity.Absences;
import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.entity.Enseignant;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.services.AbsenceService;



@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class AbsencesControlleur {
	@Autowired
	private AbsenceService absenceService;
	@PostMapping("/saveAbsences")
	public ResponseEntity<Absences> ajouterAbsences(@RequestBody Absences absences){
		return new ResponseEntity<Absences>(absenceService.saveAbsence(absences),HttpStatus.CREATED);
	}
	@PutMapping("/updateAbsences")
	public ResponseEntity<Absences> updateAbsences(@RequestBody Absences absences){
		return new ResponseEntity<Absences>(absenceService.updateAbsence(absences),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllAbsences")
	public ResponseEntity<List<Absences>> getAllAbsences(){
		return new ResponseEntity<List<Absences>>(absenceService.getAllAbsence(),HttpStatus.OK);
	}
	@GetMapping("/getAbsencesEtudiant")
	public ResponseEntity<List<Absences>> getAbsencesEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<List<Absences>>(absenceService.getAbsenceByEtudiant(etudiant),HttpStatus.OK);
	}
	@GetMapping("/getAbsencesEnseignant")
	public ResponseEntity<List<Absences>> getAbsencesEnseignant(@RequestBody Enseignant enseignant){
		return new ResponseEntity<List<Absences>>(absenceService.getAbsenceByEnseignant(enseignant),HttpStatus.OK);
	}
	@GetMapping("/getAbsencesAdministration")
	public ResponseEntity<List<Absences>> getAbsencesAdministration(@RequestBody Administration administration){
		return new ResponseEntity<List<Absences>>(absenceService.getAbsenceByAdministration(administration),HttpStatus.OK);
	}
	@DeleteMapping("/deletAbsenceById/{Id}")
	public ResponseEntity<?> deleteAbsenceById(@PathVariable("Id") Long id){
		absenceService.deleteAbsenceById(id);
		return ResponseEntity.ok(Map.of("Message","Absence supprimer avec success!!!"));
	}
	@DeleteMapping("/deleteAbsences")
	public ResponseEntity<?> deleteAbsence(@RequestBody Absences absence){
		absenceService.deleteAbsence(absence);
		return ResponseEntity.ok(Map.of("Message","L'absence a ete supprime avec success"));
	}
}
