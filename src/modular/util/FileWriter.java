package modular.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.List;

import modular.athlete.Athlete;
import modular.country.Country;
import modular.sport.Gymnastic;
import modular.sport.HighJump;
import modular.sport.Racing;
import modular.sport.Sport;
import modular.sport.Swimming;
import modular.sport.WeightLifting;
import modular.util.comparator.MedalComparator;

public final class FileWriter {

	public static void writeMedalsFile(Racing racingSport, Swimming swimmingSport, WeightLifting weightLiftingSport,
			HighJump highJumpSport, Gymnastic gymnasticSport, List<Country> countriesList) {

		// Populando o quadro de medalhas
		gymnasticSport.getMedalResult(countriesList);
		highJumpSport.getMedalResult(countriesList);
		weightLiftingSport.getMedalResult(countriesList);
		swimmingSport.getMedalResult(countriesList);
		racingSport.getMedalResult(countriesList);

		MedalComparator comparator = new MedalComparator();
		Collections.sort(countriesList, comparator);

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("estatistica-2.txt"), "UTF-8"))) {
			writer.write("Quadro de Medalhas\n\n");
			String header = String.format("%-10s %-10s %-10s %-10s%n", "Pais", "Ouro", "Prata", "Bronze").trim();
			writer.write(header);
			for (int k = 0; k < countriesList.size(); k++) {
				int medals[] = new int[3];
				medals = countriesList.get(k).getMedals();
				String line = String.format("%-10s %-10s %-10s %-10s%n", countriesList.get(k).getName(), medals[0],
						medals[1], medals[2]).trim();
				writer.write(line);
			}
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeSportStanding(Sport sport) {
		String fileName = "estatistica-1-" + sport.getId() + ".txt";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
			writer.write(sport.getName() + "\n\n");

			for (Athlete athlete : sport.getAthleteList()) {
				writer.write(String.format("%-15s %-10.2f%n", athlete.getName(), athlete.getFinalResult()).trim());

			}
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
