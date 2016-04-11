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
import models.Explorer.*;
import models.Guardians.*;
import models.Item.*;
import views.BoardView.Cell;

import javax.swing.JOptionPane;

import main.*;

public class GameController {
    private Game game;
    private final PlayerController playerController;
    private final UnitController unitController;
    private static boolean initExplorer;
    private static boolean initGuardian;
    private static boolean initBoard;
    
	private int row = 12;
	private int column = 12;
	
	private Cell[][] cells = new Cell[row][column];
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
    	Player guardian = getPlayerController().newPlayer("Guardian");
        Player explorer = getPlayerController().newPlayer("Explorer");
        initExplorerUnit(explorer);
        initGuardianUnit(guardian);
        

        //TODO create players and units
        //TODO create board object
    }
    
    public void turn(Player player){
    	//hudView.updateHUD(0, "Please roll dice", false);
    	player.setCurrentRoll(rollDice());
    	//hudView.updateHUD(player.getCurrentRoll(), "Please select unit", false);
             //TODO select unit --> waiting -->  if yes moveable (view), else no nothing
        //hudView.updateHUD(player.getCurrentRoll(), "Where would you like to move?", true);
        //TODO select destination --> waiting --> if yes move, else do nothing
        //TODO ASSIGNMENT 2 - attack phase + ability phase
        //TODO end
    }
    
    public void initExplorerUnit(Player player)
    {
    	if(initExplorer)
    	{
    		JOptionPane.showMessageDialog(null, 
                    "Explorer already initialize");
    	}
    	else
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
				initExplorer = true;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }
    public void initGuardianUnit(Player player)
    {
    	if(initGuardian)
    	{
    		JOptionPane.showMessageDialog(null, 
                    "Guardian already initialize");
    	}
    	else
    	{
    		//initGuardianUnit
    		Behemoth behemoth = new Behemoth(0,0);
    		Golem golem = new Golem(0,0);
    		Hunter hunter = new Hunter(0,0);

    		try
			{
				player.addUnit("behemoth", behemoth);
				player.addUnit("golem", golem);
				player.addUnit("hunter", hunter);
				initGuardian = true;

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    public void initBoardUnit()
    {
    	if(initBoard)
    	{
    		JOptionPane.showMessageDialog(null, 
                    "Board already initialize");
    	}
    	else
    	{
    		//initBoard
 
    		try
			{

				initBoard = true;

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
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
