import java.awt.*;


public class RandomPatternGenerator {

    public static void generateColor(Color[][] pattern) {
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

    public static void displayPattern(Graphics g, Color[][] pattern) {

	for (int i = 0; i < pattern.length; i++) {
	    for (int j = 0; j < pattern[i].length; j++) {
		g.setColor(pattern[i][j]);
		g.fillRect(i*10, j*10, 10, 10);
	    }
	}
    }

    public static void main(String[] args) {
	DrawingPanel panel = new DrawingPanel(500,500);
	Graphics g = panel.getGraphics();
	Color[][] pattern = new Color[10][10];
	generateColor(pattern);
	displayPattern(g,pattern);
    }
}
