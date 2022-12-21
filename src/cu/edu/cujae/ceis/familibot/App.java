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

        // Dirty Testing
        
        /*
         SimulationController control = SimulationController.Get();
        Board[] maps = new Board[3];
        maps[0] = new Board(4, 4);
        maps[0].setStart(maps[0].makePosition(0, 0));
        maps[0].setEnd(maps[0].makePosition(3, 3));
        maps[1] = new Board(6, 6);
        maps[1].setStart(maps[1].makePosition(0, 0));
        maps[1].setEnd(maps[1].makePosition(5, 5));
        maps[2] = new Board(8, 8);
        maps[2].setStart(maps[2].makePosition(0, 0));
        maps[2].setEnd(maps[2].makePosition(5, 5));
        
        control.createFamily(maps[0], "Primera");
        control.getFamily().runSimulation();
		control.createFamily(maps[1], "Segunda");
		control.getFamily().runSimulation();
		control.createFamily(maps[2], "Tercera");
		control.getFamily().runSimulation();
		
		
		control.printCSV();
         */

    }

}
