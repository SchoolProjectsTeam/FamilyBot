package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import familybot.logic.controllers.SimulationController;
import familybot.logic.core.Board;
import familybot.logic.core.Family;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AuxiliarFamilyCreator extends JFrame {

	private JPanel contentPane;
	private JTextField inputX;
	private JTextField inputY;
	private UiUtil util;


	public AuxiliarFamilyCreator() {
		initializate();
	}
	
	
	
	

	private void initializate() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][83.00][35.00,grow][]", "[][]"));
		
		JLabel lblText = new JLabel("Introduzca la dimensi\u00F3n del tablero");
		contentPane.add(lblText, "cell 0 0");
		
		JLabel lblX = new JLabel("X: ");
		contentPane.add(lblX, "cell 1 0,alignx right");
		
		inputX = new JTextField();
		contentPane.add(inputX, "cell 2 0,growx");
		inputX.setColumns(10);
		
		JLabel lblY = new JLabel("Y: ");
		contentPane.add(lblY, "cell 1 1,alignx trailing");
		
		inputY = new JTextField();
		inputY.setColumns(10);
		contentPane.add(inputY, "cell 2 1,growx");
		setLocationRelativeTo(null);
	}
	public void createNewFamily(){
		Board board = new Board(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()));
		board.setStart(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()), board));	
		board.setEnd(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()), board));
		Family a = new Family(board, "");//pendiente
		SimulationController.Get().loadFamilies().add(a);
	}
}
