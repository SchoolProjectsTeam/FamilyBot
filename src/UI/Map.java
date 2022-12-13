package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;

import java.awt.ScrollPane;

import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Color;



public class Map extends JFrame {

	private JPanel contentPane;
	JPanel mapPanel = new JPanel();
	private ArrayList<JButton> casillas;
	private int coordX;
	private int coordY;
	/**
	 * Create the frame.
	 */
	public Map(int x, int y) {
		coordX = x;
		coordY = y;
		casillas = new ArrayList<JButton>();
		initComponents();
		dibujarMapa(coordX, coordY);



	}
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[711px]", "[493px]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		
		scrollPane.setViewportView(mapPanel);
		mapPanel.setLayout(new MigLayout("", "[]", "[]"));

	}

	public void dibujarMapa(int x, int y){
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				JPanel panel = new JPanel();
				panel.setBackground(Color.RED);
				DimensionUIResource a = new DimensionUIResource(100, 100);
				panel.setPreferredSize(a);
				mapPanel.add(panel, "cell" + i + " " + j );
			}
			mapPanel.updateUI();	
		}
	}
}
