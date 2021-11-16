package com.extia.fleet.utils;

public enum Charge {
	leger(1), moyen(2), lourd(3);

	public final int chargeValue;

	private Charge(int val) {
		this.chargeValue = val;
	}

	public int getChargeValue() {
		return chargeValue;
	}

	public static Charge getLibelle(int charge) {

		for (Charge c : Charge.values()) {
			if (c.chargeValue==charge) {
				return c;
			}
		}
		return null;

	}

}
