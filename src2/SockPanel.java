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
      int convertedCircumference = (int)(((double)(w/2))*mapNum((double)circumference, 12.0, 120.0, 0.1, 1.0));
      int convertedLength = (int)(((double)(w/4))*mapNum((double)length, 12.0, 120.0, 0.1, 1.0));

      System.out.println("w = " + w + " h = " + h + " convertedCircumference = " + convertedCircumference + " converted length " + convertedLength + " length = " + length + " circ = " + circumference);

       for(int i = x;i<x+convertedCircumference;i+=10){
	   for(int j = y+(h/6);j<(y+h/6*4);j+=10){
	       g.setColor(pattern[(i/10)%pattern.length][(j/10)%pattern[0].length]);
         for(int k = 0;k<10;k++){
           for(int l = 0;l<10;l++){
             if(i+k<x+convertedCircumference){
               if(j+l<(y+h/6*4)) {
                 g.fillRect((i+k), (j+l), 1, 1);
               }
             }
           }
         }


	   }
       }
       for(int i = x+convertedCircumference;i<(x+convertedCircumference+convertedLength);i+=10){
	   for(int j = y+((h/3)*2);j<y+h-2;j+=10){
	       g.setColor(pattern[(i/10)%pattern.length][(j/10)%pattern[0].length]);
         for(int k = 0;k<10;k++){
           for(int l = 0;l<10;l++){
             if(i+k<(x+convertedCircumference+convertedLength)){
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
     int convertedCircumference = (int)(((double)(w/2))*mapNum((double)circumference, 12.0, 120.0, 0.1, 1.0));
     int convertedLength = (int)(((double)(w/4))*mapNum((double)length, 12.0, 120.0, 0.1, 1.0));

     g.setColor(Color.RED);
     g.drawRect(x, y, convertedCircumference, h/6);
     g.drawArc(x ,y+(h/3), convertedCircumference*2, h/3*2, 180, 90);
     g.drawArc(x+convertedCircumference+(convertedLength)-(w/8), y+(h/3)*2, w/4, h/3, 90, -180);
     g.setColor(Color.BLUE);
     g.drawRect(x, y+(h/6), convertedCircumference, (h/2));
     g.drawRect(x+convertedCircumference, y+((h/3)*2), convertedLength, h/3);

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
	if (sock.getSockLength() > 0)
	    l = sock.getSockLength();
	else l = 10;
	if (sock.getSockWidth() > 0)
	    w = sock.getSockWidth();
	else w = 10;
	if (sock.getSockPattern() != null)
	    pattern = sock.getSockPattern();
	else {
	    pattern = new Color[l][w];
	    for (int i = 0; i < l; i++) {
		for (int j = 0; j < w; j++) {
		    pattern[i][j] = Color.black;
		    if ((i %2) == 0)
			pattern[i][j] = Color.white;
		    else pattern[i][j] = Color.red;
		}
	    }
	}

  //g.setBackground(255);

	updateSock(g, sock.getSockPattern(), 0, 50, sock.getSockLength(), sock.getSockWidth());
	generateSock(g, 0, 50, sock.getSockLength(), sock.getSockWidth());
    }
}
