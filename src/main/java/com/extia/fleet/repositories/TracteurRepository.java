package com.extia.fleet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extia.fleet.entities.Tracteur;

public interface TracteurRepository extends JpaRepository<Tracteur, Long>{
	
	
	List<Tracteur> findByChargeGreaterThanEqual(int charge);
	Tracteur findByIdentifiant(String identifiant);
}
