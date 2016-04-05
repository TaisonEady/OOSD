package models.Explorer;

import javax.swing.ImageIcon;

public class Scout extends Explorer{



    public Scout(int x, int y)
	{
		super(x, y);
		icon = new ImageIcon("src/image/scout.png");
		// TODO Auto-generated constructor stub
	}

	public boolean useAbility(){
        System.out.println("Scout use ability");
        return true;
    }
    @Override
    
    public boolean move(int x, int y) {
    	boolean result =super.move(x, y);
    	if(result ==true)
    	System.out.println(this.getClass().getName()+" moved to target squre.");
    	else
    		System.out.println(this.getClass().getName()+" unable to move over there.");
    	return result;
    }


    @Override
    public boolean attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
