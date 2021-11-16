package com.extia.fleet.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extia.fleet.entities.Entrepot;
import com.extia.fleet.services.EntrepotService;

@RestController
@RequestMapping(path="/entrepots")
public class EntrepotController {

	private EntrepotService entrepotService;

	public EntrepotController(EntrepotService entrepotService) {
		super();
		this.entrepotService = entrepotService;
	}
	
	@GetMapping(path = "/", produces = "application/json")
	public List<Entrepot> listEntrepots(Model model) {
		return entrepotService.getAllEntrepots();
	}
	
	
}
