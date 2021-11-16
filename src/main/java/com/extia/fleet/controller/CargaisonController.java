package com.extia.fleet.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extia.fleet.entities.Cargaison;
import com.extia.fleet.services.CargaisonService;

/**
 * 
 * @author Sebastien SPIESS
 *
 */

@RestController
@RequestMapping(path = "/cargaisons")
public class CargaisonController {

	private CargaisonService cargaisonService;

	public CargaisonController(CargaisonService cargaisonService) {
		super();
		this.cargaisonService = cargaisonService;
	}

	@GetMapping(path = "/", produces = "application/json")
	public List<Cargaison> listCargaisons(Model model) {
		return cargaisonService.getAllCargaisons();
	}

}
