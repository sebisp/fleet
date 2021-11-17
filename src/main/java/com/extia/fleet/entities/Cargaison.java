package com.extia.fleet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.extia.fleet.utils.Charge;

@Entity
@Table(name="cargaisons")
public class Cargaison implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648236407257154500L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//id client
	@Column(name = "identifiant", nullable=false)
	private String identifiant;
	
	@ManyToOne
	@JoinColumn(name="entrepot_id", referencedColumnName = "id") 
	private Entrepot entrepot;
	
	@Column(name = "poids", nullable=false)
	private Float poids;

	public Cargaison() {
		super();
	}
	
	public Cargaison(String identifiant, Entrepot entrepot, Float poids) {
		super();
		this.identifiant = identifiant;
		this.entrepot = entrepot;
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Cargaison [id=" + id + ", identifiant=" + identifiant + ", poids=" + poids
				+ "]";
	}
	//permet de définir la capacité de charge nécessaire pour porter cette cargaison
	public static Integer getRequiredChargeStatus(Float poids) {
		if(poids <=100F)
			return Charge.leger.getChargeValue();
		else if (poids <=300F) {
			return Charge.moyen.getChargeValue();
		}
		else return Charge.lourd.getChargeValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Entrepot getEntrepot() {
		return entrepot;
	}

	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}
	
	
	
}
