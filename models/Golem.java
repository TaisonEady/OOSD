package models;

public class Golem extends Guardian {

    public Golem(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean attack(){
        System.out.println("Golem attack!!!");
        return true;
    }

    @Override
    public boolean move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean useAbility() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void moveable()
	{
		// TODO Auto-generated method stub
		
	}

}
