package Singelloop;

import java.util.Comparator;

public class ComparatorOpGeboorteJaar implements Comparator<Deelname>

{

	public ComparatorOpGeboorteJaar()

	{

	}

	@Override

	public int compare(Deelname d1, Deelname d2)

	{

		int compare = 0;

		if (d1.geefGeboorteJaar() > d2.geefGeboorteJaar())

		{

			compare = -1;

		}

		else if (d1.geefGeboorteJaar() == d2.geefGeboorteJaar())

		{

			compare = 0;

		}

		else

		{

			compare = 1;

		}

		return compare;
	}
}