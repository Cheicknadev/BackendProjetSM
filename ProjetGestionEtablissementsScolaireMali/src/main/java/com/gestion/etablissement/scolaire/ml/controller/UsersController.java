																																																						package com.gestion.etablissement.scolaire.ml.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.etablissement.scolaire.ml.confFile.ConfigurationFileDataBase;
import com.gestion.etablissement.scolaire.ml.entity.Users;
import com.gestion.etablissement.scolaire.ml.services.UsersServices;
@org.springframework.stereotype.Controller
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class UsersController {
	@Autowired
	private UsersServices usersServices;
	private Users usersConnecte;
	public Users getUsersConnecte() {
		return usersConnecte;
	}
	public void setUsersConnecte(Users usersConnecte) {
		this.usersConnecte = usersConnecte;
	}
	/*************************************Gestion des Users************************************************************/
	@PostMapping(path = "/creationDBUsers/{File}", consumes = {"multipart/form-data"})
	public ResponseEntity<?> createDataBasesUsers(@RequestParam("File") MultipartFile file){
		if(ConfigurationFileDataBase.isExcelFile(file)) {
			try {
				ConfigurationFileDataBase.createDataBaseUsers(file.getInputStream());
				return ResponseEntity.ok(Map.of("Message","La base est cree avec success"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().body("Mauvais requeste la base n'est pas creer sorrry!!!");
	}
	@PostMapping("/saveUsers")//, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Users> ajouterUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.saveUserss(users),HttpStatus.CREATED);
	}
	@PutMapping("/updateUsers")
	public ResponseEntity<Users> updateUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.updateUsers(users),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersServices.getAllUsers(),HttpStatus.OK);
	}
	@GetMapping("/getUsersByEmail/{Email}")
	public ResponseEntity<Users> getUsersByEmail(@PathVariable("Email") String email){
		return new ResponseEntity<Users>(usersServices.getUsersByEmail(email),HttpStatus.OK);
	}
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<?> deleteUsers(@RequestBody Users users){
		usersServices.deleteUsers(users);
		return ResponseEntity.ok(Map.of("Message","Cet utilisateur a ete supprime avec  success!!!"));
	}
	@DeleteMapping("/deleteUsersById/{Id}")
	public ResponseEntity<HttpStatus> deleteUsersById(@PathVariable("Id") Long id){
		usersServices.deleteUsersById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping(value="/getUsersByTypeUsers",params= {"email","password"})
	public ResponseEntity<String> getUsersByTypeUsers(@RequestParam String email,@RequestParam String password){
		return new ResponseEntity<String>(usersServices.getTypesUsers(email, password),HttpStatus.OK);
	}
	@GetMapping("/getUsersById/{Id}")
	public ResponseEntity<Users> getUsersById(@PathVariable("Id") Long id){
		return new ResponseEntity<Users>(usersServices.getUsersById(id),HttpStatus.OK);
	}
}
