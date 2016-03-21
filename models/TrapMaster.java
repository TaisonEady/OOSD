package models;

public class TrapMaster extends Explorer{


    public TrapMaster(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}

	public boolean useAbility(){
        System.out.println("TrapMaster use ability");
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
