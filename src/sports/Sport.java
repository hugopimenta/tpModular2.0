package sports;

import java.util.ArrayList;
import java.util.List;
import athletes.Athlete;

public abstract class Sport {

	private int id;
	private String name;
	protected List<Athlete> athleteList = new ArrayList<>();
			
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Athlete> getAthleteList(){
		return athleteList;
	}
	
	public void setAthleteList(List<Athlete> athleteList){
		this.athleteList = athleteList;
	}
	
	public void addToAthleteList(Athlete athlete){
		this.athleteList.add(athlete);
	}
	
	public int countAthleteList(){
		return this.athleteList.size();
	}
	
	public void printAthleteList(){
		
		for(Athlete a:this.athleteList){
			System.out.println(a.getName());
		}
	}
	
	public abstract void getFinalResult();
	
}
