import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class Hat {
  RandomPatternGenerator RPG;
  PatternGenerator PG;
  Color[][] pattern;
  Graphics g;
  DrawingPanel panel;
  int x;
  int y;
  int width;
  int height;

  Hat(Graphics g, Color[][] pattern, DrawingPanel panel, int x, int y, int width, int height) {
    this.pattern = pattern;
    this.g = g;
    this.panel = panel;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }


    static void drawCylinder(Graphics g) {
      g.setColor(Color.RED);
	g.drawOval(50,160,100,50);     // upper ellipse
	g.drawLine(50,160,250, 200);   // left vertical line
	g.drawLine(150,240,150,200);   // right horizontal line
	g.drawOval(50,280,100,50);    // lower ellipse
    }

    static void drawKnitRow(Graphics g, int startx, int starty, int stitchCount) {
	for (int i = 0; i < stitchCount; i++) {
	    if (i % 2 == 0)
		g.setColor(Color.CYAN);
	    else
		g.setColor(Color.RED);

	    //	    g.fillRect(i*5,y, 7,5);
	}
    }

    static void drawSock(Graphics g) {
	//	Draw a cylinder for the calf
	drawCylinder(g);

	//      Draw the pattern
	for (int i = 0; i < 100; i=i+10) {
	    drawKnitRow(g, 300, i, 30);
	}
    }

    static void updateHat(Graphics g, Color[][] pattern, int x, int y, int width, int height) {
      int ovalX = x+width/2;
      int ovalY = y+height/6*4;
      for(int i = x;i<width*2;i++){
        for(int j = y;j<(height/3*2)+x;j++){
          if((int)Math.sqrt(Math.pow(i-ovalX, 2) + Math.pow(j-ovalY, 2))<width/2-1) {
          g.setColor(pattern[i%pattern.length][j%pattern[0].length]);
          g.drawRect(i, j, 1, 1);

        }
        }
      }
      g.setColor(Color.RED);
      g.drawArc(x,y+(height/6), width, height, 180, -180);
      g.setColor(Color.BLUE);
      g.drawRect(x, y+((height/6)*4), width, height/6);
    }

    static void generateHat(Graphics g, int x, int y, int width, int height) {
      g.setColor(Color.RED);
      g.drawArc(x,y+(height/6), width, height, 180, -180);
      g.drawRect(x+width/2, y+height/6*4, 1, 1);
      //g.drawArc(x+width/2, y+(height/3)*2, width/2, height/3, 90, -180);
      g.setColor(Color.BLUE);
      g.drawOval(x+(width/12*5), y, (width/6), (height/6));
      g.drawRect(x, y+((height/6)*4), width, height/6);

    }


  public static void main(String[] args) {
	   //DrawingPanel panel = new DrawingPanel(500,500);
     DrawingPanel panel = new DrawingPanel(200, 250);
     DrawingPanel panel2 = new DrawingPanel(200, 250);
  	 Graphics g = panel.getGraphics();
     Graphics g2 = panel2.getGraphics();
	   //drawSock();
     Color[][] pattern = new Color[10][10];
     //RandomPatternGenerator RPG = new RandomPatternGenerator();
     //PatternGenerator PG = new PatternGenerator(g2, pattern, panel2);
     /*
     g.setColor(Color.RED);
     g.drawArc(50 ,100, 100, 100, 180, 90);
     g.drawRect(50, 50, 50, 20);
     g.setColor(Color.BLUE);
     g.drawRect(50, 70, 50, 80);
     g.drawRect(100, 150, 25, 50);
     g.setColor(Color.RED);
     g.drawArc(100 ,150, 50, 50, 90, -180);
*/

     //drawCylinder(g);
   	 //PG.generateRedAndWhiteColor(pattern);

     //HitTestMouseListener Fred2 = new HitTestMouseListener(g2, pattern);

     //panel2.addMouseListener(Fred2);
     //PG.displayPattern(g2, pattern);
     //pattern = PG.update();

     //pattern = PatternGenerator.pattern



     //if (Fred.c==true) {

     //}

  }







}
