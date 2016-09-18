package sports;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import athletes.Athlete;
import countries.Country;

public class Gymnastic extends Sport{
		
private List<Double> results;
	
	@Override
	public void getFinalResult(String option, List<Country> countriesList){ //higher score in 5 tries
				
		for(Athlete a:this.athleteList){ //run through all Athletes inside list and set Final Result
			results = a.getResults();
			
			double final_result_aux = 0;
			double final_result = 0;
			for (int i = 0; i < results.size(); i++) {
				
				final_result_aux += results.get(i);
			}		
			final_result = final_result_aux / results.size();
								
			a.setFinalResult(final_result);
					
			//System.out.println(a.getName() + " " +final_result);
					
		}
		//print resultado poderiamos dividir isso em outra funcao?
		Collections.sort(this.athleteList, new Comparator<Athlete>(){
			
			public int compare(Athlete a1, Athlete a2){
				double x = a1.getFinalResult();
				double y = a2.getFinalResult();
				return Double.compare(y,x); //Desempate alfabetico?
					
			}
		});
		
		if(option.equals("medal_board")){
			
			int idCountry;
			for(int j=0;j < 3;j++){
								
				idCountry = athleteList.get(j).getCountryId();
				
				if(j == 0)
					countriesList.get(idCountry -1).setGoldMedal();
				else if (j == 1)
					countriesList.get(idCountry -1).setSilverMedal();
				else if (j == 2)
					countriesList.get(idCountry -1).setBronzeMedal();			
				
				//nao tem ainda analise de desempate
			}
			
			
		}
		else{
		
			System.out.println(this.getName()+ "\n");
			
			for(Athlete a:this.athleteList){ 
				
				System.out.println(a.getName() + " " + a.getFinalResult());
				
			}
			
			System.out.println("\n");
		}
		
	}

}
