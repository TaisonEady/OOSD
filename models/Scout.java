package models;

public class Scout extends Explorer{



    public Scout(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}

	public boolean useAbility(){
        System.out.println("Scout use ability");
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
