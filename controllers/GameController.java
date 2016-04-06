/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import models.Board;
import models.*;
import main.*;
import views.*;
import java.awt.event.*;
import javax.swing.*;

public class GameController {
    
    //models
    private Game game;
    private Board board;
    //private Player currentPlayer;
    
    //views
    private MainMenuView menu;
    
    //controllers
    private final PlayerController playerController;
    private final UnitController unitController;
    private BoardController boardController;
    
    
    public void startGame(){
<<<<<<< HEAD
    	
        //TODO get menu
        //TODO if menu true call init
=======
        System.out.println("Start Game");
        initGame();
        
        try{
            System.out.println("Explorer: " + game.getPlayer("Explorer").getName());
            System.out.println("Guardian: " + game.getPlayer("Guardian").getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
>>>>>>> Taison
        //TODO start turn(Player)
        //TODO start turn(Player 2)
        //TODO FUTURE loop turns
    }
    
<<<<<<< HEAD
    public void init(){
=======
    public void quitGame(){
        System.exit(0);
    }
    
    public void initGame(){
>>>>>>> Taison
        //TODO create players and units
        game = new Game();
        try{
            game.addPlayer("Explorer", playerController.newPlayer("Explorer"));
            game.addPlayer("Guardian", playerController.newPlayer("Guardian"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //TODO create board object
        board = new Board(20,20);
        
    }
    
    public void turn(Player player){
    	
        //TODO roll dice
        //TODO select unit --> waiting -->  if yes moveable (view), else no nothing
        //TODO select destination --> waiting --> if yes move, else do nothing
        //TODO ASSIGNMENT 2 - attack phase + ability phase
        //TODO end
    }
    
    public void showMainMenu(JFrame mainWindow){
        
        MenuActionListener listener = new MenuActionListener();
        menu = new MainMenuView(listener);
        mainWindow.getContentPane().add(menu);
        
        menu.setVisible(true);
        
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
        boardController = new BoardController(this);
        unitController = new UnitController(this);
        dice = new DiceUtility();
        
        //game = new Game(playerController.NewPlayer("Explorer"),playerController.NewPlayer("Guardian") );
    }
    public int rollDice(){
        return dice.roll();
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
}
