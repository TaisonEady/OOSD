/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

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
    	Unit behemoth = new Behemoth();
    	System.out.println(behemoth.toString() + " says hello!.");
    	behemoth.attack();
    	System.out.println("");
    	
    	Unit hunter = new Hunter();
    	System.out.println(hunter.toString() + " says hello!.");
    	hunter.attack();
    	System.out.println("");
    	
    	Unit golem = new Golem();
    	System.out.println(golem.toString() + " says hello!.");
    	golem.attack();
    	System.out.println("");
    	
    	// four explorers
    	Unit scout = new Scout();
    	System.out.println(scout.toString() + " says hello!.");
    	scout.useAbility();
    	System.out.println("");
    	
    	Unit trapMaster = new TrapMaster();
    	System.out.println(trapMaster.toString() + " says hello!.");
    	trapMaster.useAbility();
    	System.out.println("");
    	
    	Unit hero = new Hero();
    	System.out.println(hero.toString() + " says hello!.");
    	hero.useAbility();
    	System.out.println("");
    	
    	Unit tactician = new Tactician();
    	System.out.println(tactician.toString() + " says hello!.");
    	tactician.useAbility();
    	System.out.println("");
    	
    	
    }
}
