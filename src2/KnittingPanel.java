import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class KnittingPanel extends JPanel {
    KnittingPanel() {
	Button inst =  new Button("Hand Knitting Instructions");
	inst.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    repaint();
		}
	    });
	add(inst, BorderLayout.SOUTH);
    }

    void toe(Graphics g) {
	g.drawString("Cast on", 0,10);
	g.drawString("Knit the Toe", 0, 20);
    }

    void forefoot(Graphics g) {
	g.drawString("Knit the Forefoot", 0, 30);
    }

    void heel(Graphics g) {
	g.drawString("Knit the heel", 0, 40);
    }

    void calf(Graphics g) {
	g.drawString("Knit the calf", 0, 50);
	g.drawString("bindoff", 0, 60);
    }

    public void paintComponent(Graphics g) {
	g.drawString("Knitting Instructions", 0,0);
	toe(g);
	forefoot(g);
	heel(g);
	calf(g);
    }
}
