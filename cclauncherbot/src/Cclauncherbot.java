
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;

public class Cclauncherbot
{
    String name, pw;
    Robot robot;
    
   /* public static void main(String[] args) throws AWTException
    {
        new Cclauncherbot();
    }*/
   
    public Cclauncherbot() throws AWTException
    {
        robot = new Robot();
        name = "";
        pw = "";
        
        for (int i = 0; i < 4; i++)
        {
            try
            {
                Process p = Runtime.getRuntime().exec("F:/Downloads/CCLauncher_Client/CCLauncher_Client.exe");
                
                Thread.sleep(5000);
                
                StringSelection stringSelection = new StringSelection(name);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_TAB);
                
                Thread.sleep(1000);
                
                stringSelection = new StringSelection(pw);
                clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
                
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                
                Thread.sleep(3900000); //65 min
                
                p.destroy();
                
                Thread.sleep(10000);
                
            } catch (InterruptedException | IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
