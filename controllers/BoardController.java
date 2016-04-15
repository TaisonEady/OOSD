/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.*;
import models.Explorer.Hero;
import models.Explorer.Scout;
import models.Explorer.Tactician;
import models.Explorer.TrapMaster;
import models.Guardians.Behemoth;
import models.Guardians.Golem;
import models.Guardians.Hunter;
import models.Item.ExplorerStartPoint;
import models.Item.Gate;
import models.Item.Ground;
import models.Item.GuardianStartPoint;
import views.BoardView;
import views.BoardView.Cell;
import views.HudView;



public class BoardController {
    
    private static final int ROWS = 12;
    private static final int COLUMNS = 12;
    
    private GameController gameController;
    
    private Board board;
    private BoardView boardView;
    private HudView hudView;
    
    private BoardActionListener boardListener;
    private HUDActionListener hudListener;
    
    private boolean boardInitialised = false;
    private boolean initExplorer = false;
    private boolean initGuardian = false;

    public BoardController(GameController gameController) {
        
        this.gameController = gameController;
        boardListener = new BoardActionListener();
        hudListener = new HUDActionListener();
        
    }
    
    public void showBoard(JFrame mainWindow){
        //TODO check that board is init
        
        //create a new content panel holding both the grid and the hud
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(boardView, BorderLayout.CENTER);
        contentPanel.add(hudView, BorderLayout.SOUTH);
        mainWindow.getContentPane().add(contentPanel);
        mainWindow.pack();
        contentPanel.setVisible(true);
    }
  
    public void initBoard() {
        board = new Board();
        
        boardView = new BoardView(boardListener, ROWS, COLUMNS);
        hudView = new HudView(new HUDActionListener());
        
        for (int y = 0; y < COLUMNS; y++) {
            for (int x = 0; x < ROWS; x++) {
                BoardItem cell;
                if ((x == 0 && y == COLUMNS - 1) || (x == COLUMNS - 1 && y == 0)) { // set Guardian start point
                    cell = new GuardianStartPoint(x, y);
                } else if ((x == ROWS - 1 && y == COLUMNS - 1) || (x == ROWS - 1 && y == COLUMNS - 2)
                        || (x == ROWS - 2 && y == COLUMNS - 1) || (x == ROWS - 2 && y == COLUMNS - 2)) { // set Explorer start point

                    cell = new ExplorerStartPoint(x, y);
                } else if ((x == 0 && y == 0) || (x == 0 && y == 1) || (x == 1 && y == 0)) { // set the gate color
                    cell = new Gate(x, y);
                } else {
                    cell = new Ground(x, y);
                }

                boardView.initCells(boardListener, cell);
            }
        }
    }
    
    public void initExplorerUnit(Player player) {
        if (initExplorer) {
            JOptionPane.showMessageDialog(null, "Explorer already initialize");
        } else {
            // initExplorerUnit
            Hero hero = new Hero(11, 11);
            Scout scout = new Scout(10, 10);
            Tactician tactician = new Tactician(10, 11);
            TrapMaster trapMaster = new TrapMaster(11, 10);

            try {
                player.addUnit("hero", hero);
                boardView.initCells(boardListener, hero);
                player.addUnit("scout", scout);
                boardView.initCells(boardListener, scout);
                player.addUnit("tactician", tactician);
                boardView.initCells(boardListener, tactician);
                player.addUnit("trapMaster", trapMaster);
                boardView.initCells(boardListener, trapMaster);
                initExplorer = true;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public void initGuardianUnit(Player player) {
        if (initGuardian) {
            JOptionPane.showMessageDialog(null, "Guardian already initialize");
        } else {
            // initGuardianUnit
            Behemoth behemoth = new Behemoth(0, 0);
            Golem golem = new Golem(11, 0);
            Hunter hunter = new Hunter(0, 11);

            try {
                player.addUnit("behemoth", behemoth);
                boardView.initCells(boardListener, behemoth);
                player.addUnit("golem", golem);
                boardView.initCells(boardListener, golem);
                player.addUnit("hunter", hunter);
                boardView.initCells(boardListener, hunter);
                initGuardian = true;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public Unit getUnit(int x, int y)
    {
		return boardView.getUnit(x, y);
   	 
    }

    void drawMovable(int[][] movePositions) {
        boardView.drawMovable(movePositions);
    }
    void clearMovable(int[][] movePositions){
    	boardView.updateBoard(movePositions);
    }

    void updateBoard(int[][] movePositions) {
        boardView.updateBoard(movePositions);
    }
    void drawPos(Unit unit)
    {
    	boardView.darwPos(unit);
    }

    void setDiceRoll(int diceAmount) {
        hudView.setDiceRoll(diceAmount);
    }

    void setUnitState() {
        hudView.setUnitState();
    }

    void setDiceState() {
        hudView.setDiceState();
    }

    void swapPlayer() {
        hudView.swapPlayer();
    }

    void setWinState(String team) {
        hudView.setWinState(team);
    }

    
    class BoardActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Unit unit = ((Cell) e.getSource()).getUnit();

            gameController.cellClicked(unit);

        }

    }
    

    class HUDActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           gameController.hudButtonClicked();
        }
    }
}
   
