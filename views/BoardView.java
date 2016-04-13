<<<<<<< HEAD
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

<<<<<<< HEAD
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
=======
public class BoardView extends JPanel{
	
    public BoardView(int numberOfRows, int numberOfColumns){
        super(new GridLayout(numberOfRows, numberOfColumns, 0, 0));
    }
}

        // Set line borders on the cells panel and the status label
        p.setBorder(new LineBorder(Color.black, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

        // Place the panel and the label to the applet
        add(p, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
>>>>>>> Taison
=======
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import models.BoardItem;
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

    // Create and initialize cells
    private Cell[][] cells;

    int[][] test = {{2, 3}, {3, 4}, {4, 5}};

    /**
     * Initialize UI
     */
    public BoardView(ActionListener listener, int rows, int columns) {

        super(new GridLayout(rows, columns, 0, 0));
        this.setPreferredSize(new Dimension(700, 700));
        cells = new Cell[rows][columns];
        // Set line borders on the cells panel and the status label
        this.setBorder(new LineBorder(Color.black, 1));

    }

    public Cell[][] getCells() {
        return cells;
    }
    public Unit getUnit(int x, int y)
    {
		return cells[x][y].getUnit();
    	
    }

    public void drawMovable(int[][] area) {
        for (int i = 0; i < area.length ; i++) {
        	
            try {
            	if(cells[area[i][0]][area[i][1]].getUnit() instanceof BoardItem)
            	{
            	System.out.println(area[i][0]+"    -    "+area[i][1]);
            	
                cells[area[i][0]][area[i][1]].setUnit(new MovableGround(area[i][0], area[i][1]));
                cells[area[i][0]][area[i][1]].repaint();
            	}
            } catch (Exception e) {

            }
        	}
        
        System.out.println("movable end");
    }

    public void updateBoard(int[][] area) {

    	for (int i = 0; i < area.length; i++) {

    			try {
                	if(cells[area[i][0]][area[i][1]].getUnit() instanceof BoardItem)
                	{
                	System.out.println(area[i][0]+"    -    "+area[i][1]);
                	if ((area[i][0] == 0 && area[i][1] == 0) || (area[i][0] == 0 && area[i][1] == 1) || (area[i][0] == 1 && area[i][1] == 0)) { // set the gate color
                		cells[area[i][0]][area[i][1]].setUnit(new Gate(area[i][0], area[i][1]));
                        cells[area[i][0]][area[i][1]].repaint();
                    }
                	else
                	{
                    cells[area[i][0]][area[i][1]].setUnit(new Ground(area[i][0], area[i][1]));
                    cells[area[i][0]][area[i][1]].repaint();
                	}
                	}
                } catch (Exception e) {

                }
            	}
            
    		
        
//        cells[unit.getX()][unit.getY()].setUnit(unit);
//        cells[unit.getX()][unit.getY()].repaint();
//        for (int i = 0; i < area.length - 1; i++) {
//            try {
//                if (cells[unit.getX()][unit.getY()].getX() == cells[area[i][0]][area[i][1]].getX() && cells[area[i][0]][area[i][1]].getY() == cells[unit.getX()][unit.getY()].getY()) {
//
//                } else {
//                    cells[area[i][0]][area[i][1]].setUnit(new Ground(area[i][0], area[i][1]));
//                    cells[area[i][0]][area[i][1]].repaint();
//                }
//            } catch (Exception e) {
//
//            }
//        }
    }

    public void initCells(ActionListener listener, Unit cell) {

        if (cells[cell.getX()][cell.getY()] == null) {
            this.add(cells[cell.getX()][cell.getY()] = new Cell(cell.getX(), cell.getY(), cell, listener));
        } else {
            cells[cell.getX()][cell.getY()].setUnit(cell);
        }

    }
    public void darwPos(Unit unit) {
    	cells[unit.getX()][unit.getY()].setUnit(unit);
        cells[unit.getX()][unit.getY()].repaint();
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

        /**
         * Set a new token
         */
        public void darwPos() {
            repaint();
        }

        /**
         * Paint the cell
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(null); // background color
            ImageIcon icon = unit.icon;

            g.drawImage(icon.getImage(), 0, 0, getSize().width, getSize().height, this);
        }

        public Unit getUnit() {
            return this.unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }
    }
}
>>>>>>> master
