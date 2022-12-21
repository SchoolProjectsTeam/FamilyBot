package familybot.logic.core;

import familybot.logic.utils.CharGenerator;
import familybot.logic.utils.ID;
import familybot.logic.utils.SimulationRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Family implements Serializable{

	private static final long serialVersionUID = -3873794542448627534L;
	
	private List<Robot> robots;
	private Board map;
	private int actualWalk;
	private CharGenerator charGen;
	private SimulationRecord record;
	private String friendlyID;


	public Family(Board map, String name){
		this.friendlyID = name;
		this.map = map;
		actualWalk = 0;
		charGen = new CharGenerator();
		robots = new ArrayList<>(10);
		for(int i = 0; i < 10; i++){
			robots.add(new Robot(map, generateID()));
		}
		charGen.restart();
		actualWalk++;
		record = new SimulationRecord(robots);
	}    
	
	public void walk(){
		for(Robot rob : robots){
			boolean repeat = false;
			do {
				if(rob.getPosition().equals(map.getEnd())){
					rob.setWinner();
				}
				else{
					repeat = rob.walkStep();
				}
			}
			while(!rob.isWinner() && repeat);
		}
		robots.sort(new Comparator<Robot>() {
			@Override
			public int compare(Robot r1, Robot r2) {
				if(r1.isWinner() && r2.isWinner()){
					return Integer.compare(r1.getPath().size(), r2.getPath().size());
				}
				else if(!r1.isWinner() && !r2.isWinner()){
					return Integer.compare(map.calculateDistance(r1.getPosition()), map.calculateDistance(r2.getPosition()));
				}
				else {
					return (r1.isWinner()) ? -1 : 1;
				}
			}
		});		
		evolve();
	}

	private void evolve() {

			ArrayList<Robot> newbots = new ArrayList<Robot>(10);
			for(int i = 0; i < 6; i++) {
				robots.get(i).restart();
				newbots.add(robots.get(i));
			}
			newbots.add(6, new Robot(map, generateID(), robots.get(0), robots.get(1)));
			newbots.add(7, new Robot(map, generateID(), robots.get(1), robots.get(2)));
			newbots.add(8, new Robot(map, generateID(), robots.get(2), robots.get(3)));
			newbots.add(9, new Robot(map, generateID(), robots.get(3), robots.get(0)));
			record.setNewGeneration(newbots);
			robots = newbots;
			actualWalk++;
			charGen.restart();
	}

	public void runSimulation(){
		for(int i = 0; i < 50; i++){
			walk();		
		}
	}

	private ID generateID() {
		return new ID(charGen.get(), actualWalk);
	}
	
	public Board getBoard() {return map;}
	public List<Robot> getRobots(){return robots;}
	public SimulationRecord getRecord() {return record;}
	public String getFrindlyID() {return friendlyID;}
}
