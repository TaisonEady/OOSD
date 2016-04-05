package models.Item;

import javax.swing.*;

import models.BoardItem;

public class Gate extends BoardItem{
	
	public Gate(int x, int y){
		super(x, y);
		icon = new ImageIcon("src/images/gate.png");
	}
}
