package cu.edu.cujae.ceis.familibot;

import cu.edu.cujae.ceis.familybot.ui.MainWindows;
import cu.edu.cujae.ceis.familybot.logic.controllers.SimulationController;
import cu.edu.cujae.ceis.familybot.logic.core.Board;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import cu.edu.cujae.ceis.familybot.logic.utils.SimulationRecord;
import java.awt.EventQueue;

public class App
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainWindows frame = new MainWindows();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
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
