<<<<<<< HEAD
package models;

public class Board {
	
    private int numberOfRows;
    private int numberOfColumns;
    
    private Cell[][] cells;

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public Board(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        cells = new Cell[numberOfRows][numberOfColumns];
        initCells();
    }
    
    private void initCells(){
        for (int y = 0; y < numberOfRows; y++){
            for (int x = 0; x < numberOfColumns; x++){
                cells[x][y] = new Cell(x,y,Cell.STATUS.EMPTY);
            }
        }
    }
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author teady
 */
public class Board {
    
>>>>>>> master
}