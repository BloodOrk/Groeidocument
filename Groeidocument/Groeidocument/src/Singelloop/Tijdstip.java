package Singelloop;

import java.io.Serializable;

/**
 * Write a description of class Deelnemer here.
 * 
 * @author Paul de Mast
 * @version 2010-10-04
 */

public class Tijdstip implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uren;
	private int minuten;
	private int seconden;

	/**
	 * Constructor for objects of class Tijdstip
	 */
	public Tijdstip(int uren, int minuten, int seconden) {
		this.uren = uren;
		this.minuten = minuten;
		this.seconden = seconden;
	}

	/**
	 * @result Het aantal seconden tussen this en het gegeven tijdstip.
	 */
	public int aantalSecondenTussen(Tijdstip anderTijdstip) {
		int begin = this.aantalSeconden();
		int einde = anderTijdstip.aantalSeconden();
		return Math.abs(einde - begin);
	}

	private int aantalSeconden() {
		return this.uren * 3600 + this.minuten * 60 + this.seconden;
	}
}
