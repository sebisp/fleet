package com.extia.fleet.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extia.fleet.entities.Expedition;
import com.extia.fleet.services.ExpeditionService;

@RestController
@RequestMapping(path="/expeditions")
public class ExpeditionController {
	
	private ExpeditionService expeditionService;

	public ExpeditionController(ExpeditionService expeditionService) {
		super();
		this.expeditionService = expeditionService;
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

}
