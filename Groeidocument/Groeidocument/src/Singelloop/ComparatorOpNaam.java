package Singelloop;

import java.util.Comparator;

public class ComparatorOpNaam implements Comparator<Deelname> {

	public ComparatorOpNaam() {

	}

	@Override

	public int compare(Deelname d1, Deelname d2)

	{

		return d1.geefDeelnemer().geefNaam().compareTo(d2.geefDeelnemer().geefNaam());

	}
}
