import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class ColorPanel extends JPanel {
    private int numColors = 100;
    ClickableBox[] boxes   = new ClickableBox[numColors];
    Color[] boxColors = new Color[numColors];

    public void initializeColors() {
	for (int i = 0; i < numColors; i++) {
	    boxColors[i] = new Color((int)(Math.random() * 256), (int)(Math.random()*256),(int)(Math.random() * 256));
	    boxes[i] = new ClickableBox((i/10)*10, (i%10)*10, 10, 10, Color.black, boxColors[i], true, this);
	}
    }

    public void resetColors() {
	for (int i = 0; i < numColors; i++) {
	    boxes[i] = new ClickableBox(i/10, i%10, 10, 10, Color.black, boxColors[i], true, this);
	}
    }
	
    public void paintComponent(Graphics g) {
	for (int i = 0; i < boxes.length; i++)
	    boxes[i].draw(g);
    }

    ColorPanel() {
	initializeColors();
	//	JPanel panel = new JPanel();
	//	add(panel,BorderLayout.CENTER);
        Button resetColors = new Button("Reset Colors");
        resetColors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                resetColors();
                repaint();  
            }
         });
        add(resetColors,BorderLayout.SOUTH);
       
    }
}

