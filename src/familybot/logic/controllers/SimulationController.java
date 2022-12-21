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
    
    /**
     * Devuelve la familia actualmente seleccionada
     * @return Family
     */
    public Family getFamily() {return family;}
    
    /**
     * Selecciona la familia a utilizar, recibe el indice de dicha familia en el arreglo de familias
     * @param index
     */
    public void selectFamily(int index) {
    	family = families.get(index);
    }
    
    /**
     * Crea una familia nueva, recibe el mapa ya creado, se crea en la interfaz
     * @param map
     */
    public void createFamily(Board map, String name) {
    	this.family = new Family(map, name);
    	loadFamilies();
    	families.add(this.family);
    	saveFamilies();
    }
    
    /**
     * Devuelve un clon del arreglo de familias guardado en el archivo, los cambios hechos a este arreglo no se aplican a los originales, su objetivo es solo obtener el indice de dichas familias
     * @return ArrayList de Familias
     */
	@SuppressWarnings("unchecked")
	public ArrayList<Family> loadFamilies() {
    	families = (ArrayList<Family>) files.read();
    	if(families == null) {
    		families = new ArrayList<Family>();
    	}
    	return (ArrayList<Family>)families.clone();
    }
    
    /**
     * Guarda en el fichero el arreglo de familias
     */
    public void saveFamilies() {
    	files.write(families);
    }
}
