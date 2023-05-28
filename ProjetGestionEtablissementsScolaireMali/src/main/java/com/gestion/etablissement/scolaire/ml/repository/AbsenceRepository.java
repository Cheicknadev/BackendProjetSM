package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Absences;
import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.entity.Enseignant;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;

public interface AbsenceRepository extends JpaRepository<Absences, Long> {

	Optional<List<Absences>> findAbsencesByEtudiant(Etudiant etudiants);

	Optional<List<Absences>> findAbsencesByEnseignant(Enseignant enseignants);

	Optional<List<Absences>> findAbsencesByAdministration(Administration administrations);
}
