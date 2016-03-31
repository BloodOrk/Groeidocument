package Singelloop;

import java.io.Serializable;

/**
 * Write a description of class Deelnemer here.
 * 
 * @author Paul de Mast
 * @version 2010-10-04
 */
public class Deelnemer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// startnummers voor de singelloop beginnen van nr 1
	private static final int startnummer = 1;

	private String naam;
	private boolean isVrouw;
	private int geboorteJaar;
	private int startNummer;

	/**
	 * Constructor for objects of class Deelnemer
	 */
	public Deelnemer(String naam, boolean isVrouw, int geboorteJaar) {
		this.naam = naam;
		this.isVrouw = isVrouw;
		this.geboorteJaar = geboorteJaar;
		this.startNummer = startnummer;
		startNummer++;
	}

	public int geefStartNummer() {
		return startNummer;
	}

	public int geefGeboorteJaar() {
		return geboorteJaar;
	}

	public String geefNaam() {
		return naam;
	}

	@Override

	public boolean equals(Object obj) {

		// null instanceof Object will always return false

		if (!(obj instanceof Deelnemer))
			return false;
		if (obj == this)
			return true;
		return this.startNummer == ((Deelnemer) obj).startNummer;
	}

	public int hashCode() {
		return startNummer;
	}

}
