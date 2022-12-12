package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindows extends JFrame {

	private JPanel contentPane;
	private JButton mapButton = new JButton("Lanzar Mapa");
	private Map map;
	private JTextField inputX;
	private JTextField inputY;


	/**
	 * Create the frame.
	 */
	public MainWindows() {
		initComponents();
		
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map = new Map(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()));
				map.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	
	

	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][][][][][][][232.00]", "[][][][][][][][][130.00]"));
		
		inputX = new JTextField();
		contentPane.add(inputX, "cell 0 0,growx");
		inputX.setColumns(10);
		
		inputY = new JTextField();
		contentPane.add(inputY, "cell 1 0,growx");
		inputY.setColumns(10);
		contentPane.add(mapButton, "cell 0 1,alignx center,aligny center");
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


}
