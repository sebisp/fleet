package com.extia.fleet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="entrepots")
public class Entrepot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8873944569480886920L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// id client
	@Column(name = "identifiant", nullable = false)
	private String identifiant;

	@OneToMany( targetEntity=Cargaison.class, mappedBy="entrepot" )
    private List<Cargaison> cargaisons = new ArrayList<>();
	
	public Entrepot() {
		super();
	}
	
	public Entrepot(String identifiant) {
		super();
		this.identifiant = identifiant;
	}

	@Override
	public String toString() {
		return "Entrepot [id=" + id + ", identifiant=" + identifiant + "]";
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

}
