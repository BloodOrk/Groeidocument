/**
 * Write a description of class Deelname here.
 * 
 * @author Paul de Mast
 * @version 2010-10-04
 */
package Singelloop;

public class Deelname implements Comparable<Deelname> {
	// instance variables - replace the example below with your own
	private Deelnemer deelnemer;
	private Afstand afstand;
	private Tijdstip eindTijd;

	public Deelname(Deelnemer loper, Afstand poging) {
		this.deelnemer = loper;
		this.afstand = poging;
		this.eindTijd = null;

	}

	public Afstand geefAfstand() {
		return afstand;
	}

	public void zetEindtijd(Tijdstip eindTijd) {
		this.eindTijd = eindTijd;
	}

	public int geefStartNummer() {
		return deelnemer.geefStartNummer();
	}

	public int geefGeboorteJaar() {
		return deelnemer.geefGeboorteJaar();
	}

	public Deelnemer geefDeelnemer() {
		return deelnemer;
	}

	public float gemiddeldeSnelheid() {
		if (eindTijd == null) {
			// geef een ongeldige snelheid terug indien de eindtijd niet bekend
			// is.
			return -1;
		}

		else {
			int aantalMeter = afstand.geefAantalMeter();
			float aantalKm = (float) aantalMeter / 1000;

			Tijdstip startTijd = afstand.geefStartTijd();
			int gelopenTijdInSeconden = startTijd.aantalSecondenTussen(eindTijd);
			float aantalUur = (float) gelopenTijdInSeconden / 3600;

			float gemiddeldeSnelheid = aantalKm / aantalUur;

			return gemiddeldeSnelheid;
		}

	}

	@Override
	public int compareTo(Deelname d1) {
		// TODO Auto-generated method stub
		int i = 0;

		if (d1.geefAfstand().isGelijk(afstand))

		{

			if (eindTijd.aantalSecondenTussen(d1.eindTijd) > 0)

			{
				i = -1;
			}

			else if (eindTijd.aantalSecondenTussen(d1.eindTijd) == 0)

			{
				i = 0;
			}

			else

			{
				i = 1;
			}

		}
		return i;
	}

}
