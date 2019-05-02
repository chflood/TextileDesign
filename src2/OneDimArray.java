import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
     
@SuppressWarnings("serial")
public class OneDimArray extends JFrame{
    private final int START_X = 25;
    private final int START_Y = 70;
    private final int BOX_WIDTH = 60;
    private final int BOX_HEIGHT = 20;
    private ClickableBox[] boxes = new ClickableBox[6];
    private Color[] boxColors = { Color.blue, Color.red, Color.green, Color.cyan,
              Color.magenta, Color.yellow };     
    private Button resetColors;
    private JPanel panel1;
    private Color picked_color;
	
    
    public static void main(String[] args) {
	    OneDimArray frame  = new OneDimArray();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(1000,500);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
    }
	
    public OneDimArray(){	
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new ClickableBox(START_X, START_Y + i * BOX_HEIGHT, BOX_WIDTH,
                    BOX_HEIGHT, Color.black, Color.red, true, this);
            this.addMouseListener(boxes[i]);
        }
        defaultBoxColors();
        panel1 = new JPanel();
        this.add(panel1,BorderLayout.CENTER);
        resetColors = new Button("Reset Colors");
        resetColors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                defaultBoxColors();
                repaint();  
            }
         });
         this.add(resetColors,BorderLayout.SOUTH);
       
    }

    public void paint(Graphics g) {
        for(int i = 0; i < boxes.length; i++) {
            if(boxes[i].isClicked()) {
            	picked_color = JColorChooser.showDialog(panel1, "Pick Color", picked_color);
                boxes[i].setBackColor(picked_color);
                		//new Color(
                   // (int)(Math.random() * 256), 
                   // (int)(Math.random() * 256), 
                   // (int)(Math.random() * 256)));
                boxes[i].setClicked(false);
            }
            boxes[i].draw(g);
        }
    }
    
    public void defaultBoxColors() {
        for(int i = 0; i < boxes.length; i++) {
            boxes[i].setBackColor(boxColors[i]);
        }
    }
}