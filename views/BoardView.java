package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import models.Unit;
import models.Explorer.Hero;
import models.Explorer.Scout;
import models.Explorer.Tactician;
import models.Explorer.TrapMaster;
import models.Guardians.Behemoth;
import models.Guardians.Golem;
import models.Guardians.Hunter;
import models.Item.*;


public class BoardView extends JApplet {
	
	int row = 12;
	int column = 12;

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
					if (x==0 && y==0){
						p.add(cells[y][x] = new Cell(y,x, new Behemoth(x,y)));
					}
					else if (x==0 && y==column-1){
						p.add(cells[y][x] = new Cell(y,x, new Hunter(x,y)));
					}
					else if (x==column-1 && y==0){
						p.add(cells[y][x] = new Cell(y,x, new Golem(x,y)));
					}
				}
				
			    else if ((x==0 && y==0) || (x==0 && y==1) ||
						(x==1 && y==0)) { // set the gate color
					p.add(cells[y][x] = new Cell(y,x, new Gate(x,y)));
				}
				
				else if ((x==row-1 && y==column-1) || 
						(x==row-1 && y==column-2) || 
						(x==row-2 && y==column-1)|| 
						(x==row-2 && y==column-2)) { // set Explorer start point
					if (x==row-1 && y==column-1) {
						p.add(cells[y][x] = new Cell(y,x, new Hero(x,y)));
					}
					else if	(x==row-1 && y==column-2) {
						p.add(cells[y][x] = new Cell(y,x, new TrapMaster(x,y)));
					}
					else if (x==row-2 && y==column-1){
						p.add(cells[y][x] = new Cell(y,x, new Tactician(x,y)));
					}
					else if (x==row-2 && y==column-2){
						p.add(cells[y][x] = new Cell(y,x, new Scout(x,y)));
					}
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
		
		//Add the 'HUD' bar at the bottom of the screen to provide instructions and buttons
		add(new HudView().hud, BorderLayout.SOUTH);
		
		//Enable following line to show debug 'status' bar which shows information on cells clicked
		//add(jlblStatus, BorderLayout.SOUTH);
		
	}
	
	public Cell[][] getCells(){
		return cells;
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