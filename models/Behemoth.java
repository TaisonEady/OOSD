package models;

public class Behemoth extends Guardian {
	

    public Behemoth(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean attack(){
        System.out.println("Behemoth attack!!!");
        return true;
    }

    @Override
    public boolean move(int x, int y) {
    	int rollCount = 1;
		// ^ need to pass a roll count ^
    	if (Math.abs(super.getX()-x) != 0 && Math.abs(super.getY()-y)==0)
    	{
    		if(Math.abs(super.getX()-x) <rollCount +1)
    		{
    			super.setPos(x, y);
    			return true;
    		}
    	}
    	else if (Math.abs(super.getY()-y) != 0 && Math.abs(super.getX()-x)==0)
		{
    		if(Math.abs(super.getY()-y) <rollCount +1)
    		{
    			super.setPos(x, y);
    			return true;
    		}
		}
    	return false;
    }

    @Override
    public boolean useAbility() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void moveable()
	{
		int rollCount = 1;
		// ^ need to pass a roll count ^
		int max = 12;
		// ^ need to pass a board max pos ^
		if (rollCount != 0)
		{
			for (int i = -rollCount; i < 1 + rollCount; i++)
			{
				if (super.getX() + i > 1 && super.getX() + i < max + 1 && i!=0)
				{
					// change board square color
				}
			}
			for (int j = -rollCount; j < 1 + rollCount; j++)
			{
				if (super.getY() + j > 1 && super.getY() + j < max + 1 && j!=0)
				{
					// change board square color
				}
			}
		}
	}

        
        

}
