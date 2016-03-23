package models;

public abstract class Explorer extends Unit
{

	public Explorer(int x, int y, boolean alive)
	{
		super(x, y, alive);
		// TODO Auto-generated constructor stub
	}
	public boolean attack(int[] pos)
	{
		
		
		return false;
		
	}

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
				for (int j = -rollCount; j < 1 + rollCount; j++)
				{
					if (super.getX() + i > 1 && super.getX() + i < max + 1)
					{
						if (super.getY() + j > 1 && super.getY() + j < max + 1)
						{
							if(i+j !=0)
							{
							// change board square color
							}
						}
					}
				}
			}

		}
	}

	public boolean move(int x, int y)
	{
		int count;
		int rollCount = 1;
		// ^ need to pass a roll count ^
		if(Math.abs(super.getX()-x)<Math.abs(super.getY()-y))
		{
			 count = Math.abs(super.getY()-y);
		}
		else
		{
			 count = Math.abs(super.getX()-x);
		}
		if(count >rollCount)
		{
			return false;
		}
		else
		{
			super.setPos(x, y);
			// need to change roll count
		return true;
		}
	}

}
