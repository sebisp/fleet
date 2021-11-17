package com.extia.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.extia.fleet.entities.Cargaison;
import com.extia.fleet.entities.Entrepot;
import com.extia.fleet.entities.Expedition;
import com.extia.fleet.entities.Tracteur;
import com.extia.fleet.repositories.CargaisonRepository;
import com.extia.fleet.repositories.EntrepotRepository;
import com.extia.fleet.repositories.ExpeditionRepository;
import com.extia.fleet.repositories.TracteurRepository;
import com.extia.fleet.utils.Charge;
import com.extia.fleet.utils.ShippingStatus;

@SpringBootApplication
public class AccessingApplication implements CommandLineRunner {
	//private static final Logger log = LoggerFactory.getLogger(AccessingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingApplication.class, args);
	}

	@Autowired
	TracteurRepository tracteurRepository;
	@Autowired
	EntrepotRepository entrepotRepository;
	@Autowired
	CargaisonRepository cargaisonRepository;
	@Autowired
	ExpeditionRepository expeditionRepository;

	@Override
	public void run(String... args) throws Exception {
		// on ajoute quelques tracteurs
		tracteurRepository.save(new Tracteur(Charge.leger.getChargeValue(), "Redone"));
		tracteurRepository.save(new Tracteur(Charge.moyen.getChargeValue(), "Blueone"));
		tracteurRepository.save(new Tracteur(Charge.moyen.getChargeValue(), "Yellowone"));
		tracteurRepository.save(new Tracteur(Charge.lourd.getChargeValue(), "Fatone"));
		tracteurRepository.save(new Tracteur(Charge.lourd.getChargeValue(), "BigOne"));
		// On ajoute quelques entrepots et leurs cargaisons
		Entrepot entrepot = new Entrepot("Lille");
		entrepotRepository.save(entrepot);
		cargaisonRepository.save(new Cargaison("PACK1", entrepot, 215.5F));
		cargaisonRepository.save(new Cargaison("PACK1B", entrepot, 1555.5F));
		entrepot = new Entrepot("Paris");
		entrepotRepository.save(entrepot);
		cargaisonRepository.save(new Cargaison("PACK2", entrepot, 315.5F));
		entrepot = new Entrepot("Strasbourg");
		entrepotRepository.save(entrepot);
		cargaisonRepository.save(new Cargaison("PACK4", entrepot, 15.5F));
		entrepot = new Entrepot("Rennes");
		entrepotRepository.save(entrepot);
		cargaisonRepository.save(new Cargaison("PACK5", entrepot, 8915.5F));
		entrepot = new Entrepot("Nice");
		entrepotRepository.save(entrepot);
		cargaisonRepository.save(new Cargaison("PACK6", entrepot, 515.5F));

		expeditionRepository.save(new Expedition(new Cargaison("PACK7", entrepot, 262.5F),
				new Tracteur(Charge.lourd.getChargeValue(), "Bigone"), ShippingStatus.A.toString()));
		expeditionRepository.save(new Expedition(new Cargaison("PACK8", entrepot, 42.3F),
				new Tracteur(Charge.leger.getChargeValue(), "Littleone"), ShippingStatus.A.toString()));

	}

//	@Bean
//	public CommandLineRunner demo(TracteurRepository repository) {
//		return (args) -> {
//			// on va charger quelques tracteurs
//			repository.save(new Tracteur(Charge.leger.getChargeValue(),"Redone"));
//			repository.save(new Tracteur(Charge.moyen.getChargeValue(), "Blueone"));
//			repository.save(new Tracteur(Charge.moyen.getChargeValue(), "Yellowone"));
//			repository.save(new Tracteur(Charge.lourd.getChargeValue(), "Fatone"));
//			repository.save(new Tracteur(Charge.lourd.getChargeValue(), "BigOne"));
//
//			// on vérifie qu'ils sont bien sauvés
//			log.info("Tracteurs found with findAll():");
//			log.info("-------------------------------");
//			for (Tracteur tracteur : repository.findAll()) {
//				log.info(tracteur.toString());
//			}
//			log.info("");
//
//			// on cherche un tracteur by ID
//			Tracteur tracteur = repository.findById(1L);
//			log.info("Tracteur found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(tracteur.toString());
//			log.info("");
//
//			// on cherche les tracteurs by charge
//			log.info("Tracteur found with findByCharge(2):");
//			log.info("--------------------------------------------");
//			repository.findByCharge(Charge.leger.getChargeValue()).forEach(trac -> {
//				log.info(trac.toString());
//			});
//			
//			log.info("");
//		};
//	}

}
