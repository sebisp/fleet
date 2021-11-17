package com.extia.fleet.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extia.fleet.entities.Expedition;
import com.extia.fleet.services.CargaisonService;
import com.extia.fleet.services.ExpeditionService;
import com.extia.fleet.services.TracteurService;
import com.extia.fleet.utils.ShippingStatus;
/**
 * 
 * @author sebastien SPIESS
 *
 */
@RestController
@RequestMapping(path="/expeditions")
public class ExpeditionController {
	
	private ExpeditionService expeditionService;
	private TracteurService tracteurService;
	private CargaisonService cargaisonService;

	public ExpeditionController(ExpeditionService expeditionService,TracteurService tracteurService, CargaisonService cargaisonService) {
		super();
		this.expeditionService = expeditionService;
		this.cargaisonService = cargaisonService;
		this.tracteurService= tracteurService;
	}
	
	/**
	 * 
	 * @param model
	 * @return toutes les expeditions
	 */
	@GetMapping(path = "/", produces = "application/json")
	public List<Expedition> listTracteurs(Model model) {
		return expeditionService.getAllExpeditions();
	}

	@GetMapping(path = "/new/{tracId}/{cargId}")
	public String saveExpedition(@PathVariable Long tracId,@PathVariable Long cargId) {
		//TODO:
		//devrait permettre de gérer la création d'une nouvelle expedition sans tracteur
		//TODO: Exception Handling
		
		Expedition shipping = new Expedition();
		//TODO: vérifier la disponibilité du tracteur : 
		// Select * from expedition e where e.tracteurId = tracId and e.status=L
		// si on a un résultat le tracteur n'est pas disponible
		
		shipping.setTracteur(tracteurService.getTracteurById(tracId));
		shipping.setCargaison(cargaisonService.getCargaisonById(cargId));
		shipping.setStatus(ShippingStatus.A.toString());
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shipping.getId())
//				.toUri();
		//return ResponseEntity.created(location).build();
		return "Expedition cree";
	}
}
