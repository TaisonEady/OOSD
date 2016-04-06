
package views;

import java.awt.Color;
import static java.awt.Color.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.*;

public class CellView extends JButton{
    
    int xPos;
    int yPos;
    
    public CellView(int xPos, int yPos, ActionListener listener){
        
        this.xPos = xPos;
        this.yPos = yPos;
        
        this.setBorder(new LineBorder(BLACK, 12));
        this.setBounds(xPos, yPos, 15, 15);
        this.setBackground(GRAY);
        this.addActionListener(listener);
    }
}
