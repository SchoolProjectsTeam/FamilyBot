package UI;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
import java.awt.Adjustable;

import javax.swing.BoxLayout;

import familybot.logic.core.Board;
import familybot.logic.core.Coordinate;
import familybot.logic.core.Family;
import familybot.logic.core.Robot;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Map extends JFrame {

	private JPanel contentPane;
	JPanel mapPanel = new JPanel();
	private JPanel [][] cells;
	private JPanel [] bots;
	private Board map;
	private Family family;

	/**
	 * Create the frame.
	 */
	public Map(Family family) {
		this.family = family;
		this.map = family.getBoard();
		cells = new JPanel [map.getX()][map.getY()];
		bots = new JPanel[10];
		initComponents();
		dibujarMapa(map);
		System.out.println("Inicio "+map.startPosition().getX()+" " +map.startPosition().getY() + "\n" + "Fin " + map.getEnd().getX() + " " + map.getEnd().getY());
		family.runSimulation();

		for(Robot rob : family.getRobots()) {
			System.out.println("Robot "+ rob.getID()+ "\n" + "Coordenadas :");
			for(Coordinate coor : rob.getPath()) {
				System.out.println(coor);
			}
		}


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
		buttonsPanel.setLayout(new MigLayout("", "[]", "[][][]"));

		JButton btnCorrerSimulacion = new JButton("Correr Simulacion");
		btnCorrerSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonsPanel.add(btnCorrerSimulacion, "cell 0 0");

		JButton btnTeststep = new JButton("TestStep");
		btnTeststep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextStep();
			}
		});
		buttonsPanel.add(btnTeststep, "cell 0 2");
	}


	public void dibujarMapa(Board map){
		for(int i = 0; i<map.getX(); i++){
			for(int j = 0; j<map.getY(); j++){
				JPanel panel = new JPanel();
				DimensionUIResource a = new DimensionUIResource(100, 100);
				panel.setPreferredSize(a);
				panel.setLayout(new MigLayout("", "[]", "[]"));
				if(map.startPosition().getX() == i && map.startPosition().getY() == j){
					panel.setBackground(Color.BLUE);	
					mapPanel.add(panel, "cell" + i + " " + j );
					cells[i][j]=panel;
				}
				else if(map.getEnd().getX() == i && map.getEnd().getY() == j){
					panel.setBackground(Color.BLACK);	
					mapPanel.add(panel, "cell" + i + " " + j );
					cells[i][j]=panel;
				}
				else{	
					panel.setBackground(Color.GRAY);
					mapPanel.add(panel, "cell" + i + " " + j );
					cells[i][j]=panel;
				}

				mapPanel.updateUI();
			}
		}	
		createRobots();
	}

	public void createRobots(){
		int auxiliarx = 0;
		int auxiliary = 0;
		int count = 0;
		int numRobot = 0;
		for(int i = 0; i<10 ; i++){
			JLabel name = new JLabel(Integer.toString(numRobot));
			JPanel bot = new JPanel();
			bot.add(name);
			DimensionUIResource a = new DimensionUIResource(20, 20);
			bot.setPreferredSize(a);
			cells[map.startPosition().getX()][map.startPosition().getY()].add(bot, "cell" + auxiliarx +" "+ auxiliary);
			bots[i] = bot;

			auxiliarx ++;
			count ++;
			if(count == 3){
				count = 0;
				auxiliarx=0;
				auxiliary++;
			}
			numRobot++;
		}
		cells[map.startPosition().getX()][map.startPosition().getY()].updateUI();

	}
	int generationSelected = 0;
	int countSteps = 0;
	
	public void nextStep(){
		if(countSteps < family.getBoard().maxSteps()) {
		for (Robot robot : family.getRecord().getGeneration(generationSelected)) {
			System.out.println("Robot"+" "+robot.getID()+" "+robot.getPath().get(countSteps));
		}
		countSteps++;
		mapPanel.updateUI();
		}
		else {
			countSteps = 0;
			nextStep();
		}
	}



}
