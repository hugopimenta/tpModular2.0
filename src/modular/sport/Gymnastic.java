package modular.sport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modular.athlete.Athlete;
import modular.country.Country;
import modular.util.FileWriter;
import modular.util.comparator.HigherBetterComparator;

public class Gymnastic extends Sport {

	private List<Double> results;

	public Gymnastic() {
		setName("Ginastica artística");
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

		}
		
		Comparator<Athlete> comparator = new HigherBetterComparator();
		Collections.sort(this.athleteList, comparator);
		
		if (Sport.MEDALS.equals(option)) {
			setMedals(countriesList);

		} else {
			FileWriter.writeSportStanding(this);
		}
	}

}
