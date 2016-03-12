package models;

public class Game {
    private final Player explorerPlayer;
    private final Player guardianPlayer;

    public Game(Player explorerPlayer, Player guardianPlayer){
        this.explorerPlayer = explorerPlayer;
        this.guardianPlayer = guardianPlayer;
    }
    
    public Player getExplorerPlayer() {
        return explorerPlayer;
    }

    public Player getGuardianPlayer() {
        return guardianPlayer;
    }
    

}
