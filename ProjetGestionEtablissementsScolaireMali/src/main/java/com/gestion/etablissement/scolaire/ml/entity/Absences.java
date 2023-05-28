package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Absence")
public class Absences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DateAbsence")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateAbsence;
	@Column(name = "Presence")
	private Present presence;
	@OneToOne
	private Cours cours;
	@OneToOne
	private Etudiant etudiant;
	@OneToOne
	private Enseignant enseignant;
	@OneToOne
	private Administration administration;
	
	public Absences(Date dateAbsence, Present presence, Etudiant etudiant) {
		this.dateAbsence = dateAbsence;
		this.presence = presence;
		this.etudiant = etudiant;
	}

	public Absences(Date dateAbsence, Present presence, Cours cours, Etudiant etudiant) {
		this(dateAbsence,presence,etudiant);
		this.cours = cours;
	}
	public Absences(Date dateAbsence, Present presence, Administration administration) {
		super();
		this.dateAbsence = dateAbsence;
		this.presence = presence;
		this.administration = administration;
	}

	public Absences(Date dateAbsence, Present presence, Enseignant enseignant) {
		super();
		this.dateAbsence = dateAbsence;
		this.presence = presence;
		this.enseignant = enseignant;
	}

	public Absences(Long id, Date dateAbsence, Etudiant etudiant, Enseignant enseignant) {
		this.id = id;
		this.dateAbsence = dateAbsence;
		this.etudiant = etudiant;
		this.enseignant = enseignant;
	}
	
}
