package com.extia.fleet.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.extia.fleet.entities.Entrepot;
import com.extia.fleet.repositories.EntrepotRepository;
import com.extia.fleet.services.EntrepotService;

@Service
public class EntrepotServiceImpl implements EntrepotService{

	private EntrepotRepository entrepotRepo;
	
	public EntrepotServiceImpl(EntrepotRepository entrepotRepo) {
		super();
		this.entrepotRepo = entrepotRepo;
	}
	
	@Override
	public List<Entrepot> getAllEntrepots() {
		return entrepotRepo.findAll();
	}

	@Override
	public Entrepot saveEntrepot(Entrepot entrepot) {
		return entrepotRepo.save(entrepot);
	}

	@Override
	public Entrepot getEntrepotById(Long id) {
		return entrepotRepo.findById(id).get();
	}

	@Override
	public Entrepot updateEntrepot(Entrepot entrepot) {
		return entrepotRepo.save(entrepot);
	}

	@Override
	public void deleteEntrepotById(Long id) {
		entrepotRepo.deleteById(id);
		
	}

	

}
