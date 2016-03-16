/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models;



public abstract class Unit {
    
    final int ALIVE = 1;
    final int DEAD = 0;
    
    private int status;
    private int xPos,yPos;

    public Unit() {
        this.status = ALIVE;
    }
    
    public abstract boolean move();
    
    public abstract boolean attack();
    
    public abstract boolean useAbility();
    
    @Override
    public String toString(){
       return this.getClass().getSimpleName();
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
