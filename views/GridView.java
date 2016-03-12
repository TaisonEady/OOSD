/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package views;

import java.awt.*;
import javax.swing.*;

public class GridView extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int gridSize = 30; // the grid size

		this.setBackground(Color.white); // background color
		g2d.translate(275, 75);
		g2d.rotate(Math.toRadians(45)); // rotate the grid
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if ((x == 0 && y == 0) || (x == 0 && y == 11) 
						|| (x == 11 && y == 0)) { // set Guardian start point
					g2d.setColor(Color.gray);
					g2d.fillOval(x * gridSize-50, y * gridSize-50, gridSize, gridSize);
				}
				if (x != 0 && y != 0 && x != 11 && y != 11) { // set normal grid
					if ((x == 1 && y == 1) || (x == 1 && y == 2)
							|| (x == 2 && y == 1)) { // set the gate color
						g2d.setColor(Color.blue);
						g2d.fillRect(x * gridSize-50, y * gridSize-50, gridSize, gridSize);
					} else if ((x == 10 && y == 10) || (x == 10 && y == 9) || (x == 9 && y == 10)
							|| (x == 9 && y == 9)) { // set Explorer start point
						g2d.setColor(Color.green);
						g2d.fillRect(x * gridSize-50, y * gridSize-50, gridSize, gridSize);
					}
					g2d.setColor(Color.black);  // bounds color
					g2d.drawRect(x * gridSize-50, y * gridSize-50, gridSize, gridSize);
				}
			}
		}
	}
}
