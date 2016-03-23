/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import models.*;
import main.*;

public class GameController {
    private Game game;
    
    private PlayerController playerController;

    //getter for testing only
    public PlayerController getPlayerController() {
        return playerController;
    }
    //private BoardController boardController;
    private static DiceUtility dice;
    
    public GameController(){
        playerController = new PlayerController(this);
        //boardController = new BoardController(this);
        dice = new DiceUtility();
        
        //game = new Game(playerController.NewPlayer("Explorer"),playerController.NewPlayer("Guardian") );
    }
    public int rollDice(){
        return dice.roll();
    }
    
    
    
}
