package modular.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

import modular.Olimpiadas;
import modular.athlete.Athlete;
import modular.country.Country;
import modular.sport.Gymnastic;
import modular.sport.HighJump;
import modular.sport.Racing;
import modular.sport.Swimming;
import modular.sport.WeightLifting;

public final class FileReader {

	public static List<Country> getCountries() throws FileNotFoundException {
		List<Country> countriesList = new ArrayList<>();
		Scanner countriesScan = new Scanner(new File("paises.txt"), "UTF-8");

		while (countriesScan.hasNextLine()) {
			Country country = new Country();
			StringTokenizer st = new StringTokenizer(countriesScan.nextLine(), ";");
			country.setId(Integer.parseInt(st.nextToken()));
			country.setName(st.nextToken());

			countriesList.add(country);
		}

		countriesScan.close();

		return countriesList;
	}

	public static void getAthletesList(Racing racingSport, Swimming swimmingSport, WeightLifting weightliftingSport,
			HighJump highJumpSport, Gymnastic gymnasticSport) throws FileNotFoundException, ParseException {
		Scanner athleteScan = new Scanner(new File("atletas.txt"), "UTF-8");
		while (athleteScan.hasNextLine()) {
			Athlete athlete = new Athlete();
			StringTokenizer st = new StringTokenizer(athleteScan.nextLine(), ";|");
			athlete.setId(Integer.parseInt(st.nextToken()));
			athlete.setCountryId(Integer.parseInt(st.nextToken()));
			athlete.setSportId(Integer.parseInt(st.nextToken()));
			athlete.setName(st.nextToken());

			List<Double> results = new ArrayList<>();

			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

			do {
				results.add(format.parse(st.nextToken()).doubleValue());
			} while (st.hasMoreTokens());

			athlete.setResults(results);

			if (athlete.getSportId() == Olimpiadas.RACING) {
				racingSport.addToAthleteList(athlete);
			} else if (athlete.getSportId() == Olimpiadas.SWIMMING) {
				swimmingSport.addToAthleteList(athlete);
			} else if (athlete.getSportId() == Olimpiadas.WEIGHTLIFTING) {
				weightliftingSport.addToAthleteList(athlete);
			} else if (athlete.getSportId() == Olimpiadas.HIGHJUMP) {
				highJumpSport.addToAthleteList(athlete);
			} else if (athlete.getSportId() == Olimpiadas.GYMNASTIC) {
				gymnasticSport.addToAthleteList(athlete);
			}
		}

		athleteScan.close();
	}
}
