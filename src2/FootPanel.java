import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

class FootPanel extends JPanel {
    String lengthString;
    String circumferenceString;
    
    float length = 0;
    float circumference = 0;
    
    float getLength() { return length;}
    float getCircumference() { return circumference;}

    FootPanel() {
	JLabel labelFootCircumference = new JLabel("Enter Foot Circumference: ");
	JLabel labelFootLength = new JLabel("Enter Foot Length: ");    
	JTextField textCircumference = new JTextField(20);
	JTextField textLength = new JTextField(20);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

	System.out.println("Called FootPanel Paint Component");
	
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
	//        constraints.gridx = 0;
	//        constraints.gridy = 2;
	//        constraints.gridwidth = 2;
	//        constraints.anchor = GridBagConstraints.CENTER;

	JButton b1 = new JButton("Redraw Foot");
	//	b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String my_length = textLength.getText();
		    length = Float.parseFloat(my_length);
		    lengthString = my_length;
		    String my_width  = textCircumference.getText();
		    circumference = Float.parseFloat(my_width);
		    circumferenceString = my_width;
		    
		    System.out.println("length = " + length + " width = " + circumference);
		    //   Sock.getSock().repaint();
		}
	    });
	add(b1);
    }

    public void paintComponent(Graphics g) {
	
    }
}
	
	
