/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package main;

import controllers.GameController;
<<<<<<< HEAD
import javax.swing.BoxLayout;
=======
>>>>>>> master
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TheChase {

	public static void main(String[] args) {

<<<<<<< HEAD
            GameController gameController = new GameController();
            
            JFrame mainWindow = new JFrame();
            mainWindow.setSize(800,300);
            //mainWindow.getContentPane().setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));
            mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // center the window
            mainWindow.setLocationRelativeTo(null);
            //mainWindow.getContentPane().setLayout();
            mainWindow.setVisible(true);
            
            gameController.showMainMenu(mainWindow);

//		// test Model and View, you can block View/Model to test another
//
//		Test tester = new Test();
//		tester.testView();
//		tester.testModel();
//		tester.testController();
=======
		JFrame mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setSize(700, 700);
		mainWindow.setVisible(true);

		GameController gameController = new GameController(mainWindow);

		gameController.showMainMenu();
		mainWindow.pack();

		// test Model and View, you can block View/Model to test another
		// GameController gameController = new GameController();
		// gameController.startGame();

		// Test tester = new Test();
		// tester.testView();
		// tester.testModel();
		// tester.testController();
>>>>>>> master
	}
}
