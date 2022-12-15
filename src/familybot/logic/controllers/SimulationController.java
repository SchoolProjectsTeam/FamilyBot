package familybot.logic.controllers;

import familybot.logic.core.Family;

public class SimulationController {
    
    private static SimulationController instance;
    
    private final Family family;

    public static SimulationController Get(){

        if(instance == null){
            instance = new SimulationController();
        }
        return instance;
        
    }

    private SimulationController(){
    	
    }

}
