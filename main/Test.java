package main;

import models.*;
import views.*;

public class Test {

	public void testView(){
    	// the test code
    	BoardView bv = new BoardView();
    	bv.drawBoard(); 
    }
    
    public void testModel(){
    	
    	// the test code
    	// three guardians
    	Guardian behemoth = new Behemoth();
    	System.out.println(behemoth.getName() + " says hello!.");
    	behemoth.attack();
    	System.out.println("");
    	
    	Guardian hunter = new Hunter();
    	System.out.println(hunter.getName() + " says hello!.");
    	hunter.attack();
    	System.out.println("");
    	
    	Guardian golem = new Golem();
    	System.out.println(golem.getName() + " says hello!.");
    	golem.attack();
    	System.out.println("");
    	
    	// four explorers
    	Explorer scout = new Scout();
    	System.out.println(scout.getName() + " says hello!.");
    	scout.useAbility();
    	System.out.println("");
    	
    	Explorer trapMaster = new TrapMaster();
    	System.out.println(trapMaster.getName() + " says hello!.");
    	trapMaster.useAbility();
    	System.out.println("");
    	
    	Explorer hero = new Hero();
    	System.out.println(hero.getName() + " says hello!.");
    	hero.useAbility();
    	System.out.println("");
    	
    	Explorer tactician = new Tactician();
    	System.out.println(tactician.getName() + " says hello!.");
    	tactician.useAbility();
    	System.out.println("");
    	
    	
    }
}
