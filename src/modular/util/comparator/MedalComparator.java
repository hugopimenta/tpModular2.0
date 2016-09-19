package modular.util.comparator;

import java.util.Comparator;

import modular.country.Country;

public class MedalComparator implements Comparator<Country> {

	public int compare(Country c1, Country c2) {
		int x[] = c1.getMedals();
		int y[] = c2.getMedals();
		if (x[0] == y[0]) {
			if (x[1] == y[1]) {
				if (x[2] == y[2]) {
					return c1.getName().compareTo(c2.getName());
				}
				return Integer.compare(y[2], x[2]);
			}
			return Integer.compare(y[1], x[1]);
		}
		return Integer.compare(y[0], x[0]);

	}

}