package com.extia.fleet.services;

import java.util.List;

import com.extia.fleet.entities.Cargaison;

public interface CargaisonService {

	// permet d'afficher tous les cargaisons
	List<Cargaison> getAllCargaisons();

	// permet d'enregistrer un nouveau cargaison
	Cargaison saveCargaison(Cargaison cargaison);

	// permet de rechercher un cargaison by id
	Cargaison getCargaisonById(Long id);

	// permet de modifier un cargaison existant
	Cargaison updateCargaison(Cargaison cargaison);

	// permet de supprimer un cargaison de la flotte
	void deleteCargaisonById(Long id);

}
