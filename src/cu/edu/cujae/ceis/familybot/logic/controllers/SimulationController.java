package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Board;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import cu.edu.cujae.ceis.familybot.ui.utils.MessageBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimulationController
{

    private static Logger LOGGER = LoggerFactory.getLogger(SimulationController.class);
    
    private static SimulationController instance;
    
    private FileControllerDAT files;
    
    private ArrayList<Family> families;
    private Family family;
    
    public static SimulationController Get()
    {
        
        if (instance == null)
        {
            instance = new SimulationController();
        }
        return instance;
        
    }
    
    public SimulationController()
    {
        files = new FileControllerDAT(FileController.MODE_READ);
    }

    /**
     * Devuelve la familia actualmente seleccionada
     *
     * @return Family
     */
    public Family getFamily()
    {
        return family;
    }

    /**
     * Selecciona la familia a utilizar, recibe el indice de dicha familia en el arreglo de familias
     *
     * @param index
     */
    public void selectFamily(int index)
    {
        family = families.get(index);
    }

    /**
     * Crea una familia nueva, recibe el mapa ya creado, se crea en la interfaz
     *
     * @param map
     */
    public void createFamily(Board map, String name)
    {
        this.family = new Family(map, name);
        loadFamilies();
        families.add(this.family);
        saveFamilies();
    }

    /**
     * Devuelve un clon del arreglo de familias guardado en el archivo, los cambios hechos a este arreglo no se aplican
     * a los originales, su objetivo es solo obtener el indice de dichas familias
     *
     * @return ArrayList de Familias
     */
    @SuppressWarnings ("unchecked")
    public ArrayList<Family> loadFamilies()
    {
        files.reopen(FileController.MODE_READ);
        List<Family> read = new LinkedList<>();
        try
        {
            read = files.read();
        }
        catch (IOException | ClassNotFoundException ex)
        {
            LOGGER.error("", ex);
            MessageBox.showException(ex);
        }
        
        families = new ArrayList<>(read);
        
        if (families == null)
        {
            families = new ArrayList<>();
        }
        return (ArrayList<Family>) families.clone();
    }

    /**
     * Guarda en el fichero el arreglo de familias
     */
    public void saveFamilies()
    {
        files.reopen(FileController.MODE_WRITE);
        try
        {
            files.write(families);
        }
        catch (IOException ex)
        {
            LOGGER.error("", ex);
            MessageBox.showException(ex);
        }
    }
}