package models.Guardians;

import javax.swing.ImageIcon;

public class Golem extends Guardian {

    public Golem(int x, int y)
	{
		super(x, y);
//		icon = new ImageIcon("bin/images/golem.png");
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean attack(){
        System.out.println("Golem attack!!!");
        return true;
    }

//    @Override
//    public boolean move(int x, int y) {
//    	int rollCount = 1;
//		// ^ need to pass a roll count ^
//		if(rollCount>2)
//			rollCount = 2;
//		int count ;
//		if(Math.abs(super.getX()-x)<Math.abs(super.getY()-y))
//		{
//			 count = Math.abs(super.getY()-y);
//		}
//		else
//		{
//			 count = Math.abs(super.getX()-x);
//		}
//		if(count >rollCount)
//		{
//			return false;
//		}
//		else
//		{
//			super.setPos(x, y);
//			// need to change roll count
//		return true;
//		}
//    }

    @Override
    public boolean useAbility() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public boolean moveable(int x,int y)
	{
		if(x >3 && y > 3)
		{
			return true;
		}
		else
		{
			return false;
		}
//		int rollCount = 1;
//		// ^ need to pass a roll count ^
//		if(rollCount>2)
//			rollCount = 2;
//		int max = 12;
//		// ^ need to pass a board max pos ^
//		if (rollCount != 0)
//		{
//			for (int i = -rollCount; i < 1 + rollCount; i++)
//			{
//				for (int j = -rollCount; j < 1 + rollCount; j++)
//				{
//					if (super.getX() + i > 1 && super.getX() + i < max + 1)
//					{
//						if (super.getY() + j > 1 && super.getY() + j < max + 1)
//						{
//							if(i+j !=0)
//							{
//							// change board square color
//							}
//						}
//					}
//				}
//			}
//
//		}
//		
	}

}
