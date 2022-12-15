package UI;

import java.util.ArrayList;
import java.util.List;

import familybot.logic.core.Family;

public class Data {
	private List<Family> data; 
	
	public Data(){
		data = new ArrayList<Family>();
	}
	
	
	public List<Family> getData(){return data;}
	
	public void addFamily(Family a){
		data.add(a);
	}
}
