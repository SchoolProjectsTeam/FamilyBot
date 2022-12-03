/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.gui.builders;

import familybot.gui.MainFrame;
import familybot.logic.controllers.SimulationController;

/**
 *
 * @author Rog
 */
public class MainBuilder implements WindowBuilder {

    @Override
    public void open(SimulationController control) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
}
