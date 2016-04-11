package views;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
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


public class BoardView extends JPanel {
	
	int row = 12;
	int column = 12;

	// Create and initialize cells
	private Cell[][] cells = new Cell[row][column];

	// Create and initialize a status label
	private JLabel jlblStatus = new JLabel("Start Game");

	/** Initialize UI */
	public BoardView(ActionListener listener) {
		// Panel p to hold cells
		JPanel p = new JPanel(new GridLayout(row, column, 0, 0));
		for (int y = 0; y < column; y++){
			for (int x = 0; x < row; x++){
				
				if ((x==0 && y==0) || (x==0 && y==column-1) || 
						(x==column-1 && y==0)) { // set Guardian start point
					if (x==0 && y==0){
						p.add(cells[y][x] = new Cell(y,x, new Behemoth(x,y), listener));
					}
					else if (x==0 && y==column-1){
						p.add(cells[y][x] = new Cell(y,x, new Hunter(x,y), listener));
					}
					else if (x==column-1 && y==0){
						p.add(cells[y][x] = new Cell(y,x, new Golem(x,y), listener));
					}
				}
				
			    else if ((x==0 && y==0) || (x==0 && y==1) ||
						(x==1 && y==0)) { // set the gate color
					p.add(cells[y][x] = new Cell(y,x, new Gate(x,y), listener));
				}
				
				else if ((x==row-1 && y==column-1) || 
						(x==row-1 && y==column-2) || 
						(x==row-2 && y==column-1)|| 
						(x==row-2 && y==column-2)) { // set Explorer start point
					if (x==row-1 && y==column-1) {
						p.add(cells[y][x] = new Cell(y,x, new Hero(x,y), listener));
					}
					else if	(x==row-1 && y==column-2) {
						p.add(cells[y][x] = new Cell(y,x, new TrapMaster(x,y), listener));
					}
					else if (x==row-2 && y==column-1){
						p.add(cells[y][x] = new Cell(y,x, new Tactician(x,y), listener));
					}
					else if (x==row-2 && y==column-2){
						p.add(cells[y][x] = new Cell(y,x, new Scout(x,y), listener));
					}
				}
					
				else{
					p.add(cells[y][x] = new Cell(y,x, new Ground(x,y), listener));
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
	
	public Cell[][] getCells(){
		return cells;
	}
	

	// An inner class for a cell
	public class Cell extends JPanel {
		int x;
		int y;
		Unit unit;

		public Cell(int x, int y, Unit unit, ActionListener listener) {
			this.x = x;
			this.y = y;
			this.unit = unit;
			setBorder(new LineBorder(Color.black, 1)); // Set cell's border
			addActionListener(listener); // Register listener
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
                
                public Unit getUnit(){
                    return this.unit;
                }

	}
}