import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame
{ 
    public static void main(String[] args)
    {
       Main instance = new Main();
              
        try
        {
        Thread.sleep(5000);
        Robot robot = new Robot();
        String fileName = "F://AnwesImg/aimage1.jpg";
        
        //Code
        //Rectangle ScreenRect = new Rectangle(810, 351, 42, 16);
        //Kompletter Bildschirm
        //Rectangle ScreenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        //
        Rectangle ScreenRect = new Rectangle(810, 351, 42, 16);
        BufferedImage screenFullImage = robot.createScreenCapture(ScreenRect);
        ImageIO.write(screenFullImage, "jpg", new File(fileName));
        
         instance.setLocation(500, 500);
         JLabel text = new JLabel("screenshot saved!");
         instance.add(text);
         instance.setSize(200, 100);
         instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         instance.getContentPane().setLayout(new FlowLayout());
         instance.setVisible(true);
        } catch(AWTException | IOException | InterruptedException ex) 
        {
            System.err.println(ex);
        }
    }
}
