/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

//Not sure if this player controller will be needed yet...

package controllers;

import models.Player;
import views.PlayerNameView;

public class PlayerController {
    
    GameController gameController;

    PlayerController(GameController gameController) {
        this.gameController = gameController;
        
    }
    
    public Player newPlayer(String team){
        
        PlayerNameView playerNameView = new PlayerNameView(team);
        
        return null;
    }
        
}
