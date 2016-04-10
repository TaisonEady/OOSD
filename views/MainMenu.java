package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainMenu {
	
	public void startGame(){
		JFrame mainMenu = new JFrame("Our JButton listener example");
		JButton startGame = new JButton("Start Game");
		JButton quitGame = new JButton("Quit Game");
		mainMenu.setResizable(false);
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a frame
				JFrame frame = new JFrame("Board");

				// Create an instance of the applet
				BoardView applet = new BoardView();

				// Add the applet instance to the frame
				frame.add(applet, BorderLayout.CENTER);

				// Display the frame
				frame.setSize(700, 700);
				frame.setVisible(true);
			};
		});
		
		quitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mainMenu.getContentPane().setLayout(new FlowLayout());
		mainMenu.add(startGame);
		mainMenu.add(quitGame);
		mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainMenu.setPreferredSize(new Dimension(300, 200));
		mainMenu.pack();
		mainMenu.setLocationRelativeTo(null);
		mainMenu.setVisible(true);
	}

}
