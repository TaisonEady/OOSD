package models;

import java.util.*;

public class Game {
    
<<<<<<< HEAD
    private HashMap<String, Player> players;
    
    public Game(){
        players = new HashMap<>(); 
    }
    
    public void addPlayer(String playerTeam, Player newPlayer) throws Exception {
        
        Player existingPlayer = players.put(playerTeam, newPlayer);
        
        if(existingPlayer != null){
=======
    private Map<String, Player> players;
    private Board board;   

    public Game(){
        this.players = new HashMap<>();
    }
    
    public Player addPlayer(String playerTeam, Player newPlayer) throws Exception {
        
        Player existingPlayer = players.put(playerTeam, newPlayer);
        
        if(existingPlayer == null){
            return newPlayer;
        }else{
>>>>>>> master
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
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    

}
