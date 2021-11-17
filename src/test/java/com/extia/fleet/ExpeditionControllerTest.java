package com.extia.fleet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.extia.fleet.controller.ExpeditionController;
import com.extia.fleet.controller.TracteurController;
import com.extia.fleet.repositories.ExpeditionRepository;
import com.extia.fleet.repositories.TracteurRepository;

@SpringBootTest
public class ExpeditionControllerTest {

	@Autowired TracteurController tracteurController;
	@Autowired TracteurRepository tracteurRepo;
	@Autowired ExpeditionController expeditionController;
	@Autowired ExpeditionRepository expeditionRepo;
	
	@Test
	public void whenAssigningTractor_CheckThatTractorIsAvailable() {
		
	}
	
	@Test
	public void whenCreatingWithEmptyCargo_CheckThatError() {
		
	}
	
	@Test
	public void whenAssigningTractor_CheckThatTractorCapacityIsRespected() {
		
	}
	
	@Test
	public void whenChangingCargo_CheckThatTractorCapacityIsRespected() {
		
	}
	
	
	
}
