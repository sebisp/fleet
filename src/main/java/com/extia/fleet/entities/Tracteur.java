package com.extia.fleet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extia.fleet.utils.Charge;

@Entity
@Table(name = "tracteurs")
public class Tracteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3746097697349924271L;

	// cet id est généré et n'est pas modifiable
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "charge", nullable = false)
	private Integer charge;

	// identifiant client à ne pas confondre avec l'id généré
	@Column(name = "identifiant", nullable = false, unique = true)
	private String identifiant;

	public Tracteur(Integer charge, String identifiant) {
		super();
		this.charge = charge;
		this.identifiant = identifiant;
	}

	public Tracteur() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Tracteur[id=%d, identifiant='%s', charge='%x']", id, identifiant, charge);
	}

	// permet de récupérer le libellé de la charge transportable
	public String getChargeLibelle() {
		return Charge.getLibelle(charge).toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public String getNom() {
		return identifiant;
	}

	public void setNom(String identifiant) {
		this.identifiant = identifiant;
	}

}
