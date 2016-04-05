package models.Item;

import javax.swing.*;

import models.BoardItem;

public class Ground extends BoardItem{
	
	public Ground(int x, int y){
		super(x, y);
		icon = new ImageIcon("bin/images/ground.png");
	}
}
