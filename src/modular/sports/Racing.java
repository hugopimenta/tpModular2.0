package modular.sports;

import modular.athletes.Athlete;
import modular.countries.Country;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Racing extends Sport {

	private List<Double> results;

	public Racing() {
		this.setId(1);
	}

	// faster in 3 runs
	protected void getResult(String option, List<Country> countriesList) {

		// run through all Athletes inside list and set Final Result
		for (Athlete a : this.athleteList) {
			results = a.getResults();

			double final_result = 10000;
			for (int i = 0; i < results.size(); i++) {

				if (results.get(i) <= final_result) {
					final_result = results.get(i);
				}
			}

			a.setFinalResult(final_result);

			// System.out.println(a.getName() + " " +final_result);

		}
		// print resultado poderiamos dividir isso em outra funcao?
		Collections.sort(this.athleteList, new Comparator<Athlete>() {

			public int compare(Athlete a1, Athlete a2) {
				double x = a1.getFinalResult();
				double y = a2.getFinalResult();
				return Double.compare(x, y); // Desempate alfabetico?

			}
		});

		if (Sport.MEDALS.equals(option)) {
			setMedals(countriesList);

		} else {
			printStandings();
		}
	}


}
