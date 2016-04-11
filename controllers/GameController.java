/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;
import models.*;
import models.Explorer.*;
import models.Guardians.*;
import models.Item.*;
import views.BoardView.Cell;
import views.HudView;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.*;
import views.*;

public class GameController {
    
    //constants
    private static final int ROWS = 12;
    private static final int COLUMNS = 12;
    private static enum State {DICE_ROLL, ACTION, CHECK_WIN} 
    private State gameState;
    
    //models
    private Game game;
    //private Board board;
    //private Player currentPlayer;
    
    //views
    private MainMenuView menu;
    private BoardView boardView;
    private JFrame mainWindow;
    private HudView hudView;
    
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
        gameState = State.DICE_ROLL;
        
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
        
        hudView = new HudView();
        mainWindow.getContentPane().add(hudView.hud, BorderLayout.SOUTH);
        hudView.actionButton.addActionListener(new HUDActionListener());
        
        
        

    }
    
    
    public void initGame(){
    	Player guardian = getPlayerController().newPlayer("Guardian");
        Player explorer = getPlayerController().newPlayer("Explorer");
        initExplorerUnit(explorer);
        initGuardianUnit(guardian);
        
        setCurrentPlayer(explorer);
    }
    
    public void showMainMenu(){

	public void initExplorerUnit(Player player, BoardActionListener boardListener)
	{
		if (initExplorer)
		{
			JOptionPane.showMessageDialog(null, "Explorer already initialize");
		} else
		{
			// initExplorerUnit
			Hero hero = new Hero(11, 11);
			Scout scout = new Scout(10, 10);
			Tactician tactician = new Tactician(10, 11);
			TrapMaster trapMaster = new TrapMaster(11, 10);

			try
			{
				player.addUnit("hero", hero);
				boardView.initCells(boardListener, hero);
				player.addUnit("scout", scout);
				boardView.initCells(boardListener, scout);
				player.addUnit("tactician", tactician);
				boardView.initCells(boardListener, tactician);
				player.addUnit("trapMaster", trapMaster);
				boardView.initCells(boardListener, trapMaster);
				initExplorer = true;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void initGuardianUnit(Player player, BoardActionListener boardListener)
	{
		if (initGuardian)
		{
			JOptionPane.showMessageDialog(null, "Guardian already initialize");
		} else
		{
			// initGuardianUnit
			Behemoth behemoth = new Behemoth(0, 0);
			Golem golem = new Golem(11, 0);
			Hunter hunter = new Hunter(0, 11);

			try
			{
				player.addUnit("behemoth", behemoth);
				boardView.initCells(boardListener, behemoth);
				player.addUnit("golem", golem);
				boardView.initCells(boardListener, golem);
				player.addUnit("hunter", hunter);
				boardView.initCells(boardListener, hunter);
				initGuardian = true;

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initBoardUnit(BoardActionListener boardListener)
	{
		{
			if (initBoard)
			{
				JOptionPane.showMessageDialog(null, "Board already initialize");
			} else
			{
				// initBoard

				boardView = new BoardView(boardListener, ROWS, COLUMNS);
				for (int y = 0; y < COLUMNS; y++)
				{
					for (int x = 0; x < ROWS; x++)
					{
						BoardItem cell;
						if ((x == 0 && y == COLUMNS - 1) || (x == COLUMNS - 1 && y == 0))
						{ // set Guardian start point
							cell = new GuardianStartPoint(x, y);
						} else if ((x == ROWS - 1 && y == COLUMNS - 1) || (x == ROWS - 1 && y == COLUMNS - 2)
						        || (x == ROWS - 2 && y == COLUMNS - 1) || (x == ROWS - 2 && y == COLUMNS - 2))
						{ // set Explorer start point

							cell = new ExplorerStartPoint(x, y);
						} else if ((x == 0 && y == 0) || (x == 0 && y == 1) || (x == 1 && y == 0))
						{ // set the gate color
							cell = new Gate(x, y);
						}

						else
						{
							cell = new Ground(x, y);
						}

						boardView.initCells(boardListener, cell);
					}
				}

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
	}

	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}

	private static DiceUtility dice;

	// getter for testing only
	public PlayerController getPlayerController()
	{
		return playerController;
	}

	public int rollDice()
	{
		return dice.roll();
	}

	private void cellClicked(Unit unit)
	{
		System.out.println(unit.getX() +"       "+unit.getY());

        }
    

	private void quitGame()
	{
		// System.exit(0);
		return;
	}
    
    private boolean checkWin(){
    	//TODO Needs to be checked after updating to Taison's new code, at the moment it fails searching for a player
    	Map unitMap = null;
		try {
			unitMap = game.getPlayer("explorer").units;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		Iterator it = unitMap.entrySet().iterator();
		   while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        Unit unit = (Unit) pair.getValue();
		        if (unit.pos[0] == 0 && unit.pos[1] == 0 || unit.pos[0] == 0 && unit.pos[1] == 1 || unit.pos[0] == 1 && unit.pos[1] == 0){
		        	return(true);
		        }
		        it.remove(); // avoids a ConcurrentModificationException
		    }
    	
    	
    	return(false);
    }

	class MenuActionListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{

			String option = ((JButton) e.getSource()).getName();

			if (option == "startGame")
			{
				startGame();
			} else if (option == "options")
			{
				System.out.println("show the options menu here.");
			} else if (option == "quit")
			{
				quitGame();
			}

			menu.setVisible(false);
		}

	}

	class BoardActionListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{

			Unit unit = ((Cell) e.getSource()).getUnit();

			cellClicked(unit);

		}

	}
    
    //Determines what actions should be completed when HUD button is pressed and instigates them
    class HUDActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		//Move to action state
    		if (gameState == State.DICE_ROLL){
    			hudView.diceAmount.setText(String.valueOf(rollDice()));
    			gameState = State.ACTION;
    			hudView.setUnitState();
    		} 
    		//Move to check win state, restart if nobody won
    		else if (gameState == State.ACTION){
    			//Check if the player has won
    			gameState = State.CHECK_WIN;
    			boolean didWin = checkWin();
    			if (!didWin){
    				hudView.setDiceState();
    				//Swap to the next player, this could be changed later to facilitate more than 2 players
    				hudView.swapPlayer();
    				if (getCurrentPlayer().getTeam() == "Explorer"){
    					try {
							setCurrentPlayer(game.getPlayer("guardian"));
						} catch (Exception noPlayer) {
							System.out.println("Guardian player not found");
							noPlayer.printStackTrace();
						}    					
    				}
    				
    				else {
    					try {
							setCurrentPlayer(game.getPlayer("explorer"));
						} catch (Exception noPlayer) {
							System.out.println("Explorer player not found");
							noPlayer.printStackTrace();
						}    	
    				}
    				gameState = State.DICE_ROLL;
    			}
    			else {
    				hudView.setWinState();
    			}
    		}
    	}
    }

}
