/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models;

public class Tactician extends Explorer{



    public Tactician(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean useAbility(){
        System.out.println("Tactician use ability");
        return true;
    }

    @Override
    public boolean move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
