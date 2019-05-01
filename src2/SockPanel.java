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
                //removeAll();
                repaint();
            }
         });
	add(updateSock, BorderLayout.SOUTH);
    }

    public void updateSock(Graphics g, Color[][] pattern, int x, int y, int length, int circumference) {
      int w = this.getWidth()-x;
      int h = this.getHeight()-y;
      int convertedLength = (int)(((double)(w/2))*mapNum((double)circumference, 12.0, 120.0, 0.1, 1.0));

       for(int i = x;i<x+convertedLength;i+=10){
	   for(int j = y+(h/6);j<(y+h/6*4);j+=10){
	       g.setColor(pattern[(i/10)%pattern.length][(j/10)%pattern[0].length]);
         for(int k = 0;k<10;k++){
           for(int l = 0;l<10;l++){
             if(i+k<x+convertedLength){
               if(j+l<(y+h/6*4)) {
                 g.fillRect((i+k), (j+l), 1, 1);
               }
             }
           }
         }


	   }
       }
       for(int i = x+convertedLength;i<x+w/4*3;i+=10){
	   for(int j = y+((h/3)*2);j<y+h-2;j+=10){
	       g.setColor(pattern[(i/10)%pattern.length][(j/10)%pattern[0].length]);
         for(int k = 0;k<10;k++){
           for(int l = 0;l<10;l++){
             if(i+k<x+w/4*3){
               if(j+l<(y+h)) {
                 g.fillRect((i+k), (j+l), 1, 1);
               }
             }
           }
         }
	   }
       }
   }

   public void generateSock(Graphics g, int x, int y, int length, int circumference) {
     int w = this.getWidth()-x;
     int h = this.getHeight()-y;
     int convertedLength = (int)(((double)(w/2))*mapNum((double)circumference, 12.0, 120.0, 0.1, 1.0));


     g.setColor(Color.RED);
     g.drawRect(x, y, convertedLength, h/6);
     g.drawArc(x ,y+(h/3), convertedLength*2, h/3*2, 180, 90);
     g.drawArc(x+convertedLength, y+(h/3)*2, w/2, h/3, 90, -180);
     g.setColor(Color.BLUE);
     g.drawRect(x, y+(h/6), convertedLength, (h/2));
     g.drawRect(x+(w/2), y+((h/3)*2), (w/4), h/3);

   }

   public double mapNum(double input, double input_start, double input_end, double output_start, double output_end) {
   double input_range = input_end - input_start;
   double output_range = output_end - output_start;
    double output = 0;
    output = ((input - input_start)*output_range) / input_range + output_start;
    return output;
}
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
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

  //g.setBackground(255);
  generateSock(g, 0, 50, sock.getLength(), sock.getCircumference());
	updateSock(g, sock.getPattern(), 0, 50, sock.getLength(), sock.getCircumference());

    }
}
