package familybot.logic.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import familybot.logic.core.Board;
import familybot.logic.core.Direction;
import familybot.logic.core.Robot;

public class SimulationRecord implements Serializable{

	private static final long serialVersionUID = 7430977851940424785L;
	private int actualGen;
    private Map<Integer, List<Robot>> generations;
    
    private int average = 0;

    public SimulationRecord(List<Robot> initialGeneration){
        generations = new HashMap<>();
        actualGen = 0;
        setNewGeneration(initialGeneration);
    }

    public void setNewGeneration(List<Robot> robots){
        generations.put(actualGen, robots);
        actualGen++;
    }

    public List<Robot> getGeneration(int generation){
        return generations.get(generation);
    }
    
    public int getAverage() {
    	if(average == 0) {
    		int i;
    		for(i = 0; i < actualGen; i++) {
    			List<Robot> robots = generations.get(i);
    			for(Robot rob : robots) {
    				average += rob.getPath().size();
    			}
    		}
    		average /= i * 10;
    	}
    	return average;
    }
    
    public List<Direction> getBestPath(){
    	return generations.get(actualGen).get(0).getMoveRecord();
    }

}
