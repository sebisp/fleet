package com.extia.fleet.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.extia.fleet.AccessingApplication;
import com.extia.fleet.entities.Tracteur;
import com.extia.fleet.repositories.TracteurRepository;
import com.extia.fleet.services.TracteurService;

@Service
public class TracteurServiceImpl implements TracteurService {
	private static final Logger log = LoggerFactory.getLogger(AccessingApplication.class);

	private TracteurRepository tracteurRepository;

	public TracteurServiceImpl(TracteurRepository tracteurRepository) {
		super();
		this.tracteurRepository = tracteurRepository;
	}

	@Override
	public List<Tracteur> getAllTracteurs() {
		log.info("getAllTracteurs");
		return tracteurRepository.findAll();
	}

	@Override
	public Tracteur saveTracteur(Tracteur tracteur) {
		log.info("saveTracteur : "+tracteur.toString());
		return tracteurRepository.save(tracteur);
	}

	@Override
	public Tracteur getTracteurById(Long id) {
		log.info(" getTracteurById : "+id.toString());
		return tracteurRepository.findById(id).get();
	}

	@Override
	public Tracteur updateTracteur(Tracteur tracteur) {
		log.info("updateTracteur : "+tracteur.toString());
		return tracteurRepository.save(tracteur);
	}

	@Override
	public void deleteTracteurById(Long id) {
		log.info("deleteTracteurById : "+id.toString());
		tracteurRepository.deleteById(id);
	}

	@Override
	public List<Tracteur> findTracteursByLoad(int charge) {
		log.info("findTracteursByLoad : charge >= " + String.valueOf(charge));
		return tracteurRepository.findByChargeGreaterThanEqual(charge);
	}

	@Override
	public Tracteur getTracteurByIdentifiant(String identifiant) {
		log.info("getTracteurByIdentifiant : "+identifiant);
		return tracteurRepository.findByIdentifiant(identifiant);
	}

}
