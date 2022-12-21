package cu.edu.cujae.ceis.familybot.ui;

import cu.edu.cujae.ceis.familybot.logic.controllers.SimulationController;
import cu.edu.cujae.ceis.familybot.logic.core.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class AuxiliarFamilyCreator extends JFrame
{

    private JPanel contentPane;
    private JTextField inputX;
    private JTextField inputY;

    private UiUtil util;
    private JTextField textName;
    private ArrayList<Map> maps;

    public AuxiliarFamilyCreator()
    {
        initializate();
        util = new UiUtil();
    }

    private void initializate()
    {
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow][83.00][35.00,grow][]", "[40][40][40][grow]"));

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

        JLabel lblIntroduzcaElNombre = new JLabel("Introduzca el nombre de la familia");
        contentPane.add(lblIntroduzcaElNombre, "cell 0 2");

        textName = new JTextField();
        textName.setColumns(10);
        contentPane.add(textName, "cell 1 2 2 1,growx");

        JPanel panel = new JPanel();
        contentPane.add(panel, "cell 0 3 4 1,grow");

        JButton btnNewButton = new JButton("Generar");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                createNewFamily();
                setVisible(false);
            }
        });
        panel.add(btnNewButton);
        setLocationRelativeTo(null);
    }

    public void createNewFamily()
    {
        Board board = new Board(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.getText()));
        board.setStart(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.parseInt(inputY.
                                                     getText()), board));
        board.setEnd(util.generateRandomCoordinate(Integer.parseInt(inputX.getText()), Integer.
                                                   parseInt(inputY.getText()), board));
        for(int i = 0; i<board.maxSteps()/2;i++) {
        	boolean flag = true;
        	while(flag) {
        		try {
        			board.addBlocked(util.generateRandomCoordinate(board.getX(), board.getY(), board));
        			flag = false;
				} catch (IllegalArgumentException e) {
					flag = true;
				} 
        	}
        }
        SimulationController.Get().createFamily(board, textName.getText());
    }
}
