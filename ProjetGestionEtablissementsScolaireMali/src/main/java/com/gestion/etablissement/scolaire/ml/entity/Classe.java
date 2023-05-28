package com.gestion.etablissement.scolaire.ml.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Classe")
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "Description")
	private String description;
	@Column(name = "Abrege")
	private String abrege;
	@Column(name = "Effective")
	private Integer effective;
	@OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)
	private Set<Etudiant> etudiant = new HashSet<>();
	public Classe() {}
	public Classe(String libelle, String description) {
		this.libelle = libelle;
		this.description = description;
	}
	public Classe(String libelle, String description, String abrege) {
		this(libelle,description);
		this.abrege = abrege;
	}
	public Classe(Long id, String libelle, String description) {
		this(libelle,description);
		this.id = id;
	}
	public Classe( String libelle, String description, String abrege,
			Set<Etudiant> etudiant) {
		this(libelle,description,abrege);
		this.etudiant = etudiant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getEffective() {
		return effective;
	}
	public void setEffective(Integer effective) {
		this.effective = etudiant.size();
	}
	public String getAbrege() {
		return abrege;
	}
	public void setAbrege(String abrege) {
		this.abrege = abrege;
	}
	public Set<Etudiant> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Set<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", libelle=" + libelle + ", description=" + description + "]";
	}
	public void presenteClasse() {
		System.out.println(toString());
	}
	
}
