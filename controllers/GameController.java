/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import models.*;

public class GameController {
    private Game game;
    
    private PlayerController playerController;
    private BoardController boardController;
    
    public GameController(){
        playerController = new PlayerController(this);
        boardController = new BoardController(this);
        
        //game = new Game(playerController.NewPlayer("Explorer"),playerController.NewPlayer("Guardian") );
    }
    
    
    
}
