package cu.edu.cujae.ceis.familybot.ui;

import cu.edu.cujae.ceis.familybot.logic.controllers.SimulationController;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

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
				updateFamilystest();
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
		familyList.setLayout(new MigLayout("", "[131.00]", "[]"));
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
		familyList.removeAll();
		for (Family family : SimulationController.Get().loadFamilies()) {
			JButton a = new JButton(i + " " + family.getFrindlyID());
			familyList.add(a, "cell 0" + " " + i);
			i++;
			a.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Map map = new Map(family);
					map.setVisible(true);
				}
			});
		}
		contentPane.updateUI();
	}
	private void updateFamilystest() {
		int i = 0;
		familyList.removeAll();
		for (int j = 0; j<10;j++) {
			JButton a = new JButton(i + " " );
			familyList.add(a, "cell 0" + " " + i);
			i++;
			a.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("no fue en vano bro" );
				}
			});
		}
		contentPane.updateUI();
	}
	
}
