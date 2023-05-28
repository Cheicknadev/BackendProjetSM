package com.gestion.etablissement.scolaire.ml.controller;

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

import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.entity.AdministrationComplete;
import com.gestion.etablissement.scolaire.ml.services.AdministrationServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class AdministrationControlleur {
	@Autowired
	private AdministrationServices administrationServices;
	@PostMapping("/saveAdministration")
	public ResponseEntity<Administration> ajouterAdministration(@RequestBody AdministrationComplete administrationComplete){
		Administration admin = new Administration();
		return new ResponseEntity<Administration>(administrationServices.saveAdministration(admin),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateAdministration")
	public ResponseEntity<Administration> updateAdministration(@RequestBody Administration admin){
		return new ResponseEntity<Administration>(administrationServices.updateAdministration(admin),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAdministrationByType/{Type}")
	public ResponseEntity<Administration> getAdministrationByTypeUser(@PathVariable("Type") String type){
		return new ResponseEntity<Administration>(administrationServices.getAdministrationByTypeUsers(type),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteAdministration")
	public ResponseEntity<?> deleteAdministration(@RequestBody Administration administration){
		administrationServices.deleteAdministration(administration);
		return ResponseEntity.ok(Map.of("Message","Administration supprime avec success!!!"));
	}
	@DeleteMapping("/deleteAdministrationById/{Id}")
	public ResponseEntity<?> deleteAdministrationById(@PathVariable("Id") Long id){
		administrationServices.deleteAdministrationById(id);
		return ResponseEntity.ok(Map.of("Message","Administration supprime avec success!!!"));
	}
}
