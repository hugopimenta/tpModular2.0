package modular.sports;

import java.util.ArrayList;
import java.util.List;

import modular.athletes.Athlete;
import modular.countries.Country;

public abstract class Sport {

	public static final String MEDALS = "MEDALS";

	private int id;
	protected List<Athlete> athleteList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.getClass().getName();
	}

	public List<Athlete> getAthleteList() {
		return athleteList;
	}

	public void setAthleteList(List<Athlete> athleteList) {
		this.athleteList = athleteList;
	}

	public void addToAthleteList(Athlete athlete) {
		this.athleteList.add(athlete);
	}

	public int countAthleteList() {
		return this.athleteList.size();
	}

	public void printAthleteList() {

		for (Athlete a : this.athleteList) {
			System.out.println(a.getName());
		}
	}

	protected abstract void getResult(String option, List<Country> countriesList);

	public void getFinalResult(List<Country> countriesList) {
		getResult(null, countriesList);
	}

	public void getMedalResult(List<Country> countriesList) {
		getResult(MEDALS, countriesList);
	}

	protected void setMedals(List<Country> countriesList) {
		int idCountry;
		for (int j = 0; j < 3; j++) {

			idCountry = athleteList.get(j).getCountryId();

			if (j == 0)
				countriesList.get(idCountry - 1).setGoldMedal();
			else if (j == 1)
				countriesList.get(idCountry - 1).setSilverMedal();
			else if (j == 2)
				countriesList.get(idCountry - 1).setBronzeMedal();

			// nao tem ainda analise de desempate
		}
	}

	protected void printStandings() {
		System.out.println(this.getName() + "\n");

		for (Athlete a : this.athleteList) {

			System.out.println(a.getName() + " " + a.getFinalResult());

		}

		System.out.println("\n");
	}
	
}
