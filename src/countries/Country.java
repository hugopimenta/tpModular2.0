package countries;

import java.util.List;

public class Country {

	private int id;
	private String name;
	private int medals[] = new int[3];
	
	public Country(){
		
		for(int i=0;i <3;i++)
		{
			this.medals[i] = 0;
		}
		
	}
	
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
	
	public int[] getMedals(){
		return this.medals;
	}
	
	
	public void setGoldMedal(){		
		this.medals[0]++;
	}
	public void setSilverMedal(){
		this.medals[1]++;
	}
	public void setBronzeMedal(){
		this.medals[2]++;
	}
}
