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
    }

}
