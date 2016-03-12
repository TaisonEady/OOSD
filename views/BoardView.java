package views;

import java.awt.*;
import javax.swing.*;

public class BoardView {
	
	public void drawBoard(){
		
		try {
			// use current OS windows style
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFrame jFrame = new JFrame();
		jFrame.setSize(810, 835);
		// center the window
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.getContentPane().add(new GridView());
	}
}
