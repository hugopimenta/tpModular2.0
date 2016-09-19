package modular.sports;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modular.athletes.Athlete;
import modular.countries.Country;

public class Swimming extends Sport {

	private List<Double> results;

	public Swimming() {
		this.setId(2);
	}

	// faster between 3 shots
	protected void getResult(String option, List<Country> countriesList) {

		for (Athlete a : this.athleteList) { // run through all Athletes inside
												// list and set Final Result
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
				return Double.compare(x, y);

			}
		});

		if (Sport.MEDALS.equals(option)) {
			setMedals(countriesList);

		} else {
			printStandings();
		}
	}

}
