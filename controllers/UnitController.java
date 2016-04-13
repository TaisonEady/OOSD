/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import javax.swing.JOptionPane;

import models.*;
import models.Actor;
import models.Explorer.Hero;
import models.Explorer.Scout;
import models.Explorer.Tactician;
import models.Explorer.TrapMaster;

public class UnitController {
    
    private GameController gameController;
     private static int[][] movePositions;

    public UnitController(GameController gameController) {
        this.gameController = gameController;
    }
    public void initExplorerUnit(Player player)
    {
    	
    		//initExplorerUnit
    		Hero hero = new Hero(0,0);
    		Scout scout = new Scout(0,0);
    		Tactician tactician = new Tactician(0,0);
    		TrapMaster trapMaster = new TrapMaster(0,0);
    		try
			{
				player.addUnit("hero", hero);
				player.addUnit("scout", scout);
				player.addUnit("tactician", tactician);
				player.addUnit("trapMaster", trapMaster);

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}

    public int move(Actor unit,Unit target)
    {
    	//if(target.getClass().getPackage().equals("models.Item"))
    	//{
    	int posX = unit.getX();
    	int posY = unit.getY();
    	unit.setPos(target.getX(), target.getY());
    	target.setPos(posX, posY);
    	    	return Math.max(Math.abs(unit.getX()-target.getX()), Math.abs(unit.getY()-target.getY()));


//    		int currX = unit.getPos()[0];
//    		int currY = unit.getPos()[1];
//    		unit.setPos(target.getX(),target.getY());
//    		target.setPos(currX, currY);
    	//}
    }
    public int[][] getMovable()
    {
    	return movePositions;
    }
    
    public int[][] movable(Actor unit, int rollCount){
        
        System.out.println(rollCount);
        
        movePositions = new int[(rollCount*2+1)*(rollCount*2+1)][2];
            
            int max = 12;
            int count= 0;
                // ^ need to pass a board max pos ^
                if (rollCount != 0)
                {
                    for (int i = -rollCount; i < 1 + rollCount; i++)
                    {
                        for (int j = -rollCount; j < 1 + rollCount; j++)
                        {
                            if(unit.moveable(i, j))
                            {
                            	
                                movePositions[count][0]= i + unit.getX();
                                movePositions[count][1]= j + unit.getY();
                                
                                count++;
                            }

                        }
                    }

                }

        return movePositions;
    }
    
}
