package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import familybot.logic.core.Board;
import familybot.logic.core.Family;
import net.miginfocom.swing.MigLayout;

public class MainWindows extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2736362071613527529L;
	private JPanel contentPane;
	private JButton mapButton = new JButton("Lanzar Mapa A");
	private Map map;
	private JTextField inputX;
	private JTextField inputY;
	private JLabel labelNewBoard;
	private UiUtil util;
	private JButton btnListaTableros;


	/**
	 * Create the frame.
	 */
	public MainWindows() {
		initComponents();
		util = new UiUtil();
		
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewFamily();
			}
		});
	}
	
	
	

	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 630);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[50][50][][][][][][][][][]", "[][][][][][][][][130.00]"));
		
		labelNewBoard = new JLabel("Nueva Familia");
		labelNewBoard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelNewBoard, "cell 0 0 2 1,alignx center,aligny center");
		
		btnListaTableros = new JButton("Lista Tableros");
		btnListaTableros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnListaTableros, "cell 8 0,aligny center");
		
		inputX = new JTextField();
		contentPane.add(inputX, "cell 0 1,growx");
		inputX.setColumns(10);
		
		inputY = new JTextField();
		contentPane.add(inputY, "cell 1 1,growx");
		inputY.setColumns(10);
		contentPane.add(mapButton, "cell 0 2 2 1,alignx center,aligny center");
	}
	
	public void createNewFamily(){
		Board board = new Board(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()));
		board.setStart(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()), board));	
		board.setEnd(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()), board));
		Family a = new Family(board);
		map = new Map(board, a);
		map.setVisible(true);

	}
	



}
