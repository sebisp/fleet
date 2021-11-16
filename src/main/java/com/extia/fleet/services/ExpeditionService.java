package com.extia.fleet.services;

import java.util.List;

import com.extia.fleet.entities.Expedition;

public interface ExpeditionService {
	// permet d'afficher tous les expeditions
	List<Expedition> getAllExpeditions();

	// permet d'enregistrer un nouveau expedition
	Expedition saveExpedition(Expedition expedition);

	// permet de rechercher un expedition by id
	Expedition getExpeditionById(Long id);

	// permet de modifier un expedition existant
	Expedition updateExpedition(Expedition expedition);

	// permet de supprimer un expedition de la flotte
	void deleteExpeditionById(Long id);

}
