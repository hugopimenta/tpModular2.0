package modular;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import modular.country.Country;
import modular.sport.Gymnastic;
import modular.sport.HighJump;
import modular.sport.Racing;
import modular.sport.Swimming;
import modular.sport.WeightLifting;
import modular.util.FileReader;
import modular.util.FileWriter;

public class Olimpiadas {

	public static final int SPORT = 1;
	public static final int MEDALBOARD = 2;
	public static final int RACING = 1;
	public static final int SWIMMING = 2;
	public static final int WEIGHTLIFTING = 3;
	public static final int HIGHJUMP = 4;
	public static final int GYMNASTIC = 5;

	public static void main(String[] args) throws Exception {

		// Inicializando esportes
		Racing racingSport = new Racing();
		Swimming swimmingSport = new Swimming();
		WeightLifting weightLiftingSport = new WeightLifting();
		HighJump highJumpSport = new HighJump();
		Gymnastic gymnasticSport = new Gymnastic();

		List<Country> countriesList = new ArrayList<>();
		countriesList = FileReader.getCountries();

		// Insere os atletas nos seus respectivos esportes
		FileReader.getAthletesList(racingSport, swimmingSport, weightLiftingSport, highJumpSport, gymnasticSport);

		Scanner statScan = new Scanner(new File("estatisticas.txt"), "UTF-8");
		
		while (statScan.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(statScan.nextLine(), ";");

			int statType = Integer.parseInt(st.nextToken());

			if (statType == SPORT) {

				int sportType = Integer.parseInt(st.nextToken());

				if (sportType == RACING) {
					racingSport.getFinalResult(countriesList);
				} else if (sportType == SWIMMING) {
					swimmingSport.getFinalResult(countriesList);
				} else if (sportType == WEIGHTLIFTING) {
					weightLiftingSport.getFinalResult(countriesList);
				} else if (sportType == HIGHJUMP) {
					highJumpSport.getFinalResult(countriesList);
				} else if (sportType == GYMNASTIC) {
					gymnasticSport.getFinalResult(countriesList);
				}

			} else if (statType == MEDALBOARD) {
				// Preenchimento do quadro de medalhas
				FileWriter.writeMedalsFile(racingSport, swimmingSport, weightLiftingSport, highJumpSport,
						gymnasticSport, countriesList);
			}

		}

		statScan.close();
	}

}
