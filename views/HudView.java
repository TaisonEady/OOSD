package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class HudView {
	
	public JPanel hud;
	public JLabel instruction;
	public JLabel diceAmount;
	public JButton actionButton;
	public ImageIcon diceIcon;
	public ImageIcon endTurnIcon;
	public JLabel currentPlayer;
	public Boolean isExplorer;

	public HudView() {
		// TODO Auto-generated constructor stub
		
		hud = new JPanel();
		Color bluegrey = new Color(179, 204, 204);
		hud.setBackground(bluegrey);
		hud.setPreferredSize(new Dimension(800, 50));
		
		isExplorer = true;
		
		instruction = new JLabel("Please roll dice");
		instruction.setFont (instruction.getFont ().deriveFont (18.0f));
		diceAmount = new JLabel("0");
		currentPlayer = new JLabel("EXPLORER");
		currentPlayer.setForeground(Color.blue);
		actionButton = new JButton("Roll dice");
		actionButton.setPreferredSize(new Dimension(140, 40));
		
		
		diceIcon = new ImageIcon("bin/images/dice.png");
		endTurnIcon = new ImageIcon("bin/images/endTurn.png");
		
	    actionButton.setIcon(diceIcon);
	    
	    actionButton.setFocusPainted(false);
	    
	    
		
		//Layout elements across HUD bar
	    hud.add(Box.createVerticalStrut(40));
		hud.add(instruction);
		hud.add(Box.createHorizontalStrut(60));
		hud.add(actionButton);
		hud.add(Box.createHorizontalStrut(20));
		hud.add(diceAmount);
		hud.add(Box.createHorizontalStrut(60));
		hud.add(currentPlayer);
	}
	
	//Functions to handle changes to the HUD based on state changes
	
	public void swapPlayer(){
		if (isExplorer){
			currentPlayer.setText("GUARDIANS");
			currentPlayer.setForeground(Color.red);
			isExplorer = false;
		}
		else {
			currentPlayer.setText("EXPLORERS");
			currentPlayer.setForeground(Color.blue);
			isExplorer = true;
		}
	}
	
	public void setDiceRoll(int diceNum){
		diceAmount.setText(String.valueOf(diceNum));
	}
	
	public void setDiceState(){
		instruction.setText("Please roll dice");
		actionButton.setText("Roll dice");
		actionButton.setIcon(diceIcon);
	}
	
	public void setUnitState(){
		instruction.setText("Please select unit");
		actionButton.setText("End turn");
		actionButton.setIcon(endTurnIcon);
		
		
		
	}
	
	public void setMoveState(){
		instruction.setText("Please choose movement position");
	}
	
	public void setAttackState(){
		instruction.setText("Would you like to attack?");
	}
	
	public void setWinState(){
		instruction.setText(currentPlayer + " win!");
	}
	
	

}
