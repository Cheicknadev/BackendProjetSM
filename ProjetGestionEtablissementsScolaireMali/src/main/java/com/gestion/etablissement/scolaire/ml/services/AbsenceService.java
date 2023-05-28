package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Absences;
import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.entity.Enseignant;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.AbsenceRepository;

@Service
public class AbsenceService {
	@Autowired
	private AbsenceRepository absenceRepository;
	private EtudiantsServices etudiantsServices;
	private EnseignantServices enseignantServices;
	private AdministrationServices administrationServices;
	public Absences saveAbsence(Absences absence) {
		return absenceRepository.save(absence);
	}
	public Absences updateAbsence(Absences abscence) {
		return absenceRepository.saveAndFlush(abscence);
	}
	public void deleteAbsence(Absences absence) {
		absenceRepository.delete(absence);
	}
	public void deleteAbsenceById(Long id) {
		absenceRepository.deleteById(id);
	}
	public List<Absences> getAllAbsence(){
		return absenceRepository.findAll();
	}
	public List<Absences> getAbsenceByEtudiant(Etudiant etudiant){
		Etudiant etudiants = etudiantsServices.getEtudiantByNumeroMatricule(etudiant.getNumeroMatricule());
		return absenceRepository.findAbsencesByEtudiant(etudiants).orElseThrow(() -> new UserNotFoundException("Cet etudiant de numero matricule :" + etudiant.getNumeroMatricule()+"n'existe pas sorry!!!"));
	}
	public List<Absences> getAbsenceByEnseignant(Enseignant enseignant){
		Enseignant enseignants = enseignantServices.getEnseignantByMatricule(enseignant.getMatricule());
		return absenceRepository.findAbsencesByEnseignant(enseignants).orElseThrow(() -> new UserNotFoundException("Cet enseignant de matricule :" + enseignants.getMatricule()+"n'existe pas sorry!!!"));
	}
	public List<Absences> getAbsenceByAdministration(Administration administration){
		Administration administrations = administrationServices.getAdministrationById(administration.getId());
		return absenceRepository.findAbsencesByAdministration(administrations).orElseThrow(() -> new UserNotFoundException("Cette Absence n'existe pas sorry!!!"));
	}
	
}
