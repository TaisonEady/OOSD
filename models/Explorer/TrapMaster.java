package models.Explorer;

import javax.swing.ImageIcon;

public class TrapMaster extends Explorer{


    public TrapMaster(int x, int y)
	{
		super(x, y);
//		icon = new ImageIcon("bin/images/trapMaster.png");
		// TODO Auto-generated constructor stub
	}

	public boolean useAbility(){
        System.out.println("TrapMaster use ability");
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
