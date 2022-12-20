package familybot;

import java.awt.EventQueue;

import UI.MainWindows;

public class App {

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
