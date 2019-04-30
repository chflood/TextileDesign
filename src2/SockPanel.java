import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

class SockPanel extends JPanel {

    SockPanel() {
	Button updateSock = new Button("Display Sock");
        updateSock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                repaint();
            }
         });
	add(updateSock, BorderLayout.SOUTH);
    }

    static void updateSock(Graphics g, Color[][] pattern, int x, int y, int width, int height) {
	g.drawString("FEH", 100,100);
       for(int i = x+1;i<x+width/2-1;i++){
	   for(int j = y+(height/6)+1;j<(y+height/3*2)-1;j++){
	       g.setColor(pattern[i%pattern.length][j%pattern[0].length]);
	       g.fillRect((i % 10)*10, j*10, 10, 10);

	   }
       }
       for(int i = x+width/2+1;i<x+width/4*3-1;i++){
	   for(int j = y+((height/3)*2)+1;j<y+height-2;j++){
	       g.setColor(pattern[i%pattern.length][j%pattern[0].length]);
	       g.fillRect((i%10) * 10, j*10, 10, 10);
	   }
       }
   }

    public void paintComponent(Graphics g) {
	Sock sock = Sock.getSock();
	int l; int w;
	Color[][] pattern;
	if (sock.getLength() > 0)
	    l = sock.getLength();
	else l = 10;
	if (sock.getCircumference() > 0)
	    w = sock.getCircumference();
	else w = 10;
	if (sock.getPattern() != null)
	    pattern = sock.getPattern();
	else {
	    pattern = new Color[l][w];
	    for (int i = 0; i < w; i++) {
		for (int j = 0; j < l; j++) {
		    pattern[i][j] = Color.black;
		    if ((i %2) == 0)
			pattern[i][j] = Color.white;
		    else pattern[i][j] = Color.red;
		}
	    }
	}

	updateSock(g, sock.getPattern(), 0, 0, sock.getLength(), sock.getCircumference());
    }
}
