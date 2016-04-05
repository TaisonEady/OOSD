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
    private final PlayerController playerController;
    private final UnitController unitController;
    //private BoardController boardController;
    
    private Player currentPlayer;
    
    public void startGame(){
        //TODO get menu
        //TODO if menu true call init
        //TODO start turn(Player)
        //TODO start turn(Player 2)
        //TODO FUTURE loop turns
    }
    
    public void init(){
        //TODO create players and units
        //TODO create board object
    }
    
    public void turn(Player player){
        //TODO roll dice
        //TODO select unit --> waiting -->  if yes moveable (view), else no nothing
        //TODO select destination --> waiting --> if yes move, else do nothing
        //TODO ASSIGNMENT 2 - attack phase + ability phase
        //TODO end
    }
    
    

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    private static DiceUtility dice;

    //getter for testing only
    public PlayerController getPlayerController() {
        return playerController;
    }
    
    public GameController(){
        playerController = new PlayerController(this);
        //boardController = new BoardController(this);
        unitController = new UnitController(this);
        dice = new DiceUtility();
        
        //game = new Game(playerController.NewPlayer("Explorer"),playerController.NewPlayer("Guardian") );
    }
    public int rollDice(){
        return dice.roll();
    }
    
}
