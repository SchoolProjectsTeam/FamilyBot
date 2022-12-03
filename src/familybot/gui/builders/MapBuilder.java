/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package familybot.gui.builders;

import familybot.gui.MapDialogFrame;
import familybot.logic.controllers.SimulationController;

/**
 *
 * @author Rog
 */
public class MapBuilder implements WindowBuilder {
    
    @Override
    public void open(SimulationController control) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            MapDialogFrame dialog = new MapDialogFrame(new javax.swing.JFrame(), true, control.getBoard());
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
}
