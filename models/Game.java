package models;

import java.util.*;

public class Game {
    
    private HashMap<String, Player> players;
    

    public Game(){

    }
    
    public boolean addPlayer(String playerTeam, Player newPlayer) throws Exception {
        
        Player existingPlayer = players.put(playerTeam, newPlayer);
        
        if(existingPlayer == null){
            return true;
        }else{
            throw new Exception("Player already exists.");
        }
        
    }
    
    public Player getPlayer(String playerTeam) throws Exception{
        Player player = players.get(playerTeam);
        
        if(player == null){
            throw new Exception("Specified player does not exist.");
        }else{
            return player;
        }
    }

    

}
