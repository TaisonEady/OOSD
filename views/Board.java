package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Board extends JApplet {
	
	int row = 20;
	int column = 20;

	// Create and initialize cells
	private Cell[][] cells = new Cell[row][column];

	// Create and initialize a status label
	private JLabel jlblStatus = new JLabel("Start Game");

	/** Initialize UI */
	public Board() {
		// Panel p to hold cells
		JPanel p = new JPanel(new GridLayout(row, column, 0, 0));
		for (int y = 0; y < column; y++)
			for (int x = 0; x < row; x++)
				p.add(cells[y][x] = new Cell(y, x));

		// Set line borders on the cells panel and the status label
		p.setBorder(new LineBorder(Color.black, 1));
		jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

		// Place the panel and the label to the applet
		add(p, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);
	}

	// An inner class for a cell
	
	//TODO change Cell to use Unit
	//TODO change Cell to grab image from Unit
	public class Cell extends JPanel {
		int xPos;
		int yPos;
		Color color;

		public Cell(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			setBorder(new LineBorder(Color.black, 1)); // Set cell's border
			addMouseListener(new MyMouseListener()); // Register listener
		}

		/** Set a new token */
		public void getPos(char c) {

			repaint();
		}

		/** Paint the cell */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.white); // background color
			int gridSize = 100;
			if ((xPos == 0 && yPos == 0) || (xPos == 0 && yPos == column-1) || 
					(xPos == column-1 && yPos == 0)) { // set Guardian start point
				g.setColor(Color.gray);
				g.fillRect(0, 0, 100, 100);
			} else if (xPos == 0 || yPos == 0 || xPos == row-1 || yPos == column-1) {
				g.setColor(Color.black);
				g.fillRect(0, 0, 100, 100);
			}
			if (xPos != 0 && yPos != 0 && xPos != row-1 && yPos != column-1) { // set normal grid
				if ((xPos == 1 && yPos == 1) || (xPos == 1 && yPos == 2) ||
						(xPos == 2 && yPos == 1)) { // set the gate color
					g.setColor(Color.blue);
					g.fillRect(0, 0, gridSize, gridSize);
				} else if ((xPos == row-2 && yPos == column-2) || (xPos == row-2 && yPos == column-3) || 
						(xPos == row-3 && yPos == column-2)|| (xPos == row-3 && yPos == column-3)) { 
					// set Explorer start point
					g.setColor(Color.green);
					g.fillRect(0, 0, gridSize, gridSize);
				}
				g.setColor(Color.black); // bounds color
				g.drawRect(0, 0, gridSize, gridSize);
			}

		}

		private class MyMouseListener extends MouseAdapter {
			/** Handle mouse click on a cell */
			public void mouseClicked(MouseEvent e) {
				jlblStatus.setText(String.valueOf(xPos) + ", " + String.valueOf(yPos));
			}
		}
	}
}
