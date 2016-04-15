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
