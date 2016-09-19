package modular.sports;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modular.athletes.Athlete;
import modular.countries.Country;

public class Gymnastic extends Sport {

	private List<Double> results;

	public Gymnastic() {
		this.setId(5);
	}

	// higher score in 5 tries
	protected void getResult(String option, List<Country> countriesList) {

		// run through all Athletes inside, list and set Final Result
		for (Athlete athlete : this.athleteList) {

			results = athlete.getResults();

			double final_result_aux = 0;
			double final_result = 0;
			for (int i = 0; i < results.size(); i++) {

				final_result_aux += results.get(i);
			}
			final_result = final_result_aux / results.size();

			athlete.setFinalResult(final_result);

			// System.out.println(a.getName() + " " +final_result);

		}
		// print resultado poderiamos dividir isso em outra funcao?
		Collections.sort(this.athleteList, new Comparator<Athlete>() {

			public int compare(Athlete a1, Athlete a2) {
				double x = a1.getFinalResult();
				double y = a2.getFinalResult();
				return Double.compare(y, x); // Desempate alfabetico?

			}
		});

		if (Sport.MEDALS.equals(option)) {
			setMedals(countriesList);

		} else {
			printStandings();
		}
	}

}
