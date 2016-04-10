/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models.Guardians;

import javax.swing.ImageIcon;

public class Hunter extends Guardian
{

	public Hunter(int x, int y)
	{
		super(x, y);
//		icon = new ImageIcon("bin/images/hunter.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean attack()
	{
		System.out.println("Hunter attack!!!");
		return true;
	}

//	@Override
//	public boolean move(int x, int y)
//	{
//		int rollCount = 1;
//		// ^ need to pass a roll count ^
//		if(Math.abs(super.getX()-x)==Math.abs(super.getY()-y))
//		{
//			if(Math.abs(super.getX()-x)<rollCount +1)
//			{
//				super.setPos(x, y);
//				return true;
//			}
//		}
//		return false;
//
//	}

	@Override
	public boolean useAbility()
	{
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public boolean moveable(int x,int y)
	{
		if(x==y)
		{
			return true;
		}
		return false;
//		int rollCount = 1;
//		// ^ need to pass a roll count ^
//		int max = 12;
//		// ^ need to pass a board max pos ^
//		if (rollCount != 0)
//		{
//			for (int i = -rollCount; i < 1 + rollCount; i++)
//			{
//				if(i+i!=0)
//				{
//				if (super.getX() + i > 1 && super.getX() + i < max + 1)
//				{
//					if (super.getY() + i > 1 && super.getY() + i < max + 1)
//					{
//						// change board square color
//					}
//				}
//				if (super.getX() + i > 1 && super.getX() + i < max + 1)
//				{
//					if (super.getY() + -i > 1 && super.getY() + -i < max + 1)
//					{
//						// change board square color
//					}
//				}
//				}
//			}
//
//		}
	}

}
