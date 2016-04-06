
package models;

public class Cell {  
    
    public enum STATUS {
        EMPTY,
        GATEWAY,
        OCCUPIED
    }
    
    int xPos;
    int yPos;
    Unit unit;
    STATUS status;
    
    public Cell(int xPos, int yPos, STATUS status) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.unit = null;
            this.status = status;
    }
}

