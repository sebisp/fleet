package com.extia.fleet.services;

import java.util.List;

import com.extia.fleet.entities.Tracteur;

public interface TracteurService {
	// permet d'afficher tous les tracteurs
	List<Tracteur> getAllTracteurs();

	// permet d'enregistrer un nouveau tracteur
	Tracteur saveTracteur(Tracteur tracteur);

	// permet de rechercher un tracteur by id
	Tracteur getTracteurById(Long id);

	// permet de rechercher un tracteur par son dientifiant client
	Tracteur getTracteurByIdentifiant(String identifiant);

	// permet de modifier un tracteur existant
	Tracteur updateTracteur(Tracteur tracteur);

	// permet de supprimer un tracteur de la flotte
	void deleteTracteurById(Long id);

	// permet de rechercher les tracteurs capable de tirer une charge minimale
	List<Tracteur> findTracteursByLoad(int charge);

}
