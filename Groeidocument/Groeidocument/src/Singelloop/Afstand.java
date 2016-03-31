package Singelloop;

import java.io.Serializable;

/**
 * Write a description of class Afstand here.
 * 
 * @author Paul de Mast
 * @version 2010-10-04
 */

public class Afstand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aantalMeter;
	private Tijdstip startTijd;

	/**
	 * Constructor for objects of class Afstand
	 */
	public Afstand(int aantalMeter, Tijdstip startTijd) {
		this.aantalMeter = aantalMeter;
		this.startTijd = startTijd;
	}

	public boolean isGelijk(Afstand ander) {
		return (this.aantalMeter == ander.aantalMeter) && (this.startTijd == ander.startTijd);

	}

	public Tijdstip geefStartTijd() {
		return startTijd;
	}

	public int geefAantalMeter() {
		return aantalMeter;
	}

}
