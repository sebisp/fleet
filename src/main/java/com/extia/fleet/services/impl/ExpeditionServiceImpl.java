package com.extia.fleet.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.extia.fleet.AccessingApplication;
import com.extia.fleet.entities.Expedition;
import com.extia.fleet.repositories.ExpeditionRepository;
import com.extia.fleet.services.ExpeditionService;
/**
 * 
 * @author sebastien SPIESS
 *
 */
@Service
public class ExpeditionServiceImpl implements ExpeditionService {

	private static final Logger log = LoggerFactory.getLogger(AccessingApplication.class);
	private ExpeditionRepository expeditionRepository;

	public ExpeditionServiceImpl(ExpeditionRepository expeditionRepository) {
		this.expeditionRepository = expeditionRepository;
	}

	@Override
	public List<Expedition> getAllExpeditions() {
		log.info("getAllExpeditions");
		return expeditionRepository.findAll();
	}

	@Override
	public Expedition saveExpedition(Expedition expedition) {
		log.info("saveExpedition : " + expedition.toString());
		return expeditionRepository.save(expedition);
	}

	@Override
	public Expedition getExpeditionById(Long id) {
		log.info("getExpeditionById" + id.toString());
		return expeditionRepository.findById(id).get();
	}

	@Override
	public Expedition updateExpedition(Expedition expedition) {
		log.info("updateExpedition : " + expedition.toString());
		return expeditionRepository.save(expedition);
	}

	@Override
	public void deleteExpeditionById(Long id) {
		log.info("deleteExpeditionById :" + id.toString());
		expeditionRepository.deleteById(id);

	}

}
