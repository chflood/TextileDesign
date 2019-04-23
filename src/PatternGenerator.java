import java.awt.*;
import java.awt.event.*;


class HitTestMouseListener extends MouseAdapter {
    Color[][] pattern;
    Graphics g;
    Graphics g2;
    Graphics g3;
    Sock Sock;
    Hat Hat;
    Color currColor;
    Color[] colorChoices;

    HitTestMouseListener(Graphics g, Graphics g2, Graphics g3, Color[][] pattern, Sock Sock, Hat Hat, Color currColor, Color[] colorChoices) {
  this.pattern = pattern;
  this.g = g;
  this.g2 = g2;
  this.g3 = g3;
  this.Sock = Sock;
  this.Hat = Hat;
  this.currColor = currColor;
  this.colorChoices = colorChoices;
    }

    public void mouseClicked(MouseEvent e) {
  int x = e.getX() / 10;
  int y = e.getY() / 10;
  if (y>pattern[0].length-1) {
  this.currColor = colorChoices[x];
  //this.currColor = JColorChooser.createDialog(g2, "Color Picker",true, )
  }
  else {
  pattern[x][y] = this.currColor;
  }
  PatternGenerator.displayPattern(g2, pattern);
  Sock.updateSock(g, pattern, this.Sock.x, this.Sock.y, this.Sock.width, this.Sock.height);
  Hat.updateHat(g3, pattern, this.Hat.x, this.Hat.y, this.Hat.width, this.Hat.height);
    }
}

public class PatternGenerator {
  Color[][] pattern;
  Graphics g;
  DrawingPanel panel;
  Color[] colorChoices;


  PatternGenerator(Graphics g, Color[][] pattern, DrawingPanel panel, Color[] colorChoices) {
    this.pattern = pattern;
    this.g = g;
    this.panel = panel;
    this.colorChoices = colorChoices;

    //for (int i = 0; i < pattern.length; i++) {
  	//    for (int j = 0; j < pattern[i].length; j++) {
  	//	g.setColor(Color.black);
  	//	g.drawRect(i*10, j*10, 10, 10);
  	 //   }
  	//}

  }

    public static void generateRandomColor(Color[][] pattern) {
	for (int i = 0; i < pattern.length; i++) {
	    for (int j = 0; j < pattern[i].length; j++) {
		int k = (int) (Math.random() * 10);
		switch (k) {
		case 0: pattern[i][j] = Color.black; break;
		case 1: pattern[i][j] = Color.red; break;
		case 2: pattern[i][j] = Color.blue; break;
		case 3: pattern[i][j] = Color.gray; break;
		case 4: pattern[i][j] = Color.yellow; break;
		case 5: pattern[i][j] = Color.green; break;
		case 6: pattern[i][j] = Color.magenta; break;
		case 7: pattern[i][j] = Color.orange; break;
		case 8: pattern[i][j] = Color.white; break;
		case 9: pattern[i][j] = Color.cyan; break;
		}
	    }
	}
    }

    public static void generateRedAndWhiteColor(Color[][] pattern) {
	for (int i = 0; i < pattern.length; i++) {
	    for (int j = 0; j < pattern[i].length; j++) {
		if ((i*j % 2) == 0)
		    pattern[i][j] = Color.white;
		else
		    pattern[i][j] = Color.red;
	    }
	}
    }

    public static void generateWhiteColor(Color[][] pattern) {
	for (int i = 0; i < pattern.length; i++) {
	    for (int j = 0; j < pattern[i].length; j++) {
		pattern[i][j] = Color.white;
	    }
	}
    }

    public static void displayPattern(Graphics g, Color[][] pattern) {

	for (int i = 0; i < pattern.length; i++) {
	    for (int j = 0; j < pattern[i].length; j++) {
		g.setColor(pattern[i][j]);
		g.fillRect(i*10, j*10, 10, 10);
    g.setColor(Color.black);
    g.drawRect(i*10, j*10, 10, 10);
	    }
	}
    }

    public Color[][] update(Color[][] pattern1) {
      Color[][] pattern = new Color[pattern1.length][pattern1[0].length];
    	//HitTestMouseListener Fred = new HitTestMouseListener(this.g,this.g2,this.pattern);
    	//panel.addMouseListener(Fred);

    	//generateRedAndWhiteColor(pattern);

    	displayPattern(g,pattern);
      return pattern;
    }



}
