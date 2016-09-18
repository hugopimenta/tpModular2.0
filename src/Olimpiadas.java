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
										
					racingSport.getFinalResult("racing", countriesList);
				}
				else if(sportType == 2){ //swimming				
					
					swimmingSport.getFinalResult("swimmming", countriesList);
					
				}
				else if(sportType == 3){ //weightlifting										
					
					weightliftingSport.getFinalResult("weigtlifting",countriesList);
				}
				else if(sportType == 4){ //high jump
										
					highJumpSport.getFinalResult("highjump",countriesList);
				}
				else if(sportType == 5){ //gymnastic					
															
					gymnasticSport.getFinalResult("gymnastic",countriesList);
				}
								
			}
			else if(statType == 2){ //all country stat board
				//ṕreenchimento do quadro de medalhas
				gymnasticSport.getFinalResult("medal_board", countriesList);
				highJumpSport.getFinalResult("medal_board", countriesList);
				weightliftingSport.getFinalResult("medal_board", countriesList);
				swimmingSport.getFinalResult("medal_board", countriesList);
				racingSport.getFinalResult("medal_board", countriesList);
				
							
				//print do quadro de medalhas
				System.out.println("Quadro de Medalhas\n");
				System.out.println("Pais\tOutro\tPrata\tBronze");
				for(int k=0; k < countriesList.size();k++){
					int t[] = new int[3];
					t = countriesList.get(k).getMedals();
					System.out.println(countriesList.get(k).getName() + "\t" + t[0] + "\t" + t[1] + "\t" + t[2]);
				}
			}		
						
		}while(statScan.hasNextLine());
		
		statScan.close();
	}
		
}
