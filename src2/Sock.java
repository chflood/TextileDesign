import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;


class Sock {

    static JFrame frame = new JFrame("Textile Design Program");
    static FootPanel footPanel = new FootPanel();
    //    static ColorPanel colorPanel = new ColorPanel();
    //    static PatternPanel  patternPanel = new PatternPanel();
    static SockPanel sockPanel = new SockPanel();
    static KnittingPanel knittingPanel = new KnittingPanel();
    static ColorChooserPanel colorPanel = new ColorChooserPanel();
    static TwoDimArray patternPanel = new TwoDimArray();
    static Sock sock = new Sock();
    static Color pattern[][];

    public static Sock getSock() { return sock;}
    public static Color[][] getPattern() { return pattern;}
    //    public static void repaint() {frame.repaint();}


    public Sock() {


	frame.setPreferredSize(new Dimension(1000,1000));

	frame.setBounds(0,0,1500,1500);
	frame.setBackground(Color.gray);
	frame.setLayout(new GridLayout(0,2));

	frame.add(footPanel);
	frame.add(sockPanel);
	//	frame.add(colorPanel);
	//	frame.add(patternPanel);
	//	frame.add(fred);
	//	frame.add(barney);	
	frame.add(sockPanel);
	frame.add(knittingPanel);
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	pattern = new Color[100][100];
	for (int i = 0; i < 100; i++)
	    for (int j = 0; j < 100; j++)
		pattern[i][j] = new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256));
	
    }

    public int getSockLength() {
	return (int) footPanel.getSockLength();
    }

    public int getSockWidth() {
	return (int) footPanel.getSockWidth();
    }

    public int getSockHeight() {
	return (int) footPanel.getSockHeight();
    }
    
    public Color[][] getSockPattern() {
	//	return patternPanel.getPattern();
	return sock.getPattern();
    }

    public static void main(String args[]) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	sock = new Sock();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // set the jframe size and location, and make it visible
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Sock s = new Sock();
		frame.repaint();
	    }
	    });
    }
}
