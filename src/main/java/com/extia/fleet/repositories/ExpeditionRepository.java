package com.extia.fleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extia.fleet.entities.Expedition;

public interface ExpeditionRepository extends JpaRepository<Expedition, Long>{

}
