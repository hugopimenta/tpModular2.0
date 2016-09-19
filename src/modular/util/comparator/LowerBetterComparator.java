package modular.util.comparator;

import java.util.Comparator;

import modular.athlete.Athlete;

public class LowerBetterComparator implements Comparator<Athlete> {

	public int compare(Athlete a1, Athlete a2) {
		double x = a1.getFinalResult();
		double y = a2.getFinalResult();

		if (Double.compare(x, y) == 0) {
			return a1.getName().compareTo(a2.getName());
		}
		return Double.compare(x, y);

	}

}