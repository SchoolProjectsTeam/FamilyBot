/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package familybot;

import familybot.gui.MainFrame;
import familybot.gui.builders.MainBuilder;
import familybot.gui.builders.MapBuilder;
import familybot.gui.builders.WindowBuilder;
import familybot.logic.controllers.SimulationController;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rog
 */
public class App {
    
    public enum WindowType { main, map }
    private static Map<WindowType, WindowBuilder> builders;
    
    private final static SimulationController control = new SimulationController(); 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initialize();
        start();
    }
    
    public static void changeWindow(Window actual, WindowType next){
        WindowBuilder builder = builders.get(next);
        builder.open(control);
        actual.dispose();
    }
    
    public static void openChildWindow(Window actual, WindowType nextWindow){
        WindowBuilder builder = builders.get(nextWindow);
        builder.open(control);
    }
    
    private static void initialize(){
        builders = new HashMap<>();
        builders.put(WindowType.main, new MainBuilder());
        builders.put(WindowType.map, new MapBuilder());
    }
    
    private static void start(){
        WindowBuilder builder = builders.get(WindowType.main);
        builder.open(control);
    }
    
}
