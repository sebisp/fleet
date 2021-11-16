package com.extia.fleet.utils;

public enum ShippingStatus {
	
	A("En Attente"),L("Livraison en Cours"),T("Terminé");
	
	private String Statut;

	private ShippingStatus(String statut) {
		Statut = statut;
	}

	public String getStatut() {
		return Statut;
	}
	
	
	
}
