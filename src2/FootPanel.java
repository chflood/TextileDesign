import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

class FootPanel extends JPanel {
    String lengthString;
    String circumferenceString;
    
    int sockLength = 0;
    int sockWidth = 0;
    int sockHeight = 0;
    
    int getSockLength() { return sockLength;}
    int getSockWidth() { return sockWidth;}
    int getSockHeight() { return sockHeight;}

    FootPanel() {
	JLabel labelFootCircumference = new JLabel("Foot Width in inches: ");
	JLabel labelFootLength = new JLabel("Foot Length in inches: ");
	JLabel labelSockHeight = new JLabel("Sock Height in inches:");
	JLabel labelStitchGauge = new JLabel("Enter stitch gauge:");
	JLabel labelRowGauge = new JLabel("Enter row gauge:");	
	
	JTextField textCircumference = new JTextField("6", 20);
	JTextField textLength = new JTextField("8",20);
	JTextField textHeight = new JTextField("8", 20);
	JTextField textStitchGauge = new JTextField("6",20);
	JTextField textRowGauge = new JTextField("8",20);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;     
	add(labelFootCircumference, constraints);
        constraints.gridx = 1;
	textCircumference.setEditable(true);
	add(textCircumference, constraints);

	
        constraints.gridx = 0;
        constraints.gridy = 1;     
	add(labelFootLength, constraints);
        constraints.gridx = 1;
	textLength.setEditable(true);
	add(textLength, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
	add(labelSockHeight, constraints);
        constraints.gridx = 1;
	textLength.setEditable(true);
	add(textHeight, constraints);
	
        constraints.gridx = 0;
        constraints.gridy = 3;     
	add(labelStitchGauge, constraints);
        constraints.gridx = 1;
	textStitchGauge.setEditable(true);
	add(textStitchGauge, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;     
	add(labelRowGauge, constraints);
        constraints.gridx = 1;
	textRowGauge.setEditable(true);
	add(textRowGauge, constraints);


	JButton b1 = new JButton("Redraw Foot");
        b1.setBackground(Color.yellow);
	
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String l = textLength.getText();
		    float length_in_inches  = Float.parseFloat(l);
		    
		    String w  = textCircumference.getText();
		    float width_in_inches = Float.parseFloat(w);

		    String h = textHeight.getText();
		    float height_in_inches = Float.parseFloat(h);

		    String r = textRowGauge.getText();
		    float rows_per_inch = Float.parseFloat(r);

		    String s = textStitchGauge.getText();
		    float stitches_per_inch = Float.parseFloat(s);

		    float stitches = stitches_per_inch * width_in_inches;
		    float rows = rows_per_inch * length_in_inches;
		    float calf_rows = rows_per_inch * height_in_inches;

		    sockLength = (int) rows;
		    sockWidth = (int) stitches;
		    sockHeight = (int) calf_rows;
			
		    System.out.println(" width = " + width_in_inches + "length = " + length_in_inches + " height = " + height_in_inches); 
		    System.out.println("Stich gauge = " + stitches_per_inch + " Row gauge = " + rows_per_inch);
		    System.out.println("Stitches = " + sockWidth + "foot rows = " + sockLength + "calf rows = " + sockHeight);
		    repaint();
		}
	    });
        constraints.gridx = 0;
        constraints.gridy = 7;     
	
	add(b1, constraints);
    }

    public void paintComponent(Graphics g) {
	//	g.setColor(Color.white);
	//	g.fillRect(300,300,500,10);
	//	g.setColor(Color.black);

	//	g.drawString("Stitches = " + sockWidth + "  Foot Rows = " + sockWidth + "  Calf Rows = " + sockHeight, 300, 300);
    }
}
	
	
