import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame
{     
    BufferedImage digit1, digit2, digit3, digit4 = new BufferedImage(9, 14, BufferedImage.TYPE_BYTE_BINARY);
    BufferedImage checkDigit0, checkDigit1, checkDigit2, checkDigit3, checkDigit4, checkDigit5, checkDigit6, checkDigit7, checkDigit8, checkDigit9;
    BufferedImage bttn0, bttn1, bttn2, bttn3, bttn4, bttn5, bttn6, bttn7, bttn8, bttn9;
    BufferedImage tempbttn0, tempbttn1, tempbttn2, tempbttn3, tempbttn4, tempbttn5, tempbttn6, tempbttn7, tempbttn8, tempbttn9;
    BufferedImage checkBttn0, checkBttn1, checkBttn2, checkBttn3, checkBttn4, checkBttn5, checkBttn6, checkBttn7, checkBttn8, checkBttn9;
       
    Rectangle rectDigit1,rectDigit2, rectDigit3, rectDigit4;
    Rectangle rectButton0, rectButton1, rectButton2, rectButton3, rectButton4, rectButton5, rectButton6, rectButton7, rectButton8, rectButton9;
    Robot robot;
    String fileName;
    
    public Main()
    {
        try
        {
        Thread.sleep(0);
        try
        {
            robot = new Robot();
        }
        catch(AWTException ex)
        {
            System.err.println(ex);
        }
   
        fileName = "Resources/image";
         
    //####################################DIGITS##############################
        
        setDigitRectangles();       
        getDigitScreenshots();       
        getCheckDigits();                          
        Thread.sleep(500);       
        getDigits();
                
        if(checkImage(digit1, checkDigit3))
        {
            System.out.println("OK");
        }
        else System.out.println("NOPE");   
        
    //####################################BUTTONS##############################
        
        getCheckButtons();
        setButtonRectangles();
        getButtonScreenshots();         
        Thread.sleep(500);
    //##################################################################
        
        /* instance.setLocation(500, 500);
         JLabel text = new JLabel("screenshot saved!");
         instance.add(text);
         instance.setSize(200, 100);
         instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         instance.getContentPane().setLayout(new FlowLayout());
         instance.setVisible(true);*/
        } catch(InterruptedException ex) 
        {
            System.err.println(ex);
        }
    }
  
    public static void main(String[] args)
    {
       Main instance = new Main();
       
    }
      
    //####################################BUTTONS##############################
    
    public void getCheckButtons()
    {
        try
        {
        checkBttn0 = ImageIO.read(new File("Resources/buttons/0.jpg"));
        checkBttn1 = ImageIO.read(new File("Resources/buttons/1.jpg"));
        checkBttn2 = ImageIO.read(new File("Resources/buttons/2.jpg"));
        checkBttn3 = ImageIO.read(new File("Resources/buttons/3.jpg"));
        checkBttn4 = ImageIO.read(new File("Resources/buttons/4.jpg"));
        checkBttn5 = ImageIO.read(new File("Resources/buttons/5.jpg"));
        checkBttn6 = ImageIO.read(new File("Resources/buttons/6.jpg"));
        checkBttn7 = ImageIO.read(new File("Resources/buttons/7.jpg"));
        checkBttn8 = ImageIO.read(new File("Resources/buttons/8.jpg"));
        checkBttn9 = ImageIO.read(new File("Resources/buttons/9.jpg"));  
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void setButtonRectangles()
    {
        rectButton0 = new Rectangle(917, 417, 23, 23);
        rectButton1 = new Rectangle(944, 417, 23, 23);
        rectButton2 = new Rectangle(971, 417, 23, 23);
        
        rectButton3 = new Rectangle(917, 446, 23, 23);
        rectButton4 = new Rectangle(944, 446, 23, 23);
        rectButton5 = new Rectangle(971, 446, 23, 23);
        
        rectButton6 = new Rectangle(917, 475, 23, 23);
        rectButton7 = new Rectangle(944, 475, 23, 23);
        rectButton8 = new Rectangle(971, 475, 23, 23);
        
        rectButton9 = new Rectangle(917, 504, 23, 23);
    }
    
    public void getButtonScreenshots()
    {
        try
        {
        tempbttn0 = robot.createScreenCapture(rectButton0);
        ImageIO.write(tempbttn0, "jpg", new File(fileName + "00.jpg"));   
        tempbttn1 = robot.createScreenCapture(rectButton1);
        ImageIO.write(tempbttn1, "jpg", new File(fileName + "01.jpg"));  
        tempbttn2 = robot.createScreenCapture(rectButton2);
        ImageIO.write(tempbttn2, "jpg", new File(fileName + "02.jpg")); 
        
        tempbttn3 = robot.createScreenCapture(rectButton3);
        ImageIO.write(tempbttn3, "jpg", new File(fileName + "03.jpg"));  
        tempbttn4 = robot.createScreenCapture(rectButton4);
        ImageIO.write(tempbttn4, "jpg", new File(fileName + "04.jpg"));  
        tempbttn5 = robot.createScreenCapture(rectButton5);
        ImageIO.write(tempbttn5, "jpg", new File(fileName + "05.jpg")); 
        
        tempbttn6 = robot.createScreenCapture(rectButton6);
        ImageIO.write(tempbttn6, "jpg", new File(fileName + "06.jpg"));  
        tempbttn7 = robot.createScreenCapture(rectButton7);
        ImageIO.write(tempbttn7, "jpg", new File(fileName + "07.jpg"));  
        tempbttn8 = robot.createScreenCapture(rectButton8);
        ImageIO.write(tempbttn8, "jpg", new File(fileName + "08.jpg"));  
        
        tempbttn9 = robot.createScreenCapture(rectButton9);
        ImageIO.write(tempbttn9, "jpg", new File(fileName + "09.jpg"));        
        }
        catch(IOException ex)
        {
             System.err.println(ex);
        }
    }
    
    //####################################DIGITS###############################
    
    public void getCheckDigits()
    {
        try
        {
        checkDigit0 = ImageIO.read(new File("Resources/digits/0.jpg"));
        checkDigit1 = ImageIO.read(new File("Resources/digits/1.jpg"));
        checkDigit2 = ImageIO.read(new File("Resources/digits/2.jpg"));
        checkDigit3 = ImageIO.read(new File("Resources/digits/3.jpg"));
        //checkDigit4 = ImageIO.read(new File("Resources/digits/4.jpg"));
        //checkDigit5 = ImageIO.read(new File("Resources/digits/5.jpg"));
        //checkDigit6 = ImageIO.read(new File("Resources/digits/6.jpg"));
        checkDigit7 = ImageIO.read(new File("Resources/digits/7.jpg"));
        //checkDigit8 = ImageIO.read(new File("Resources/digits/8.jpg"));
        checkDigit9 = ImageIO.read(new File("Resources/digits/9.jpg"));  
        }
        catch(IOException ex) 
        {
            System.err.println(ex);
        }
    }
        
    public void getDigits()
    {
        try
        {
        digit1 = ImageIO.read(new File("Resources/image1.jpg"));
        digit2 = ImageIO.read(new File("Resources/image2.jpg"));
        digit3 = ImageIO.read(new File("Resources/image3.jpg"));
        digit4 = ImageIO.read(new File("Resources/image4.jpg"));
        }
        catch(IOException ex) 
        {
            System.err.println(ex);
        }
    }
    
    public void getDigitScreenshots()
    {
        try
        {
        digit1 = robot.createScreenCapture(rectDigit1);
        ImageIO.write(digit1, "jpg", new File(fileName + "1.jpg"));         
        digit2 = robot.createScreenCapture(rectDigit2);
        ImageIO.write(digit2, "jpg", new File(fileName + "2.jpg"));
        digit3 = robot.createScreenCapture(rectDigit3);
        ImageIO.write(digit3, "jpg", new File(fileName + "3.jpg"));
        digit4 = robot.createScreenCapture(rectDigit4);
        ImageIO.write(digit4, "jpg", new File(fileName + "4.jpg"));  
        }
        catch(IOException ex)
        {
             System.err.println(ex);
        }
    }
    
    public void setDigitRectangles()
    {
        rectDigit1 = new Rectangle(810, 351, 9, 14);
        rectDigit2 = new Rectangle(820, 351, 9, 14);
        rectDigit3 = new Rectangle(830, 351, 9, 14);
        rectDigit4 = new Rectangle(841, 351, 9, 14);
    }
    
    //####################################ANDERES##############################
    
    public boolean checkImage(BufferedImage img1, BufferedImage img2)
    {
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
*/