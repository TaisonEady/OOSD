/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import models.*;
import models.Character;

public class UnitController {
    
    private GameController gameController;

    public UnitController(GameController gameController) {
        this.gameController = gameController;
    }
    
    public int[][] movable(Character unit){
        int rollCount = gameController.rollDice();//getCurrentPlayer().getRemainingMoves();
        
        System.out.println(rollCount);
        
        int[][] movePositions = new int[169][2];
            
            int max = 12;
            int count= 0;
                // ^ need to pass a board max pos ^
                if (rollCount != 0)
                {
                    for (int i = -rollCount; i < 1 + rollCount; i++)
                    {
                        for (int j = -rollCount; j < 1 + rollCount; j++)
                        {
                            if(i+j !=0)
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
