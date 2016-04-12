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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import models.*;
import models.Explorer.*;
import models.Guardians.*;
import models.Item.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.*;
import views.*;
import views.BoardView.Cell;

public class GameController {

    //constants
    private static DiceUtility dice;


    public static enum State {
        DICE_ROLL, ACTION, CHECK_WIN
    };

    //models
    private Game game;
    //private Board board;

    //views
    private MainMenuView mainMenuView;
    private JFrame mainWindow;

    //controllers
    private final PlayerController playerController;
    private final UnitController unitController;
    private BoardController boardController;

    //Checks
    private static boolean initExplorer;
    private static boolean initGuardian;
    private static boolean initBoard;

    //State variables
    private Player currentPlayer;
    private Actor selectedActor;
    private State gameState;
    
    private static int[][] movePositions;
    private Unit selectedunit;
    private int countclick = 1;

    public GameController(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.game = new Game();
        playerController = new PlayerController(this);
        boardController = new BoardController(this);
        unitController = new UnitController(this);
        dice = new DiceUtility();
        gameState = State.DICE_ROLL;
    }

    public void startGame() {
        System.out.println("Start Game");
        try {
            initGame();
            System.out.println("Explorer: " + game.getPlayer("Explorer").getName());
            System.out.println("Guardian: " + game.getPlayer("Guardian").getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        boardController.showBoard(mainWindow);
        
        //resize the main window to fit the size of the components.
        mainWindow.pack();

    }

    public void initGame() throws Exception{
        game.addPlayer("Guardian", playerController.newPlayer("Guardian"));
        setCurrentPlayer(game.addPlayer("Explorer", playerController.newPlayer("Explorer")));
                
        boardController.initBoard();
        boardController.initExplorerUnit(game.getPlayer("Explorer"));
        boardController.initGuardianUnit(game.getPlayer("Guardian"));
    }

    public void showMainMenu() {

        MenuActionListener listener = new MenuActionListener();
        mainMenuView = new MainMenuView(listener);
        mainWindow.getContentPane().add(mainMenuView);

        mainMenuView.setVisible(true);

    }

    
    State getGameState() {
        return this.gameState;
    }
    
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private boolean checkWin() {
        //TODO Needs to be checked after updating to Taison's new code, at the moment it fails searching for a player
        /*Map unitMap = null;
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
    	
         */
        return (false);
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        System.out.println(currentPlayer);
    }

    public int rollDice() {
        return dice.roll();
    }

    public void cellClicked(Unit unit) {
        System.out.println(unit);

        if (gameState == State.DICE_ROLL || gameState == State.CHECK_WIN) {
            return;
        }

        if(currentPlayer.hasUnit(unit)){
            boardController.drawMovable(unitController.movable((Actor)unit, currentPlayer.getRemainingMoves()));
            selectedActor = (Actor)unit;
        }else if(unit instanceof MovableGround){
            unitController.move(selectedActor, unit);
        }


//        System.out.println(unit.getX() + "       " + unit.getY());
//
//        if (countclick == 1) {
//            selectedunit = unit;
//        }
//        int rollCount = 3;
//
//        movePositions = new int[(rollCount * 2 + 1) * (rollCount * 2 + 1)][2];
//        int max = 12;
//        int count = 0;
//        // ^ need to pass a board max pos ^
//        if (countclick == 1) {
//
//            if (rollCount != 0) {
//                for (int i = -rollCount; i < 1 + rollCount; i++) {
//                    for (int j = -rollCount; j < 1 + rollCount; j++) {
//                        if (Math.abs(i) + Math.abs(j) != 0 && unit.moveable(i, j)) {
//
//                            movePositions[count][0] = i + selectedunit.getX();
//                            movePositions[count][1] = j + selectedunit.getY();
//                            count++;
//                        }
//
//                    }
//                }
//
//            }
//            for (int i = 0; i < count + 1; i++) {
//                System.out.println(movePositions[i][0] + "   -    " + movePositions[i][1]);
//
//            }
//            boardController.drawMovable(movePositions);
//        } else if (countclick == 2) {
//            for (int i = 0; i < count + 1; i++) {
//                System.out.println(movePositions[i][0] + "   -    " + movePositions[i][1]);
//
//            }
//            selectedunit.setPos(unit.getX(), unit.getY());
//            boardController.updateBoard(selectedunit, movePositions);
//
//        }
//        countclick++;
    }

    private void quitGame() {
        // System.exit(0);
        return;
    }

    public Actor getSelectedActor() {
        return selectedActor;
    }

    public void setSelectedActor(Actor selectedActor) {
        this.selectedActor = selectedActor;
    }

    //getter for testing only
    public PlayerController getPlayerController() {
        return playerController;
    }

    //TODO reset the dice value after end turn is pressed
    public void hudButtonClicked(){
     //Determines what actions should be completed when HUD button is pressed and instigates them
        if (gameState == GameController.State.DICE_ROLL) {
            //player rolls dice
            playerController.newDiceRoll(currentPlayer, rollDice());
            
            //update the hud view with the new dice amount
            boardController.setDiceRoll(currentPlayer.getRemainingMoves()); //TODO possibly move current player to player controller
            gameState = GameController.State.ACTION;
            boardController.setUnitState();
        } //Move to check win state, restart if nobody won
        else if (gameState == GameController.State.ACTION) {
            //Check if the player has won
            gameState = GameController.State.CHECK_WIN;
            boolean didWin = checkWin();
            if (!didWin) {
                boardController.setDiceState();
                //Swap to the next player, this could be changed later to facilitate more than 2 players
                boardController.swapPlayer();
                if (getCurrentPlayer().getTeam() == "Explorer") {
                    try {
                        setCurrentPlayer(game.getPlayer("Guardian"));
                    } catch (Exception noPlayer) {
                        System.out.println("Guardian player not found");
                        noPlayer.printStackTrace();
                    }
                } else {
                    try {
                        setCurrentPlayer(game.getPlayer("Explorer"));
                    } catch (Exception noPlayer) {
                        System.out.println("Explorer player not found");
                        noPlayer.printStackTrace();
                    }
                }
                gameState = GameController.State.DICE_ROLL;
            } else {
                boardController.setWinState();
            }
        }
    }



    class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String option = ((JButton) e.getSource()).getName();

            switch (option) {
                case "startGame":
                    startGame();
                    break;
                case "options":
                    System.out.println("show the options menu here.");
                    break;
                case "quit":
                    quitGame();
                    break;
                default:
                    break;
            }
            
    mainMenuView.setVisible(false); //remove the menu component
        }
    }
}
