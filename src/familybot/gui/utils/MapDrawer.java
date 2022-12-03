/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.gui.utils;

import java.awt.Button;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JButton;

/**
 *
 * @author Rog
 */
public class MapDrawer {
 
    public static void Draw(Container container, Integer x, Integer y){
        int totalWidth = container.getWidth();
        int totalHeight = container.getHeight();
        int itemWidth = totalWidth / x;
        int itemHeight = totalHeight / y;
        
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                JButton button = new JButton("H");
                container.add(button, container);
            }
        }
    }
}
