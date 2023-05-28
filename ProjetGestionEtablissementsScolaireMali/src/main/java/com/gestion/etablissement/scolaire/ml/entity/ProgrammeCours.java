package com.gestion.etablissement.scolaire.ml.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_ProgrammeCours")
public class ProgrammeCours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NomProgramme")
	private String nomProgramme;
	@Column(name = "NombreHeures")
	private Integer nombreHeures;
	
	public ProgrammeCours(String nomProgramme, Integer nombreHeures) {
		this.nomProgramme = nomProgramme;
		this.nombreHeures = nombreHeures;
	}
	public ProgrammeCours(Long id, String nomProgramme, Integer nombreHeures) {
		this(nomProgramme,nombreHeures);
		this.id = id;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomProgramme() {
		return nomProgramme;
	}
	public void setNomProgramme(String nomProgramme) {
		this.nomProgramme = nomProgramme;
	}
	public Integer getNombreHeures() {
		return nombreHeures;
	}
	public void setNombreHeures(Integer nombreHeures) {
		this.nombreHeures = nombreHeures;
	}
	@Override
	public String toString() {
		return "ProgrammeCours [id=" + id + ", nomProgramme=" + nomProgramme + ", nombreHeures=" + nombreHeures + "]";
	}
	public void presenteProgrammeCours() {
		System.out.println(toString());
	}
}
