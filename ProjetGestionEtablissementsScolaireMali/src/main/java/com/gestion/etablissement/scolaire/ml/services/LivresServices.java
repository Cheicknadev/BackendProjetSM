package com.gestion.etablissement.scolaire.ml.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Empreinte;
import com.gestion.etablissement.scolaire.ml.entity.Livres;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.LivresRepository;

@Service
public class LivresServices {
	@Autowired
	private LivresRepository livresRepository;
	
	public List<Livres> getAllLivres(){
		return livresRepository.findAll();
	}
	public Livres saveLivres(Livres livres) {
		return livresRepository.save(livres); 
	}
	public Livres updatelivres(Livres livres) {
		return livresRepository.saveAndFlush(livres);
	}
	public Livres getLivresByNom(String nom) {
		return livresRepository.findLivresByNom(nom).orElseThrow(() ->new UserNotFoundException("Ce livres de Nom "+nom+"n'existe pas!!!"));
	}
	public Livres getLivresByDesignation(String designation) {
		return livresRepository.findLivresByDesignation(designation).orElseThrow(() ->new UserNotFoundException("ce livre de designation "+designation+"n'existe pas sorry!!!"));
	}
	public List<Livres> getListLivresDisponible(String empreinte){
		return livresRepository.findLivresByEmpreinte(empreinte).orElseThrow(() ->new UserNotFoundException("Pas de livres "+ empreinte+"!!!"));
	}
	public Livres getLivresByPrix(Double prix) {
		return livresRepository.findLivresByPrixEmpreinte(prix).orElseThrow(() ->new UserNotFoundException("ce livre de prix "+prix+"n'existe pas sorry!!!"));
	}
	public List<Livres> getAllLivresByNomAuteur(String nomAuteur){
		return livresRepository.findAllLivresByNomAuteur(nomAuteur).orElseThrow(() -> new UserNotFoundException("ce Livre de Nom Auteur " + nomAuteur+ "n'existe pas sorry!!!")); 
	}
	public void deleteLivresById(Long id) {
		livresRepository.deleteById(id);
	}
	public void deleteLivres(Livres liv) {
		livresRepository.delete(liv);
	}
	public Double getPrixLivre(Livres livres) {
		return livres.getPrixEmpreinte();
	}
	public Empreinte getEtatEmpreinteLivre(String nomLivre) {
		return getLivresByNom(nomLivre).getEmpreinte();
	}
	public Date methodeDate(String date) throws ParseException {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsedDate = format.parse(date);
	    return parsedDate;
	  }

	public boolean getverificationEmpreinte(Livres livres) {
		boolean statut = false;
		LocalDate dateCourant = LocalDate.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = dateCourant.format(formater);
		Livres liv = getLivresByDesignation(livres.getDesignation());
		if(liv.getEmpreinte().name().compareTo(livres.getDateEmpreinte().toString())==0) {
			try {
				statut = liv.getDateRendu().after(methodeDate(dateString));
				return statut;
			} catch (ParseException e) {	
				e.printStackTrace();
			}	
		}
		return statut;
	}
}
