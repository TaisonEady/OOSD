package models.Item;

import javax.swing.*;

import models.BoardItem;

public class ExplorerStartPoint extends BoardItem{
	
	public ExplorerStartPoint(int x, int y){
		super(x, y);
		icon = new ImageIcon("src/image/explorerStartPoint.png");
	}
}
