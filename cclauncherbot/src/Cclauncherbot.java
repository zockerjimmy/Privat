
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cclauncherbot
{

    String name, pw;
    Robot robot;
    Process p;

    public Cclauncherbot() throws AWTException
    {
        robot = new Robot();
        name = "";
        pw = "";

        for (int i = 0; i < 4; i++)
        {
            try
            {
                java.util.concurrent.Executors.newSingleThreadExecutor().execute(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            ProcessBuilder pb = new ProcessBuilder("F:/Downloads/CCLauncher_Client/CCLauncher_Client.exe");
                            pb.redirectErrorStream(true);
                            p = pb.start();
                            BufferedReader r = new BufferedReader(new InputStreamReader(
                                    p.getInputStream()));
                            String line;
                            while (true)
                            {
                                line = r.readLine();
                                if (line == null)
                                {
                                    break;
                                }
                                System.out.println(line);
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(Cclauncherbot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
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

            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }  
    }
}
