import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.NumberFormat;
import java.util.Locale;


import countries.Country;
import athletes.Athlete;
import sports.Gymnastic;
import sports.HighJump;
import sports.Racing;
import sports.Swimming;
import sports.WeightLifting;


public class Olimpiadas {

	public static void main(String[] args) throws Exception{
					
		//start sports problem? function needed?
		Racing racingSport = new Racing();
		racingSport.setId(1);
		racingSport.setName("Racing");
		
		Swimming swimmingSport = new Swimming();
		swimmingSport.setId(2);
		swimmingSport.setName("Swimming");
		
		WeightLifting weightliftingSport = new WeightLifting();
		weightliftingSport.setId(3);
		weightliftingSport.setName("WeightLifting");
		
		HighJump highJumpSport = new HighJump();
		highJumpSport.setId(4);
		highJumpSport.setName("HighJump");
		
		Gymnastic gymnasticSport = new Gymnastic();
		gymnasticSport.setId(5);
		gymnasticSport.setName("Gymnastic");
		
		//end start sports
		
		List<Country> countriesList = new ArrayList<>();
		Scanner countriesScan = new Scanner(new File("paises.txt"));
		do{
			Country country = new Country();
			StringTokenizer st = new StringTokenizer(countriesScan.nextLine(), ";");
			country.setId(Integer.parseInt(st.nextToken()));
			country.setName(st.nextToken());
			
			countriesList.add(country);
			
		}while(countriesScan.hasNextLine());	
		
		countriesScan.close();
		
		List<Athlete> athleteList = new ArrayList<>();
		Scanner athleteScan = new Scanner(new File("atletas.txt"));
		do{
			Athlete athlete = new Athlete();
			StringTokenizer st = new StringTokenizer(athleteScan.nextLine(), ";|");
			athlete.setId(Integer.parseInt(st.nextToken()));
			athlete.setCountryId(Integer.parseInt(st.nextToken()));
			athlete.setSportId(Integer.parseInt(st.nextToken()));
			athlete.setName(st.nextToken());
			
			List<Double> results = new ArrayList<>();
			
			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		    		    
			do{				
				results.add(format.parse(st.nextToken()).doubleValue());
				
			}while(st.hasMoreTokens());
			
			
			athlete.setResults(results);
			
			athleteList.add(athlete); //not necessary maybe
			
			if(athlete.getSportId() == 1){ //can be moved to a function?
				racingSport.addToAthleteList(athlete);
			}
			else if(athlete.getSportId() == 2){
				swimmingSport.addToAthleteList(athlete);
			}
			else if(athlete.getSportId() == 3){
				weightliftingSport.addToAthleteList(athlete);
			}
			else if(athlete.getSportId() == 4){
				highJumpSport.addToAthleteList(athlete);
			}
			else if(athlete.getSportId() == 5){
				gymnasticSport.addToAthleteList(athlete);
			}
						
		}while(athleteScan.hasNextLine());
		
		athleteScan.close();
		
		Scanner statScan = new Scanner(new File("estatisticas.txt"));
		do{
			StringTokenizer st = new StringTokenizer(statScan.nextLine(), ";");
			
			int statType = Integer.parseInt(st.nextToken());
			
			if(statType == 1){ //sport stat
				
				int sportType = Integer.parseInt(st.nextToken());
				
				if(sportType == 1){ //Racing						
										
					racingSport.getFinalResult();
				}
				else if(sportType == 2){ //swimming				
					
					swimmingSport.getFinalResult();
					
				}
				else if(sportType == 3){ //weightlifting										
					
					weightliftingSport.getFinalResult();
				}
				else if(sportType == 4){ //high jump
										
					highJumpSport.getFinalResult();
				}
				else if(sportType == 5){ //gymnastic					
															
					gymnasticSport.getFinalResult();
				}
				
			}
			else if(statType == 2){ //all country stat board
				//System.out.println("country");
			}		
						
		}while(statScan.hasNextLine());
		
		statScan.close();
	}
		
}
