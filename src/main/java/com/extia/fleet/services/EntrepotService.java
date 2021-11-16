package com.extia.fleet.services;

import java.util.List;

import com.extia.fleet.entities.Entrepot;
/**
 * 
 * @author sebastien Spiess
 *
 */
public interface EntrepotService {

	// permet d'afficher tous les entrepots
	List<Entrepot> getAllEntrepots();

	// permet d'enregistrer un nouveau entrepot
	Entrepot saveEntrepot(Entrepot entrepot);

	// permet de rechercher un entrepot by id
	Entrepot getEntrepotById(Long id);

	// permet de modifier un entrepot existant
	Entrepot updateEntrepot(Entrepot entrepot);

	// permet de supprimer un entrepot de la flotte
	void deleteEntrepotById(Long id);

}
