/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models.Explorer;

import javax.swing.ImageIcon;

public class Tactician extends Explorer{



    public Tactician(int x, int y)
	{
		super(x, y);
//		icon = new ImageIcon("bin/images/tactician.png");
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean useAbility(){
        System.out.println("Tactician use ability");
        return true;
    }

//    @Override
//    public boolean move(int x, int y) {
//    	boolean result =super.move(x, y);
//    	if(result ==true)
//    	System.out.println(this.getClass().getName()+" moved to target squre.");
//    	else
//    		System.out.println(this.getClass().getName()+" unable to move over there.");
//    	return result;
//    }

    @Override
    public boolean attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
