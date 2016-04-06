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
	private int[] pos = new int[2];
	public ImageIcon icon;
	
    public Unit(int x, int y) {
    	this.pos[0] = x;
    	this.pos[1]= y;
    	icon = new ImageIcon("bin/images/"+this.getClass().getSimpleName().toLowerCase()+".png");
    	
    }
    
    
}
