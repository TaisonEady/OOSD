/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models;



public abstract class Unit {
    
    private boolean alive;
	private int[] pos = new int[2] ;
	//pos[0] = xPos
	//pos[1] = yPos
	private boolean onBoard;
	
    public Unit(int x, int y, boolean alive) {
    	this.pos[0] = x;
    	this.pos[1]= y;
    	this.alive = alive;
    }
    
    
    public abstract boolean move();
    
    public abstract boolean attack();
    
    public abstract boolean useAbility();
    
    @Override
    public String toString(){
       return this.getClass().getSimpleName();
    }
    
    public boolean isAlive() {
        return this.alive;
    }

    public void setStatus(boolean alive) {
        this.alive = alive;
    }
    public int[] getPos(){
    	return pos ;
    }
    
}
