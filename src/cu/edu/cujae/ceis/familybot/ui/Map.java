package cu.edu.cujae.ceis.familybot.ui;

import cu.edu.cujae.ceis.familybot.logic.controllers.SimulationController;
import cu.edu.cujae.ceis.familybot.logic.core.Board;
import cu.edu.cujae.ceis.familybot.logic.core.Coordinate;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import cu.edu.cujae.ceis.familybot.logic.core.Robot;
import cu.edu.cujae.ceis.familybot.logic.utils.SimulationRecord;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class Map extends JFrame
{

	private JPanel contentPane;
	JPanel mapPanel = new JPanel();
	private JPanel[][] cells;
	private JPanel[] bots;
	private Board map;
	private Family family;
	private JLabel basicsStats = new JLabel("");
	private JLabel basicsStatsGeneration = new JLabel("");
	private JLabel lblAverage = new JLabel("New label");
	private JLabel lblName = new JLabel("New label");
	private JLabel lblSize = new JLabel("size");
	//private JLabel lblBestPath = new JLabel("New label");   
	/**
	 * Create the frame.
	 */
	public Map(Family family)
	{
		this.family = family;
		this.map = this.family.getBoard();
		cells = new JPanel[map.getX()][map.getY()];
		bots = new JPanel[10];
		initComponents();
		dibujarMapa(map);
		family.runSimulation();

		lblAverage.setText("Promedio de Pasos: "+Float.toString(average()));
		lblName.setText("Nombre: " + family.getFrindlyID());
		//lblBestPath.setText(family.getRecord().getGeneration(50).get(0).getPath().toString());
	}

	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 542);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(mapPanel);
		mapPanel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][]",
				"[][][][][][][][][][][][][][][][][]"));

		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel, BorderLayout.EAST);
		buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][][][][][][][][]"));

		JButton btnTeststep = new JButton("Siguiente Paso");
		btnTeststep.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				nextStep();
			}
		});

		JLabel lblNewLabel = new JLabel("Introduzca la generacion a simular");
		buttonsPanel.add(lblNewLabel, "cell 0 0,growx");

		textGeneration = new JTextField();
		buttonsPanel.add(textGeneration, "cell 0 1,growx");
		textGeneration.setColumns(10);
		buttonsPanel.add(btnTeststep, "cell 0 3,growx");


		buttonsPanel.add(basicsStats, "cell 0 4");


		buttonsPanel.add(basicsStatsGeneration, "cell 0 5");

		JLabel lblNewLabel_1 = new JLabel("Stats:");
		buttonsPanel.add(lblNewLabel_1, "cell 0 7");
		
		buttonsPanel.add(lblSize, "cell 0 8");


		buttonsPanel.add(lblName, "cell 0 9");


		buttonsPanel.add(lblAverage, "cell 0 10");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulationController.Get().printCSV();
			}
		});
		
		buttonsPanel.add(btnNewButton, "cell 0 18,alignx center");

		//   JLabel lblNewLabel_2_2 = new JLabel("BestPath");
		// buttonsPanel.add(lblNewLabel_2_2, "cell 0 11");


		// buttonsPanel.add(lblBestPath, "cell 0 12");
	}

	public void dibujarMapa(Board map)
	{
		for (int i = 0; i < map.getX(); i++)
		{
			for (int j = 0; j < map.getY(); j++)
			{
				JPanel panel = new JPanel();
				DimensionUIResource a = new DimensionUIResource(100, 100);
				panel.setPreferredSize(a);
				panel.setLayout(new MigLayout("", "[]", "[]"));
				if (map.startPosition().getX() == i && map.startPosition().getY() == j)
				{
					panel.setBackground(Color.BLUE);
					mapPanel.add(panel, "cell" + i + " " + j);
					cells[i][j] = panel;
				}
				else if (map.getEnd().getX() == i && map.getEnd().getY() == j)
				{
					panel.setBackground(Color.BLACK);
					mapPanel.add(panel, "cell" + i + " " + j);
					cells[i][j] = panel;
				}
				else
				{
					try {
						map.makePosition(i, j);
						panel.setBackground(Color.GRAY);
						mapPanel.add(panel, "cell" + i + " " + j);
						cells[i][j] = panel;
					} catch (IllegalArgumentException e) {
						panel.setBackground(Color.RED);
						mapPanel.add(panel, "cell" + i + " " + j);
						cells[i][j] = panel;
					}
				}

			}
			lblSize.setText("Tamaño: "+family.getBoard().getX() + " x " +family.getBoard().getY());
			mapPanel.updateUI();
		}
		createRobots();
	}

	public void createRobots()
	{
		int auxiliarx = 0;
		int auxiliary = 0;
		int count = 0;
		int numRobot = 0;
		for (int i = 0; i < 10; i++)
		{
			JLabel name = new JLabel(Integer.toString(numRobot));
			JPanel bot = new JPanel();
			bot.add(name);
			DimensionUIResource a = new DimensionUIResource(20, 20);
			bot.setPreferredSize(a);
			cells[map.startPosition().getX()][map.startPosition().getY()].add(bot, "cell" + auxiliarx + " " + auxiliary);
			bots[i] = bot;

			auxiliarx++;
			count++;
			if (count == 3)
			{
				count = 0;
				auxiliarx = 0;
				auxiliary++;
			}
			numRobot++;
		}
		cells[map.startPosition().getX()][map.startPosition().getY()].updateUI();
	}



	int countSteps = 0;
	int countRobots = 0;
	int countGeneration = 0;
	private JTextField textGeneration;
	private final JButton btnNewButton = new JButton("Imprimir CSV");



	public void nextStep()
	{
		if(!(textGeneration.getText().length() == 0)){
			countGeneration = Integer.parseInt(textGeneration.getText()) ;
		}
		else {
			countGeneration = 0;
		}

		if(countSteps<family.getBoard().maxSteps()) {
			//System.out.println(family.getBoard().maxSteps() + " " + countSteps);
			List<Robot> robots = family.getRecord().getGeneration(countGeneration);
			for (Robot robot : robots)        {
				cells[robot.getPath().get(countSteps).getX()][robot.getPath().get(countSteps).getY()].add(bots[countRobots]);
				countRobots++;
				//System.out.println("Robot" + " " + robot.getID() + " " + robot.getPath().get(countSteps));
			}
			countSteps++;
			countRobots = 0;
			mapPanel.updateUI();
		}
		else {
			countSteps = 0;
		}
		basicsStats.setText("Paso: \n" + countSteps + " - " + family.getBoard().maxSteps());
		basicsStatsGeneration.setText("Generacion: "+countGeneration);
	}
	public float average() {
		int a = 0;
		for(int i= 0;i<50;i++) {
			for(Robot rob : family.getRecord().getGeneration(i)) {
				a+=rob.getPath().size();
			}
		}
		float b = (float)a/(10*50);
		return b;
	}

}
