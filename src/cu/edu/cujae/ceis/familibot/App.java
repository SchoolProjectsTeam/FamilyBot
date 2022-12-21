package cu.edu.cujae.ceis.familibot;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import cu.edu.cujae.ceis.familybot.logic.controllers.SimulationController;
import cu.edu.cujae.ceis.familybot.logic.core.Board;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import cu.edu.cujae.ceis.familybot.logic.utils.SimulationRecord;
import cu.edu.cujae.ceis.familybot.ui.MainWindows;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            LOGGER.error("no pudo aplicarse el look and feel", ex);
        }
        
        EventQueue.invokeLater(() -> 
        {
            try
            {
                MainWindows frame = new MainWindows();
                frame.setVisible(true);
            }
            catch (Exception e)
            {
                LOGGER.error("no se pudo iniciar la app", e);
            }
        });
        
        SimulationController test = SimulationController.Get();
        Board map = new Board(8, 8);
        map.setStart(map.makePosition(0, 0));
        map.setEnd(map.makePosition(3, 3));
        test.createFamily(map, "Saved");
        Family family = test.getFamily();
        SimulationRecord record = family.getRecord();
        test.saveFamilies();
        System.out.println(family.getFrindlyID());
        System.out.println(test.loadFamilies());
        /*
		List<Robot> robots = record.getGeneration(0);
    	System.out.println("Generacion 0 : Inicial");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
    	family.runSimulation();
    	robots = record.getGeneration(0);
    	System.out.println("Generacion 0 : Leaderboard");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
    	robots = record.getGeneration(1);
    	System.out.println("Generacion 1 : Leaderboard");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
    	robots = record.getGeneration(2);
    	System.out.println("Generacion 2 : Leaderboard");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
    	robots = record.getGeneration(3);
    	System.out.println("Generacion 3 : Leaderboard");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
    	robots = record.getGeneration(50);
    	System.out.println("Generacion 50 : Leaderboard");
    	for(Robot rob : robots) {
    		System.out.println(rob.getID().toString() + " -> " + rob.getMoveRecord());
    	}
         */
        
    }
    
}
