package Singelloop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a description of class Singelloop here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Singelloop implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Deelname> deelnames;

	public Singelloop() {
		deelnames = new ArrayList<Deelname>();

	}

	public void voegDeelnameToe(Deelname deelname) {
		deelnames.add(deelname);
	}

	public int aantalDeelnemers(Afstand afstand) {
		int aantal = 0;

		for (Deelname deelname : deelnames) {
			if (afstand.isGelijk(deelname.geefAfstand())) {
				aantal++;
			}
		}

		return aantal;

	}

	/*
	 * deelNemersVanAfstand is een hulpmethode, die gebuikt wordt voor snelste,
	 * langzaamste en gemiddelde tijden van een afstand
	 */
	private ArrayList<Deelname> deelnamesVanAfstand(Afstand afstand) {
		ArrayList<Deelname> deelnamesVanAfstand = new ArrayList<Deelname>();

		for (Deelname deelname : deelnames) {
			if (afstand.isGelijk(deelname.geefAfstand())) {
				deelnamesVanAfstand.add(deelname);
			}
		}

		return deelnamesVanAfstand;

	}

	public Deelname bepaalSnelste(Afstand afstand) {
		ArrayList<Deelname> deelNemersAfstand = deelnamesVanAfstand(afstand);
		float hoogsteGemiddeldeSnelheid = -1.0f; // Integer.MAX_VALUE
		Deelname snelsteDeelname = null;

		for (Deelname deelname : deelNemersAfstand) {
			if (deelname.gemiddeldeSnelheid() > hoogsteGemiddeldeSnelheid) {
				hoogsteGemiddeldeSnelheid = deelname.gemiddeldeSnelheid();
				snelsteDeelname = deelname;
			}
		}

		return snelsteDeelname;
	}

	public Deelname bepaalLangzaamste(Afstand afstand) {
		ArrayList<Deelname> deelnamesVanAfstand = deelnamesVanAfstand(afstand);
		float langzaamsteGemiddeldeSnelheid = Float.MAX_VALUE;
		Deelname langzaamsteDeelname = null;

		for (Deelname deelname : deelnamesVanAfstand) {
			if (deelname.gemiddeldeSnelheid() < langzaamsteGemiddeldeSnelheid) {
				langzaamsteGemiddeldeSnelheid = deelname.gemiddeldeSnelheid();
				langzaamsteDeelname = deelname;
			}
		}

		return langzaamsteDeelname;
	}

	public void uniekeGeboorteJaren(ArrayList<Deelname> deelnames) {
		for (Deelname d : deelnames) {
			Set<Integer> uniek = new HashSet<Integer>();
			if (uniek.size() == 0)
				uniek.add(d.geefGeboorteJaar());
			else {
				for (int gd : uniek) {
					if (gd == d.geefGeboorteJaar())
						continue;
					else
						uniek.add(d.geefGeboorteJaar());
				}
			}
		}
	}

	public void save(String filename) {
		try {
			OutputStream os = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public float bepaalGemiddelde(Afstand afstand) {
		ArrayList<Deelname> deelnamesVanAfstand = deelnamesVanAfstand(afstand);
		float somGemiddeldeSnelheid = 0.0f;

		for (Deelname deelname : deelnamesVanAfstand) {
			somGemiddeldeSnelheid += deelname.gemiddeldeSnelheid();
		}
		float gemiddeldeSnelheid = somGemiddeldeSnelheid / deelnamesVanAfstand.size();
		return somGemiddeldeSnelheid;
	}

	public int positieDeelnemer(int startNummer) {
		Deelname deelNameVanStartNummer = null;

		for (Deelname deelname : deelnames) {
			if (deelname.geefStartNummer() == startNummer) {
				deelNameVanStartNummer = deelname;
			}
		}

		// Indien ongeldig startNummer geef dan een ongeldige positie terug.
		if (deelNameVanStartNummer == null) {
			return -1;
		} else {
			int positie = 1;
			for (Deelname deelname : deelnames) {
				if (deelname.geefAfstand().isGelijk(deelNameVanStartNummer.geefAfstand())
						&& deelname.gemiddeldeSnelheid() > deelNameVanStartNummer.gemiddeldeSnelheid()) {
					positie++;
				}
			}
			return positie;
		}
	}

	public int[] geefAantalDeelnamesPerGeboorteJaar() {
		// Indien er geen inschrijvingen zijn, geef dan een lege array terug:
		if (deelnames == null || deelnames.size() == 0) {
			int[] geenDeelnemers = new int[0];
			return geenDeelnemers;
		}

		int geboorteJaarOudsteDeelnemer = geefGeboorteJaarOudsteDeelnemer();
		int geboorteJaarJongsteDeelnemer = geefGeboorteJaarJongsteDeelnemer();

		int[] aantalDeelnamesPerGeboorteJaar = new int[geboorteJaarJongsteDeelnemer - geboorteJaarOudsteDeelnemer + 1];
		for (int i = 0; i < aantalDeelnamesPerGeboorteJaar.length; i++) {
			aantalDeelnamesPerGeboorteJaar[i] = 0;
		}

		for (Deelname deelname : deelnames) {
			aantalDeelnamesPerGeboorteJaar[deelname.geefGeboorteJaar() - geboorteJaarOudsteDeelnemer]++;
		}

		return aantalDeelnamesPerGeboorteJaar;
	}

	@SuppressWarnings({ "unchecked" })
	public ArrayList<Deelname>[] geefDeelnamesPerGeboorteJaar() {
		// Indien er geen inschrijvingen zijn, geef dan een lege array terug:
		if (deelnames == null || deelnames.size() == 0) {
			ArrayList<Deelname>[] geenDeelnemers = new ArrayList[0];
			return geenDeelnemers;
		}

		int geboorteJaarOudsteDeelnemer = geefGeboorteJaarOudsteDeelnemer();
		int geboorteJaarJongsteDeelnemer = geefGeboorteJaarJongsteDeelnemer();

		ArrayList<Deelname>[] deelnamesPerGeboorteJaar = new ArrayList[geboorteJaarJongsteDeelnemer
				- geboorteJaarOudsteDeelnemer + 1];
		for (int i = 0; i < deelnamesPerGeboorteJaar.length; i++) {
			deelnamesPerGeboorteJaar[i] = new ArrayList<Deelname>();
		}

		for (Deelname deelname : deelnames) {
			deelnamesPerGeboorteJaar[deelname.geefGeboorteJaar() - geboorteJaarOudsteDeelnemer].add(deelname);
		}

		return deelnamesPerGeboorteJaar;
	}

	public int geefGeboorteJaarOudsteDeelnemer() {
		int geboorteJaarOudsteDeelnemer = Integer.MAX_VALUE;

		for (Deelname deelname : deelnames) {
			if (deelname.geefGeboorteJaar() < geboorteJaarOudsteDeelnemer) {
				geboorteJaarOudsteDeelnemer = deelname.geefGeboorteJaar();
			}
		}

		return geboorteJaarOudsteDeelnemer;
	}

	private int geefGeboorteJaarJongsteDeelnemer() {
		int geboorteJaarJongsteDeelnemer = Integer.MIN_VALUE;

		for (Deelname deelname : deelnames) {
			if (deelname.geefGeboorteJaar() > geboorteJaarJongsteDeelnemer) {
				geboorteJaarJongsteDeelnemer = deelname.geefGeboorteJaar();
			}
		}

		return geboorteJaarJongsteDeelnemer;
	}

	public List<Deelname> geefDeelnames() {
		// TODO Auto-generated method stub
		return deelnames;
	}
}
