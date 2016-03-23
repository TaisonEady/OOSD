/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

//Not sure if this player controller will be needed yet...

package controllers;

import javax.swing.*;
import models.Player;

public class PlayerController {
    
    GameController gameController;

    PlayerController(GameController gameController) {
        this.gameController = gameController;
    }
    
    public Player newPlayer(String team){

        //System.out.println(getNameInput(team) + "! Leader of the " +team+"s.");
        boolean accepted = false;
        String name = null;
        
        while(!accepted) {            
            try {
                name = validatedName(getNameInput(team));
                accepted = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        "Your name must be between 1 and 50 characters long.");
            }
        }
        
        Player newPlayer = new Player(name, team);

        return newPlayer;
    }
    
    //This is kind of view code but it seemed too simple to maka a view class just for this method...
    public String getNameInput(String team){
        String playerName = (String)JOptionPane.showInputDialog(
        "What is your name " + team + "?");
        
        return playerName;
    }

    private String validatedName(String nameInput) throws Exception{
        if(nameInput.length() < 1 || nameInput.length() > 50){
            throw new Exception("Name length is out of bounds");
        }
        return nameInput;
    }
}
