package familybot.logic.controllers;

public class SimulationController {
    
    private static SimulationController instance;

    public static SimulationController Get(){

        if(instance == null){
            instance = new SimulationController();
        }
        return instance;
        
    }

    private SimulationController(){

    }

}
