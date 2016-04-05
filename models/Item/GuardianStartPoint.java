package models.Item;

import javax.swing.*;

import models.BoardItem;

public class GuardianStartPoint extends BoardItem{
	
	public GuardianStartPoint(int x, int y){
		super(x, y);
		icon = new ImageIcon("bin/images/guardianStartPoint.png");
	}
}
