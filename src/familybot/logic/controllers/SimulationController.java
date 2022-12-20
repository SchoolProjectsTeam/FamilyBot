package familybot.logic.controllers;

import java.util.ArrayList;

import familybot.logic.core.Board;
import familybot.logic.core.Family;

public class SimulationController {
    
    private static SimulationController instance;
    
    private FileControllerDAT files;
    
    private ArrayList<Family> families;
    private Family family;

    public static SimulationController Get(){

        if(instance == null){
            instance = new SimulationController();
        }
        return instance;
        
    }
    
    public SimulationController() {
    	files = new FileControllerDAT();
    }
    
    public Family getFamily() {return family;}
    
    public void selectFamily(int index) {
    	family = families.get(index);
    }
    
    public void createFamily(Board map) {
    	family = new Family(map);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<Family> loadFamilies() {
    	return (ArrayList<Family>) files.read().clone();
    }
    
    public void saveFamilies() {
    	files.write(families);
    }
}
