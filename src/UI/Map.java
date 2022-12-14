package UI;



import javax.swing.JFrame;
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
import familybot.logic.core.Family;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Map extends JFrame {

	private JPanel contentPane;
	JPanel mapPanel = new JPanel();
	//private ArrayList<JPanel> casillas;
	private JPanel [][] cells;
	private JPanel [] bots;
	private Board map;

	/**
	 * Create the frame.
	 */
	public Map(Board map) {
		this.map = map;
		//casillas = new ArrayList<JPanel>();
		cells = new JPanel [map.getX()][map.getY()];
		bots = new JPanel[10];
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
		buttonsPanel.setLayout(new MigLayout("", "[]", "[][]"));

		JButton btnCorrerSimulacion = new JButton("Correr Simulacion");
		btnCorrerSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*JPanel agregartest = new JPanel();
								DimensionUIResource a = new DimensionUIResource(50, 50);
								agregartest.setPreferredSize(a);
								casillas.get(5).add(agregartest,"cell 1 1" );
								casillas.get(5).updateUI();
								casillas.get(5).remove(agregartest);*/

			}
		});
		buttonsPanel.add(btnCorrerSimulacion, "cell 0 0");

		JButton btnAgregarBotSalida = new JButton("Borrar Bot 5");
		btnAgregarBotSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cells[map.startPosition().getX()][map.startPosition().getY()].remove(bots[5]);
				cells[map.startPosition().getX()][map.startPosition().getY()].updateUI();
				
			}

		});

		buttonsPanel.add(btnAgregarBotSalida, "cell 0 1");
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
		for(int i = 0; i<10 ; i++){
			JPanel bot = new JPanel();
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
		}
		cells[map.startPosition().getX()][map.startPosition().getY()].updateUI();

	}
}
