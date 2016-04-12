/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models;

import javax.swing.ImageIcon;

public abstract class Unit {
	public int[] pos = new int[2];
	public ImageIcon icon;

	private int[] initPos = new int[2];
	
    public Unit(int x, int y) {
    	this.initPos[0] = this.pos[0] = x;
    	this.initPos[1] = this.pos[1]= y;
    	
    	//icon = new ImageIcon("/bin/images/"+this.getClass().getSimpleName().toLowerCase()+".png");
        icon = new ImageIcon("/home/teady/NetBeansProjects/OOSD/gitRepo/images/"+this.getClass().getSimpleName().toLowerCase()+".png");
    	
    }
    public void setPos(int x, int y)
    {
    	pos[0]=x;
    	pos[1]=y;
    }
    public int[] getPos(){
    	return pos ;
    }
    public int getX(){
    	return pos[0];
    }
    public int getY(){
    	return pos[1];
    }
    public int[] getStartPos(){
    	return initPos ;
    }
    public ImageIcon getIcon(){
    	return icon;
    }
    public abstract boolean moveable(int x, int y);
}
