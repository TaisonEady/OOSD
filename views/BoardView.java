/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163 test
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package views;

import java.awt.*;
import javax.swing.*;

public class BoardView extends JPanel{
	
    public BoardView(int numberOfRows, int numberOfColumns){
        super(new GridLayout(numberOfRows, numberOfColumns, 0, 0));
    }
}

        // Set line borders on the cells panel and the status label
        p.setBorder(new LineBorder(Color.black, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

        // Place the panel and the label to the applet
        add(p, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
