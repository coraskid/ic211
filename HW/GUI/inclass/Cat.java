import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import java.awt.event.*;

public class Cat extends Ball {
    //will hold image for cat
    private BufferedImage img = null;
    private AffineTransform transform;
    private int w, h;
    private int angle = 90;

    public Cat(double x, double y, Random rand){
        super(x,y);
        delta = 3 + rand.nextInt(8);
        //read image for cat
        try {
          img = ImageIO.read(new File("catr.png"));
        } catch (IOException e) {}
        w = img.getWidth();
        h = img.getHeight();
        transform = new AffineTransform();
    }
    //operates exactly like a ball, but instead of drawing an ellipse, draws cat 
    public void paint(Graphics2D g) {
        
        Graphics2D g2 = (Graphics2D)g;
        //draw the cat 
        
        g2.drawImage(img, (int)(x), (int)(y),80,80, null);
        g2.setColor(Color.RED);
        g2.draw(new Rectangle2D.Double((int)(x), (int)(y), 80, 80));
        
       }

       public void mouseClicked(MouseEvent e) {
        setGoal(e.getX(), e.getY());
    
        
      }
     
      
    
}
