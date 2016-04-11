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


public class BoardView extends JPanel {
	
	int rows = 12;
	int columns = 12;

	// Create and initialize cells
	private Cell[][] cells = new Cell[rows][columns];

	// Create and initialize a status label
	private JLabel jlblStatus = new JLabel("Start Game");

	/** Initialize UI */
	public BoardView(ActionListener listener, int rows, int columns) {
		
		super(new GridLayout(rows, columns, 0, 0));
                this.rows = rows;
                this.columns = columns;
                
                initCells(listener);

		// Set line borders on the cells panel and the status label
		this.setBorder(new LineBorder(Color.black, 1));
	}
	
	public Cell[][] getCells(){
		return cells;
	}

    private void initCells(ActionListener listener) {
        
        for (int y = 0; y < this.columns; y++){
            for (int x = 0; x < this.rows; x++) {

                if ((x == 0 && y == 0) || (x == 0 && y == this.columns - 1)
                        || (x == this.columns - 1 && y == 0)) { // set Guardian start point
                    if (x == 0 && y == 0) {
                        this.add(cells[y][x] = new Cell(y, x, new Behemoth(x, y), listener));
                    } else if (x == 0 && y == this.columns - 1) {
                        this.add(cells[y][x] = new Cell(y, x, new Hunter(x, y), listener));
                    } else if (x == this.columns - 1 && y == 0) {
                        this.add(cells[y][x] = new Cell(y, x, new Golem(x, y), listener));
                    }
                } else if ((x == 0 && y == 0) || (x == 0 && y == 1)
                        || (x == 1 && y == 0)) { // set the gate color
                    this.add(cells[y][x] = new Cell(y, x, new Gate(x, y), listener));
                } else if ((x == this.rows - 1 && y == this.columns - 1)
                        || (x == this.rows - 1 && y == this.columns - 2)
                        || (x == this.rows - 2 && y == this.columns - 1)
                        || (x == this.rows - 2 && y == this.columns - 2)) { // set Explorer start point
                    if (x == this.rows - 1 && y == this.columns - 1) {
                        this.add(cells[y][x] = new Cell(y, x, new Hero(x, y), listener));
                    } else if (x == this.rows - 1 && y == this.columns - 2) {
                        this.add(cells[y][x] = new Cell(y, x, new TrapMaster(x, y), listener));
                    } else if (x == this.rows - 2 && y == this.columns - 1) {
                        this.add(cells[y][x] = new Cell(y, x, new Tactician(x, y), listener));
                    } else if (x == this.rows - 2 && y == this.columns - 2) {
                        this.add(cells[y][x] = new Cell(y, x, new Scout(x, y), listener));
                    }
                } else {
                    this.add(cells[y][x] = new Cell(y, x, new Ground(x, y), listener));
                }
            }
        }
    }
	

	// An inner class for a cell
	public class Cell extends JButton {
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