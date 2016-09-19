package modular.sport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modular.athlete.Athlete;
import modular.country.Country;
import modular.util.FileWriter;
import modular.util.comparator.LowerBetterComparator;

public class Swimming extends Sport {

	private List<Double> results;

	public Swimming() {
		setName("Natação");
		this.setId(2);
	}

	// faster between 3 shots
	protected void getResult(String option, List<Country> countriesList) {

		// run through all Athletes inside,  list and set Final Result
		for (Athlete athlete : this.athleteList) { 
			results = athlete.getResults();

			double final_result = 10000;
			for (int i = 0; i < results.size(); i++) {

				if (results.get(i) <= final_result) {
					final_result = results.get(i);
				}
			}

			athlete.setFinalResult(final_result);
		}
		
		Comparator<Athlete> comparator = new LowerBetterComparator();
		Collections.sort(this.athleteList, comparator);

		if (Sport.MEDALS.equals(option)) {
			setMedals(countriesList);

		} else {
			FileWriter.writeSportStanding(this);
		}
	}

}
