package familybot.logic.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import familybot.logic.core.Robot;

public class SimulationRecord {
    private int actualGen;
    private Map<Integer, List<Robot>> generations;

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

}
