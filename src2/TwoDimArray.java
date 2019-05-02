import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TwoDimArray extends JPanel {
    private final int START_X = 20;
    private final int START_Y = 40;
    private final int ROWS = 6;
    private final int COLS = 6;
    private final int BOX_WIDTH = 20;
    private final int BOX_HEIGHT = 20; 
    private MaskableBox boxes[][];
    private static Color boxColors[][]; 
    private Button resetButton;
    private JPanel panel1;
    private JPanel panel2;
    private Color picked_color;
    
    public static void main(String[] args) {
    // 	    TwoDimArray frame  = new TwoDimArray();
    // 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // 		frame.setSize(500,300);
    // 		frame.setVisible(true);
    // 		frame.setLayout(new BorderLayout());
	
	boxColors = new Color[200][200];
     }

    Color[][] getPattern() { return boxColors;}
    

}
