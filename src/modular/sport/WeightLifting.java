package modular.sport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modular.athlete.Athlete;
import modular.country.Country;
import modular.util.FileWriter;
import modular.util.comparator.HigherBetterComparator;

public class WeightLifting extends Sport {

	private List<Double> results;

	public WeightLifting() {
		setName("Levantamento de Peso");
		this.setId(3);
	}

	// higher score in 5 tries
	protected void getResult(String option, List<Country> countriesList) {

		// run through all Athletes inside,  list and set Final Result
		for (Athlete athlete : this.athleteList) { 
			results = athlete.getResults();

			double final_result = 0;
			for (int i = 0; i < results.size(); i++) {

				if (results.get(i) >= final_result) {
					final_result = results.get(i);
				}
			}

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
