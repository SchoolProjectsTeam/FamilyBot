package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import familybot.logic.controllers.SimulationController;
import familybot.logic.core.Board;
import familybot.logic.core.Family;

import net.miginfocom.swing.MigLayout;

import java.util.Random;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

public class MainWindows extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2736362071613527529L;
	private JPanel contentPane;
	private JPanel panel;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	private AuxiliarFamilyCreator auxiliarCreator;
	private JPanel panel_1;
	private JScrollPane scrollList;
	private JPanel familyList;
	private JButton btnNewButton_1;


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
		
		btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFamilys();
			}
		});
		menuBar.add(btnNewButton_1);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[528.00,grow]", "[grow]"));
		
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

	private void updateFamilys() {
		int i = 0;
		for (Family family : SimulationController.Get().loadFamilies()) {
			JButton a = new JButton(family.getFrindlyID());
			familyList.add(a, "cell 0" + " " + i);
			i++;
		}
		contentPane.updateUI();
	}
	
}
