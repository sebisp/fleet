package com.extia.fleet;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.extia.fleet.controller.TracteurController;
import com.extia.fleet.entities.Tracteur;
import com.extia.fleet.repositories.TracteurRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TracteurControllerTest {
	
	@Autowired
    private MockMvc mvc;

//    @Autowired
//    private WebApplicationContext webApplicationContext;
    
//    @MockBean
//    private TracteurService service;
	
	@Autowired TracteurController tracteurController;
	@Autowired TracteurRepository tracteurRepo;
	
//	@Before
//	public void setup(){
//	 mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
	
	@Test
	public void whenTracteursByLoad_thenReturnHeavyTractors() {
		var tracteurs = tracteurController.getTracteursByLoad(2);
		//on vérifie qu'il ya bien des éléments dans la liste
		Boolean testB = tracteurs.stream().filter(t->t.getCharge()>1).findAny().isPresent();
		assertThat(testB).isTrue();
		//il ya 5 éléments dans la liste
		assertThat(tracteurs).hasSize(5);
		
	}
	
	@Test
	public void whenUpdateTracteur_ThenTracteurUpdated() {
		Tracteur tractest =  tracteurRepo.findById(2L).get();
		assertThat(tractest).isNotNull();
		assertThat(tractest.getId()==2L).isTrue();
		Tracteur tracIn = new Tracteur(3,"littleOoone");
		tracteurController.updateTracteur(2L, tracIn);
		tractest =  tracteurRepo.findById(2L).get();
		assertThat(tractest).isNotNull();
		assertThat(tractest.getId()==2L).isTrue();
		assertThat(tractest.getCharge()==3).isNotNull();
		assertThat(tractest.getNom().equals("littleOoone")).isTrue();
		
	}
	
	@Test
	public void whenDeleteTracteur_ThenTracteurDeleted() {
		Tracteur tractest =  tracteurRepo.findById(2L).get();
		assertThat(tractest).isNotNull();
		assertThat(tractest.getId()==2L).isTrue();
		tracteurController.deleteTracteur(2L);
		Optional<Tracteur> tracDeleted =  tracteurRepo.findById(2L);
		assertThat(tracDeleted.isEmpty()).isTrue();

	}
	
//	@Test
//	public void restMethodTest() throws Exception {
//		
//		mvc.perform(MockMvcRequestBuilders.get("/tracteurs").contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isOk());
//		
//	}

}
