package countries;

import java.util.List;

public class Country {

	private int id;
	private String name;
	private List<Integer> medals;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<Integer> getMedals(){
		return medals;
	}
	
	public void setMedals(List<Integer> medals){
		this.medals = medals;
	}
}
