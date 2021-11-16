package com.extia.fleet.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.extia.fleet.AccessingApplication;
import com.extia.fleet.entities.Cargaison;
import com.extia.fleet.repositories.CargaisonRepository;
import com.extia.fleet.services.CargaisonService;

@Service
public class CargaisonServiceImpl implements CargaisonService {

	private CargaisonRepository cargaisonRepository;

	private static final Logger log = LoggerFactory.getLogger(AccessingApplication.class);

	public CargaisonServiceImpl(CargaisonRepository cargaisonRepository) {
		super();
		this.cargaisonRepository = cargaisonRepository;
	}

	@Override
	public Cargaison getCargaisonById(Long Id) {
		log.info("getCargaisonById id:" + Id.toString());
		return cargaisonRepository.findById(Id).get();
	}

	@Override
	public List<Cargaison> getAllCargaisons() {
		log.info("getAllCargaisons");
		return cargaisonRepository.findAll();
	}

	@Override
	public Cargaison saveCargaison(Cargaison cargaison) {
		log.info("saveCargaison : " + cargaison.toString());
		return cargaisonRepository.save(cargaison);
	}

	@Override
	public Cargaison updateCargaison(Cargaison cargaison) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCargaisonById(Long id) {
		// TODO Auto-generated method stub

	}

}
