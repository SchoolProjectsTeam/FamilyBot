package UI;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import familybot.logic.core.Board;
import familybot.logic.core.Family;

import java.awt.Component;
import java.awt.GridLayout;



public class Map extends JFrame {

	private JPanel contentPane;
	JPanel mapPanel = new JPanel();
	private ArrayList<JButton> casillas;

	/**
	 * Create the frame.
	 */
	public Map(Board map) {
		casillas = new ArrayList<JButton>();
		initComponents();
		dibujarMapa(map);



	}
	public void initComponents(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 542);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);


		scrollPane.setViewportView(mapPanel);
		mapPanel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][]"));

		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel, BorderLayout.EAST);
		buttonsPanel.setLayout(new MigLayout("", "[]", "[]"));

		JButton btnCorrerSimulacion = new JButton("Correr Simulacion");
		buttonsPanel.add(btnCorrerSimulacion, "cell 0 0");

	}

	public void dibujarMapa(Board map){


		for(int i = 0; i<map.getX(); i++){
			for(int j = 0; j<map.getY(); j++){
				JPanel panel = new JPanel();
				DimensionUIResource a = new DimensionUIResource(100, 100);
				panel.setPreferredSize(a);
				if(map.startPosition().getX() == i && map.startPosition().getY() == j){
					panel.setBackground(Color.BLUE);	
					mapPanel.add(panel, "cell" + i + " " + j );
				}
				else if(map.getEnd().getX() == i && map.getEnd().getY() == j){
					panel.setBackground(Color.BLACK);	
					mapPanel.add(panel, "cell" + i + " " + j );
				}
				else{	
					panel.setBackground(Color.GRAY);
					mapPanel.add(panel, "cell" + i + " " + j );
				}
				mapPanel.updateUI();
			}
		}	
	}
}
