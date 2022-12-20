package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import familybot.logic.controllers.SimulationController;
import familybot.logic.core.Board;
import familybot.logic.core.Coordinate;
import familybot.logic.core.Family;

import java.awt.Font;
import java.util.Random;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

public class MainWindows extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	private AuxiliarFamilyCreator auxiliarCreator;
	private JPanel panel_1;
	private JScrollPane scrollList;
	private JButton btnNewButton_1;
	private JPanel familyList;


	/**
	 * Create the frame.
	 */
	public MainWindows() {

		initComponents();
	}
	
	
	

	public void initComponents(){
		auxiliarCreator = new AuxiliarFamilyCreator();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 630);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnNewButton = new JButton("Crear Nueva Familia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxiliarCreator.setVisible(true);
			}
		});
		menuBar.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton_1);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[212.00,grow][700]", "[grow]"));
		
		panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollList = new JScrollPane();
		panel_1.add(scrollList);
		
		familyList = new JPanel();
		scrollList.setViewportView(familyList);
		familyList.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows frame = new MainWindows();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	public void test() {
		int i = 0;
		JButton a = new JButton(("Familia "+ Integer.toString(i)));
		familyList.add(a, "cell 0"+" " + i);
		scrollList.updateUI();
		i++;
	}

}
