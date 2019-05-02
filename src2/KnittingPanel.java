import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class KnittingPanel extends JPanel {

    int start = 0;
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
	g.drawString("Cast on 32 stitches", 0,start +=10);
	g.drawString("Increase every other row to 64 stitches", 0, start+=10);
    }

    void forefoot(Graphics g) {
	g.drawString("Knit for 9 inches following pattern", 0, start+=10);
    }

    void heel(Graphics g) {
	g.drawString("Short row half the stitches for the heel", 0, start+=10);
    }

    void calf(Graphics g) {
	g.drawString("Knit the calf for 9 inches", 0, start+=10);
	g.drawString("bindoff", 0, start+=10);
    }

    public void paintComponent(Graphics g) {
	g.drawString("Knitting Instructions:", 0,start += 10);
	toe(g);
	forefoot(g);
	heel(g);
	calf(g);
    }
}
