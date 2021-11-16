package com.extia.fleet.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.extia.fleet.utils.ShippingStatus;
/**
 * 
 * @author Sebastien SPIESS
 *
 */
@Entity
@Table(name="expeditions")
public class Expedition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7959954237846536462L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST) @JoinColumn(name="cargaison_id")
	private Cargaison cargaison;
	
	@ManyToOne(cascade = CascadeType.PERSIST) @JoinColumn(name="tracteur_id")
	private Tracteur tracteur;
	
	@Column(name="status")
	private String status;
	
	public Expedition() {
		super();
	}
	
	public Expedition(Cargaison cargaison, Tracteur tracteur, String status) {
		super();
		this.cargaison = cargaison;
		this.tracteur = tracteur;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expedition [id=" + id + ", cargaison=" + cargaison + ", tracteur=" + tracteur + ", status=" + status
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

	public Tracteur getTracteur() {
		return tracteur;
	}

	public void setTracteur(Tracteur tracteur) {
		this.tracteur = tracteur;
	}

	public String getStatus() {
		return status;
	}
	
	public String getStatusLibelle() {
		return ShippingStatus.valueOf(this.status).getStatut();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
}
