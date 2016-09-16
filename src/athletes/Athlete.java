package athletes;

import java.util.List;

public class Athlete {

	private int id;
	private String name;
	private int sportId;
	private int countryId;
	private List<Double> results;
	private double finalResult;
	
	public int getId(){
		return this.id;		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getSportId(){
		return this.sportId;		
	}
	
	public void setSportId(int sportId){
		this.sportId = sportId;
	}
	
	public int getCountryId(){
		return this.countryId;
	}
	
	public void setCountryId(int countryID){
		this.countryId = countryID;		
	}
	
	public double getFinalResult(){
		return this.finalResult;		
	}
	
	public void setFinalResult(double finalResult){
		this.finalResult = finalResult;
	}
	
	public List<Double> getResults(){
		return this.results;
	}
	
	public void setResults(List<Double> results){
		this.results = results;
	}
	
}
