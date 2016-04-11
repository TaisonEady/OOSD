/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package models;

import java.util.*;

public class Player {

    private final String name;
    private final String team;
    private Map<String, Unit> units;
    private int currentRoll;
    private int remainingMoves;
    
    public Player(String name, String team) {
        this.name = name;
        this.team = team;
        this.units = new HashMap<>();
    }
    
    public String getName(){
        return name;
    }
    
    public String getTeam() {
        return team;
    }

    public boolean addUnit(String unitType, Unit unit)throws Exception{
        Unit existingUnit = units.put(unitType, unit);
        
        if(existingUnit == null){
            return true;
        }else{
            throw new Exception("Unit already exists.");
        }
    }
    
    public Unit getUnit(){
          
        return null;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }

    public int getRemainingMoves() {
        return remainingMoves;
    }

    public void resetRemainingMoves(){
        remainingMoves = currentRoll;
    }
    
    public void subtractRemainingMoves(int movesToSubtract) {
        this.remainingMoves -= movesToSubtract;
    }
          
}
