/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.*;

/**
 *
 * @author teady
 */
public abstract class Player {
    
    protected String name;
    protected ArrayList<Unit> units;
    protected int unitCount;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
        return;
    }
  
    public void attack(){
		
	}
    
    public void useAbility(){
    	
    }

    
    public boolean addUnit(Unit unit){
        boolean status = false;
        
        return status;
    }
    
    public Unit getUnit(){
          
        return null;
    }
    
}
