import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

//uses class notes

public class DrawAq extends JComponent {
  //private ArrayList<Animal> fish;
  /*
  public DrawAq(){
    DrawAq("aquar.png");
  }
  */
  private Plankton t;
  BufferedImage img;

  public DrawAq(String fname){
    BufferedImage img = null;
    t = new Plankton();
    int height = 0;
    int width = 0;
    try {
      img = ImageIO.read(new File(fname));
      height = img.getHeight();
      width = img.getWidth();
    } catch (IOException ioe) {
      height = 400;
      width = 300;
    }
    this.img = img;
    System.out.println(height + " " + width);
    setPreferredSize(new Dimension(height, width));
    //Graphics2D g2 = new Graphics2D();
    //g2.drawImage(img, width, height, null);
  }

  public void step(){
    t.step();
  }

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    t.paint(g2);
    



  }
}
    
    
