package com.gestion.etablissement.scolaire.ml.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.etablissement.scolaire.ml.entity.Notes;
import com.gestion.etablissement.scolaire.ml.services.NotesServices;

@RestController
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class NotesControlleur {
	@Autowired
	private NotesServices notesServices;
	@PostMapping("/saveNotes")
	public ResponseEntity<Notes> ajouterNotes(@RequestBody Notes notes){
		return new ResponseEntity<Notes>(notesServices.saveNotes(notes),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateNotes")
	public ResponseEntity<Notes> updateNotes(@RequestBody Notes notes){
		return new ResponseEntity<Notes>(notesServices.updateNotes(notes),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteNotes")
	public ResponseEntity<?> deleteNotes(@RequestBody Notes notes){
		notesServices.deleteNotes(notes);
		return ResponseEntity.ok(Map.of("Message ","Notes Supprime avec success!!!"));
	}
	@DeleteMapping("/deleteNotesById/{Id}")
	public ResponseEntity<?> deleteNotesById(@PathVariable("Id") Long id){
		notesServices.deleteNotesById(id);
		return ResponseEntity.ok(Map.of("Message","Note supprime avec success!!!!"));
	}
}
