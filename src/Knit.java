import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Knit extends JFrame{
  RandomPatternGenerator RPG;
  PatternGenerator PG;
  Sock Sock;


  public static void main(String[] args) {
	   //DrawingPanel panel = new DrawingPanel(500,500);
     DrawingPanel panel = new DrawingPanel(500, 500);
     DrawingPanel panel2 = new DrawingPanel(200, 250);
     DrawingPanel panel3 = new DrawingPanel(500, 500);
  	 Graphics g = panel.getGraphics();
     Graphics g2 = panel2.getGraphics();
     Graphics g3 = panel3.getGraphics();

	   //drawSock();
     int patternX = 6;
     int patternY = 6;
     Color currColor = Color.BLACK;
     Color[][] pattern = new Color[patternX][patternY];

     RandomPatternGenerator RPG = new RandomPatternGenerator();
     Sock Sock = new Sock(g, pattern, panel, 100, 100, 200, 250);
     Sock.generateSock(g, Sock.x, Sock.y, Sock.width, Sock.height);
     Hat Hat = new Hat(g3, pattern, panel3, 100, 100, 250, 250);
     Hat.generateHat(g3, Hat.x, Hat.y, Hat.width, Hat.height);

     Color[] colorChoices = new Color[10];
     colorChoices[0] = Color.BLACK;
     colorChoices[1] = Color.GRAY;
     colorChoices[2] = Color.LIGHT_GRAY;
     colorChoices[3] = Color.red;
     colorChoices[4] = Color.green;
     colorChoices[5] = Color.blue;
     colorChoices[6] = Color.yellow;
     colorChoices[7] = Color.cyan;
     colorChoices[8] = Color.magenta;
     colorChoices[9] = Color.white;
      for (int i = 0; i<10; i++) {
        g2.setColor(colorChoices[i]);
        g2.fillRect(i*10, patternY*10, 10, 10);
        g2.setColor(Color.black);
        g2.drawRect(i*10, patternY*10, 10, 10);
      }
      PatternGenerator PG = new PatternGenerator(g2, pattern, panel2, colorChoices);



   	 PG.generateWhiteColor(pattern);

     HitTestMouseListener Fred2 = new HitTestMouseListener(g, g2, g3, pattern, Sock, Hat, Color.black, colorChoices);

     panel2.addMouseListener(Fred2);
     //panel2.addMouseListener(Fred2);
     PG.displayPattern(g2, pattern);
     pattern = PG.update(pattern);

  }







}
