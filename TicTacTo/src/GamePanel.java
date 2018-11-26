import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//Inhalt des Hauptfensters
public class GamePanel extends JPanel
{
	private final int P_WIDTH = 300;
	private final int P_HEIGHT = 300;

	public GamePanel()
	{
		InitScene();
	}

	private void InitScene()
	{
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		super.paintComponent(g);
		DrawField(g);
		//DrawCircle(g, 0,0);
		//DrawCross(g, 100,0, 200, 100);
	}

	private void DrawField(Graphics g)
	{
		// drawLine(int x1, int y1, int x2, int y2)
		// is used to draw a straight line from point (x1,y1) to (x2,y2).

		// Vertikal
		g.drawLine(100, 0, 100, 300); // x:100 y:0 - x:100 y:300
		g.drawLine(200, 0, 200, 300); // x:200 y:0 - x:200 y:300
		// Horizontal
		g.drawLine(0, 100, 300, 100); // x:0 y:100 - x:300 y:100
		g.drawLine(0, 200, 300, 200); // x:0 y:200 - x:300 y:200

		/*
		 * 1 = x: 0 - 100 y: 0 - 100 
		 * 2 = x: 100 - 200 y: 0 - 100 
		 * 3 = x: 200 - 300 y: 0 - 100
		 * 
		 * 4 = x: 0 - 100 y: 100 - 200 
		 * 5 = x: 100 - 200 y: 100 - 200 
		 * 6 = x: 200 - 300 y: 100 - 200
		 * 
		 * 7 = x: 0 - 100 y: 200 - 300 
		 * 8 = x: 100 - 200 y: 200 - 300 
		 * 9 = x: 200 - 300 y: 200 - 300
		 */
	}
	
	public void DrawCircle(Graphics g, int x, int y)
	{
		g.fillOval(x, y, 100, 100);
	}
	
	public void DrawCross(Graphics g, int x1, int y1, int x2, int y2)
	{
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y1, x1, y2);
	}


}
