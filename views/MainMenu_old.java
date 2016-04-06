//package views;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//public class MainMenu_old extends JPanel {
//    
//    public MainMenu_old(){
//        
//    }
//	
//	public void startGame(){
//		JFrame mainMenu = new JFrame("Our JButton listener example");
//		JButton startGame = new JButton("Start Game");
//		JButton quitGame = new JButton("Quit Game");
//		
//		startGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// Create a frame
//				JFrame frame = new JFrame("Board");
//
//				// Create an instance of the applet
//				Board applet = new Board();
//
//				// Add the applet instance to the frame
//				frame.add(applet, BorderLayout.CENTER);
//
//				// Display the frame
//				frame.setSize(700, 700);
//				frame.setVisible(true);
//			};
//		});
//		
//		quitGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
//		
//		mainMenu.getContentPane().setLayout(new FlowLayout());
//		mainMenu.add(startGame);
//		mainMenu.add(quitGame);
//		mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		mainMenu.setPreferredSize(new Dimension(300, 200));
//		mainMenu.pack();
//		mainMenu.setLocationRelativeTo(null);
//		mainMenu.setVisible(true);
//	}
//
//}
