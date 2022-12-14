package UI;

import java.util.List;

import familybot.logic.core.Family;

public class Data {
	private List<Family> data; 
	
	public List<Family> getData(){return data;}
	public void addFamily(Family a){
		data.add(a);
	}

}
