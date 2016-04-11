/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import models.*;
import models.Explorer.*;
import models.Guardians.*;
import models.Item.*;
import views.BoardView.Cell;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.*;
import views.*;

public class GameController {
    
    //constants
    private static final int ROWS = 12;
    private static final int COLUMNS = 12;
    
    //models
    private Game game;
    //private Board board;
    //private Player currentPlayer;
    
    //views
    private MainMenuView menu;
    private BoardView boardView;
    private JFrame mainWindow;
    
    //controllers
    private final PlayerController playerController;
    private final UnitController unitController;
    private BoardController boardController;
    
    //Checks
    private static boolean initExplorer;
    private static boolean initGuardian;
    private static boolean initBoard;
    
    
    private Player currentPlayer;
    
    public GameController(JFrame mainWindow){
        this.mainWindow = mainWindow;
        
        playerController = new PlayerController(this);
        //boardController = new BoardController(this);
        unitController = new UnitController(this);
        dice = new DiceUtility();
        
        //game = new Game(playerController.NewPlayer("Explorer"),playerController.NewPlayer("Guardian") );
    }
    
    public void startGame(){
        System.out.println("Start Game");
        initGame();
        
        try{
            System.out.println("Explorer: " + game.getPlayer("Explorer").getName());
            System.out.println("Guardian: " + game.getPlayer("Guardian").getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        boardView = new BoardView(new BoardActionListener(),ROWS, COLUMNS);
        mainWindow.getContentPane().add(boardView);
        boardView.setVisible(true);
        //TODO start turn(Player)
        //TODO start turn(Player 2)
        //TODO FUTURE loop turns
    }
    
    public void initGame(){
    	Player guardian = getPlayerController().newPlayer("Guardian");
        Player explorer = getPlayerController().newPlayer("Explorer");
        initExplorerUnit(explorer);
        initGuardianUnit(guardian);
        

        //TODO create players and units
        //TODO create board object
    }
    
    public void showMainMenu(){

        MenuActionListener listener = new MenuActionListener();
        menu = new MainMenuView(listener);
        mainWindow.getContentPane().add(menu);

        menu.setVisible(true);
        
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
    
    public int rollDice(){
        return dice.roll();
    }
    
    private void cellClicked(Unit unit) {
        System.out.println(unit);
    }
    
    private void quitGame() {
//        System.exit(0);
          return;
    }
    
    class MenuActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            
            String option = ((JButton)e.getSource()).getName();
            
            if(option == "startGame"){
                startGame();
            }else if(option == "options"){
                System.out.println("show the options menu here.");
            }else if(option == "quit"){
                quitGame();
            }
            
            menu.setVisible(false);
        }

    }
    
    class BoardActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            
            Unit unit  = ((Cell)e.getSource()).getUnit();
            
            cellClicked(unit);

        }

    }
    
}
