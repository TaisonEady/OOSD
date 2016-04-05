package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import models.Unit;
import models.Item.*;


public class BoardView extends JApplet {
	
	int row = 20;
	int column = 20;

	// Create and initialize cells
	private Cell[][] cells = new Cell[row][column];

	// Create and initialize a status label
	private JLabel jlblStatus = new JLabel("Start Game");

	/** Initialize UI */
	public BoardView() {
		// Panel p to hold cells
		JPanel p = new JPanel(new GridLayout(row, column, 0, 0));
		for (int y = 0; y < column; y++){
			for (int x = 0; x < row; x++){
				
				if ((x==0 && y==0) || (x==0 && y==column-1) || 
						(x==column-1 && y==0)) { // set Guardian start point
					p.add(cells[y][x] = new Cell(y,x, new GuardianStartPoint(x,y)));
				}
				
			    else if ((x==0 && y==0) || (x==0 && y==1) ||
						(x==1 && y==0)) { // set the gate color
					p.add(cells[y][x] = new Cell(y,x, new Gate(x,y)));
				}
				
				else if ((x==row-1 && y==column-1) || 
						(x==row-1 && y==column-2) || 
						(x==row-2 && y==column-1)|| 
						(x==row-2 && y==column-2)) { // set Explorer start point
					p.add(cells[y][x] = new Cell(y,x, new ExplorerStartPoint(x,y)));
				}
					
				else{
					p.add(cells[y][x] = new Cell(y,x, new Ground(x,y)));
				}
			}
		}
		// Set line borders on the cells panel and the status label
		p.setBorder(new LineBorder(Color.black, 1));
		jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

		// Place the panel and the label to the applet
		add(p, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);
	}
	

	// An inner class for a cell
	public class Cell extends JPanel {
		int x;
		int y;
		Unit unit;

		public Cell(int x, int y, Unit unit) {
			this.x = x;
			this.y = y;
			this.unit = unit;
			setBorder(new LineBorder(Color.black, 1)); // Set cell's border
			addMouseListener(new MyMouseListener()); // Register listener
		}

		/** Set a new token */
		public void darwPos() {
			repaint();
		}

		/** Paint the cell */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.white); // background color
			ImageIcon icon = unit.icon;
			g.drawImage(icon.getImage(),0,0,getSize().width,getSize().height,this);
		}

		private class MyMouseListener extends MouseAdapter {
			/** Handle mouse click on a cell */
			public void mouseClicked(MouseEvent e) {
				jlblStatus.setText(unit.getClass().getName() + "    Position: " + 
			String.valueOf(x) + ", " + String.valueOf(y));
			}
		}
	}
}