package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name = "T_Etudiant",uniqueConstraints = {@UniqueConstraint(columnNames = "numeroMatricule")})
public class Etudiant extends Users{
	@Column(name = "NumeroMatricule")
	private String numeroMatricule;
	@Column(name = "Promotion")
	private String promotion;
	@Column(name = "ExtraitImage")
	private String extraitImage;
	@Column(name = "codePostal")
	private String codePostal;
	@Column(name = "ville")
	private String villeEtudiant;
	@Column(name = "lieuNaissance")
	private String lieuDeNaissance;
	@Column(name = "nomPere")
	private String nomPere;
	@Column(name = "profPere")
	private String profPere;
	@Column(name = "nomMere")
	private String nomMere;
	@Column(name = "profMere")
	private String profMere;
	@Column(name = "tuteur")
	private String tuteur;
	@Column(name = "profTuteur")
	private String profTuteur;
	@Column(name = "quartier")
	private String quartier;
	@Column(name = "carre")
	private String carre;
	@Column(name = "concession")
	private String concession;
	@Column(name = "codeEtablissmente")
	private String codeEtablissement;
	@Column(name = "etablissement")
	private String etablissement;
	@Column(name = "cintuteur")
	private String cintuteur;
	@Column(name = "Genre")
	private Genre genre;
	@Column(name = "codeNationalite")
	private String codeNationalite;
	@Column(name = "telTuteur")
	private String telTuteur;
	@Column(name = "anneeEntreEtudiant")
	private int anneeEntreEtudiant;
	@Column(name = "DomaineExercer")
	private String domaineExercer;
	@Column(name = "Specialite")
	private String specialite;
	@Column(name = "NiveauEtude")
	private String niveauEtude;
	@OneToMany(mappedBy = "nom",fetch = FetchType.LAZY)
	private Set<Livres> livres = new HashSet<>();
	
	public Etudiant() {}
	public Etudiant(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance, String imageUsers) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance, imageUsers);
	}
	public Etudiant(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance, String imageUsers,String promotion,String numeroMatri) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance, imageUsers);
		this.numeroMatricule = numeroMatri;
		this.promotion = promotion;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getNumeroMatricule() {
		return numeroMatricule;
	}
	public void setNumeroMatricule(String numeroMatricule) {
		this.numeroMatricule = numeroMatricule;
	}
	public String getExtraitImage() {
		return extraitImage;
	}
	public void setExtraitImage(String extraitImage) {
		this.extraitImage = extraitImage;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVilleEtudiant() {
		return villeEtudiant;
	}
	public void setVilleEtudiant(String villeEtudiant) {
		this.villeEtudiant = villeEtudiant;
	}
	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}
	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}
	public String getNomPere() {
		return nomPere;
	}
	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}
	public String getProfPere() {
		return profPere;
	}
	public void setProfPere(String profPere) {
		this.profPere = profPere;
	}
	public String getNomMere() {
		return nomMere;
	}
	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}
	public String getProfMere() {
		return profMere;
	}
	public void setProfMere(String profMere) {
		this.profMere = profMere;
	}
	public String getTuteur() {
		return tuteur;
	}
	public void setTuteur(String tuteur) {
		this.tuteur = tuteur;
	}
	public String getProfTuteur() {
		return profTuteur;
	}
	public void setProfTuteur(String profTuteur) {
		this.profTuteur = profTuteur;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getCarre() {
		return carre;
	}
	public void setCarre(String carre) {
		this.carre = carre;
	}
	public String getConcession() {
		return concession;
	}
	public void setConcession(String concession) {
		this.concession = concession;
	}
	public String getCodeEtablissement() {
		return codeEtablissement;
	}
	public void setCodeEtablissement(String codeEtablissement) {
		this.codeEtablissement = codeEtablissement;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getCintuteur() {
		return cintuteur;
	}
	public void setCintuteur(String cintuteur) {
		this.cintuteur = cintuteur;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = Genre.valueOf(genre);
	}
	public String getCodeNationalite() {
		return codeNationalite;
	}
	public void setCodeNationalite(String codeNationalite) {
		this.codeNationalite = codeNationalite;
	}
	public String getTelTuteur() {
		return telTuteur;
	}
	public void setTelTuteur(String telTuteur) {
		this.telTuteur = telTuteur;
	}
	public int getAnneeEntreEtudiant() {
		return anneeEntreEtudiant;
	}
	public void setAnneeEntreEtudiant(int anneeEntreEtudiant) {
		this.anneeEntreEtudiant = anneeEntreEtudiant;
	}
	public String getDomaineExercer() {
		return domaineExercer;
	}
	public void setDomaineExercer(String domaineExercer) {
		this.domaineExercer = domaineExercer;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public Set<Livres> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livres> livres) {
		this.livres = livres;
	}
	
}
