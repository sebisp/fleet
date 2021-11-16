package com.extia.fleet.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.extia.fleet.entities.Tracteur;
import com.extia.fleet.services.TracteurService;
/**
 * 
 * @author sebastien
 *
 */
@RestController
@RequestMapping(path = "/tracteurs")
public class TracteurController {

	private TracteurService tracteurService;

	public TracteurController(TracteurService tracteurService) {
		super();
		this.tracteurService = tracteurService;
	}

	/**
	 * 
	 * @param model
	 * @return tous les tracteurs
	 */
	@GetMapping(path = "/", produces = "application/json")
	public List<Tracteur> listTracteurs(Model model) {
		return tracteurService.getAllTracteurs();
	}

	/**
	 * permet de sauver un nouveau tracteur
	 * 
	 * @param tracteur
	 * @return l'emplacement du tracteur
	 */
	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveTracteur(@RequestBody Tracteur tracteur) {
		tracteurService.saveTracteur(tracteur);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tracteur.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * permet de mettre à jour un tracteur
	 * 
	 * @param id
	 * @param tracteur
	 * @return le nouveau tracteur.toString()
	 */
	@PostMapping(path = "/edit/{id}", consumes = "application/json")
	public String updateTracteur(@PathVariable Long id, @RequestBody Tracteur tracteur) {

		// on cherche le tracteur by Id dans la base
		Tracteur existingTracteur = new Tracteur();;
		try {
			existingTracteur = tracteurService.getTracteurById(id);
		}  catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "tracteur not found";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		existingTracteur.setNom(tracteur.getNom());
		existingTracteur.setCharge(tracteur.getCharge());

		// on sauve les modifs, inutile grace au getById
		tracteurService.updateTracteur(existingTracteur);
		return existingTracteur.toString();
	}

	/**
	 * permet de supprimer un tracteur par son id
	 * 
	 * @param id
	 * @return un string pour valider que le tracteur a bien été supprimé
	 */
	@GetMapping("/{id}")
	public String deleteTracteur(@PathVariable Long id) {
		try {
			tracteurService.deleteTracteurById(id);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "tracteur not found";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "tracteur not deleted";
		}
		return "tracteur deleted";
	}

	/**
	 * on veut chercher un tracteur par son identifiant client
	 * 
	 * @param model
	 * @return le tracteur cherche
	 */
	@GetMapping("/getByLoad/{chargeMin}")
	public List<Tracteur> getTracteursByLoad(@PathVariable Integer chargeMin) {
		
		return tracteurService.findTracteursByLoad(chargeMin);
	}

}
