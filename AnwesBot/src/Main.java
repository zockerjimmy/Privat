import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame
{     
    BufferedImage[] digits = new BufferedImage[4];
    BufferedImage[] checkDigits = new BufferedImage[10];
    BufferedImage[] buttons = new BufferedImage[10];
    BufferedImage[] tempButtons = new BufferedImage[10];
    BufferedImage[] checkButtons = new BufferedImage[10];
    BufferedImage textWindowCheck, tempTextWindowCheck;
    BufferedImage sendButton, tempSendButton;
    
    Rectangle rectDigit1,rectDigit2, rectDigit3, rectDigit4;
    Rectangle[] rectButtons = new Rectangle[10];
    Rectangle windowCheckRect;
    Rectangle sendBttnRect;
    
    int[] bttnX  = new int[10];
    int[] bttnY  = new int[10];
    int[] code = new int[4];
    int tries = 0;
    Robot robot;
    String fileName;
    
    JFrame window;
    JLabel text;
    
    public Main()
    {
        if(window == null)
        {
         window = new JFrame();
         window.setLocation(500, 500);
         text = new JLabel("Tries: " + tries);
         window.add(text);
         window.setSize(200, 100);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setFocusable(true);
         window.setVisible(true);        
        } 
        do
        { 
           execute();
           tries++;
           text.setText("Tries: " + tries);
           try
           {
             Thread.sleep(300000);  
           }
           catch(InterruptedException ex)
           {
               System.out.println(ex);
           }            
        }while(window != null);
    }
  
    public static void main(String[] args)
    {   
       Main instance = new Main();           
    }     
    
    public void setRectangles()
    {
        sendBttnRect = new Rectangle(1054, 613, 75, 24);
        
        rectButtons[0] = new Rectangle(917, 417, 23, 23);
        rectButtons[1] = new Rectangle(944, 417, 23, 23);
        rectButtons[2] = new Rectangle(971, 417, 23, 23);       
        rectButtons[3] = new Rectangle(917, 446, 23, 23);
        rectButtons[4] = new Rectangle(944, 446, 23, 23);
        rectButtons[5] = new Rectangle(971, 446, 23, 23);       
        rectButtons[6] = new Rectangle(917, 475, 23, 23);
        rectButtons[7] = new Rectangle(944, 475, 23, 23);
        rectButtons[8] = new Rectangle(971, 475, 23, 23);        
        rectButtons[9] = new Rectangle(917, 504, 23, 23);               

        rectDigit1 = new Rectangle(810, 351, 9, 14);
        rectDigit2 = new Rectangle(820, 351, 9, 14);
        rectDigit3 = new Rectangle(830, 351, 9, 14);
        rectDigit4 = new Rectangle(841, 351, 9, 14);

        windowCheckRect = new Rectangle(810, 235, 119, 8);
        
    }
    
    public void doScreenshots()
    {
        try
        {    
        textWindowCheck = robot.createScreenCapture(windowCheckRect);
        ImageIO.write(textWindowCheck, "jpg", new File(fileName + "x.jpg"));           
            
        tempButtons[0] = robot.createScreenCapture(rectButtons[0]);
        ImageIO.write(tempButtons[0], "jpg", new File(fileName + "00.jpg"));   
        tempButtons[1] = robot.createScreenCapture(rectButtons[1]);
        ImageIO.write(tempButtons[1], "jpg", new File(fileName + "01.jpg"));  
        tempButtons[2] = robot.createScreenCapture(rectButtons[2]);
        ImageIO.write(tempButtons[2], "jpg", new File(fileName + "02.jpg"));        
        tempButtons[3] = robot.createScreenCapture(rectButtons[3]);
        ImageIO.write(tempButtons[3], "jpg", new File(fileName + "03.jpg"));  
        tempButtons[4] = robot.createScreenCapture(rectButtons[4]);
        ImageIO.write(tempButtons[4], "jpg", new File(fileName + "04.jpg"));  
        tempButtons[5] = robot.createScreenCapture(rectButtons[5]);
        ImageIO.write(tempButtons[5], "jpg", new File(fileName + "05.jpg"));       
        tempButtons[6] = robot.createScreenCapture(rectButtons[6]);
        ImageIO.write(tempButtons[6], "jpg", new File(fileName + "06.jpg"));  
        tempButtons[7] = robot.createScreenCapture(rectButtons[7]);
        ImageIO.write(tempButtons[7], "jpg", new File(fileName + "07.jpg"));  
        tempButtons[8] = robot.createScreenCapture(rectButtons[8]);
        ImageIO.write(tempButtons[8], "jpg", new File(fileName + "08.jpg"));         
        tempButtons[9] = robot.createScreenCapture(rectButtons[9]);
        ImageIO.write(tempButtons[9], "jpg", new File(fileName + "09.jpg"));     
         
        sendButton = robot.createScreenCapture(sendBttnRect);
        ImageIO.write(sendButton, "jpg", new File(fileName + "y.jpg"));                  
                
        digits[0] = robot.createScreenCapture(rectDigit1);
        ImageIO.write(digits[0], "jpg", new File(fileName + "1.jpg"));         
        digits[1] = robot.createScreenCapture(rectDigit2);
        ImageIO.write(digits[1], "jpg", new File(fileName + "2.jpg"));
        digits[2] = robot.createScreenCapture(rectDigit3);
        ImageIO.write(digits[2], "jpg", new File(fileName + "3.jpg"));
        digits[3] = robot.createScreenCapture(rectDigit4);
        ImageIO.write(digits[3], "jpg", new File(fileName + "4.jpg")); 
        }
        catch(IOException ex)
        {
             System.err.println(ex);
        }
    }
    
    public void getImages()
    {
        try
        {
        textWindowCheck = ImageIO.read(new File("Resources/imagex.jpg"));
        tempTextWindowCheck = ImageIO.read(new File("Resources/other/anwe.jpg"));   
      
        checkButtons[0] = ImageIO.read(new File("Resources/buttons/0.jpg"));
        checkButtons[1] = ImageIO.read(new File("Resources/buttons/1.jpg"));
        checkButtons[2] = ImageIO.read(new File("Resources/buttons/2.jpg"));
        checkButtons[3] = ImageIO.read(new File("Resources/buttons/3.jpg"));
        checkButtons[4] = ImageIO.read(new File("Resources/buttons/4.jpg"));
        checkButtons[5] = ImageIO.read(new File("Resources/buttons/5.jpg"));
        checkButtons[6] = ImageIO.read(new File("Resources/buttons/6.jpg"));
        checkButtons[7] = ImageIO.read(new File("Resources/buttons/7.jpg"));
        checkButtons[8] = ImageIO.read(new File("Resources/buttons/8.jpg"));
        checkButtons[9] = ImageIO.read(new File("Resources/buttons/9.jpg"));
        
        tempButtons[0] = ImageIO.read(new File("Resources/image00.jpg"));
        tempButtons[1] = ImageIO.read(new File("Resources/image01.jpg"));
        tempButtons[2] = ImageIO.read(new File("Resources/image02.jpg"));
        tempButtons[3] = ImageIO.read(new File("Resources/image03.jpg"));
        tempButtons[4] = ImageIO.read(new File("Resources/image04.jpg"));
        tempButtons[5] = ImageIO.read(new File("Resources/image05.jpg"));
        tempButtons[6] = ImageIO.read(new File("Resources/image06.jpg"));
        tempButtons[7] = ImageIO.read(new File("Resources/image07.jpg"));
        tempButtons[8] = ImageIO.read(new File("Resources/image08.jpg"));
        tempButtons[9] = ImageIO.read(new File("Resources/image09.jpg"));
        
        checkDigits[0] = ImageIO.read(new File("Resources/digits/0.jpg"));
        checkDigits[1] = ImageIO.read(new File("Resources/digits/1.jpg"));
        checkDigits[2] = ImageIO.read(new File("Resources/digits/2.jpg"));
        checkDigits[3] = ImageIO.read(new File("Resources/digits/3.jpg"));
        checkDigits[4] = ImageIO.read(new File("Resources/digits/4.jpg"));
        checkDigits[5] = ImageIO.read(new File("Resources/digits/5.jpg"));
        checkDigits[6] = ImageIO.read(new File("Resources/digits/6.jpg"));
        checkDigits[7] = ImageIO.read(new File("Resources/digits/7.jpg"));
        checkDigits[8] = ImageIO.read(new File("Resources/digits/8.jpg"));
        checkDigits[9] = ImageIO.read(new File("Resources/digits/9.jpg"));  
       
        digits[0] = ImageIO.read(new File("Resources/image1.jpg"));
        digits[1] = ImageIO.read(new File("Resources/image2.jpg"));
        digits[2] = ImageIO.read(new File("Resources/image3.jpg"));
        digits[3] = ImageIO.read(new File("Resources/image4.jpg"));      
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void execute()
    {        
        try
          {   
            Thread.sleep(0);
            robot = new Robot();
            fileName = "Resources/image";	
            setRectangles();
            doScreenshots();
            getImages();
          
            if(checkImage(tempTextWindowCheck, textWindowCheck))
            {
                for(int i = 0; i < 4; i++)
                {
                    for(int j = 0; j < 10; j++)
                    {
                        if(checkImage(digits[i], checkDigits[j]))
                        {
                            //System.out.println("OK");
                            code[i] = j;
                            break;
                        }
                    }
                }                   
                checkButtons(checkButtons, tempButtons);
                enterCode(code);
                robot.mouseMove(1054+10, 613+10);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
          } catch(AWTException | InterruptedException ex) 
          {
              System.err.println(ex);
          }     
    }
    
    public void checkButtons(BufferedImage[] imgs1, BufferedImage[] imgs2)
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
               if(checkImage(imgs1[i], imgs2[j]))
               {
                   buttons[i] = imgs2[j];
                   bttnX[i] = rectButtons[j].x + 10;
                   bttnY[i] = rectButtons[j].y + 10;                   
                   break;
               }
            }            
        }
    }
    
    public void enterCode(int[] digits)
    {
        for(int i = 0; i < 4; i++)
        {
            robot.mouseMove(bttnX[digits[i]], bttnY[digits[i]]);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            try
            {
                Thread.sleep(250);
            }
            catch(InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
           /*robot.mouseMove(bttnX[digits], bttnY[digits]);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);*/
    }
    
    public boolean checkImage(BufferedImage img1, BufferedImage img2)
    {
        BufferedImage temp1, temp2;
        temp1 = img1;
        temp2 = img2;
        convert2bw(temp1);
        convert2bw(temp2);        
        if(img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight())
        {
            for(int x = 0; x < img1.getWidth(); x++)
            {
                for(int y = 0; y < img1.getHeight(); y++)
                {
                    if(img1.getRGB(x, y) != img2.getRGB(x, y))
                    {
                        return false;
                    }           
                }
            }                           
        }
        else return false;
        return true;
    }
    
    // converts an image to a black and white one
    public BufferedImage convert2bw(BufferedImage image) 
    {
      ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
      ColorConvertOp ccop = new ColorConvertOp(cs, null);
      return ccop.filter(image, null);
    }    
}


/*
//Erste Reihe

917 - 940
417 - 440

944 - 967
417 - 440

971 - 994
417 - 440

//Zweite Reihe

917 - 940
446 - 469

944 - 967
446 - 469

971 - 994
446 - 469

//Dritte Reihe

917 - 940
475 - 498

944 - 967
475 - 498

971 - 994
475 - 498

//Vierte Reihe

917 - 940
504 - 527

Groesse:
23 x 23

Anwesenheit
810 - 929
235 - 243

Absenden
1054 - 1128
613 - 637



*/