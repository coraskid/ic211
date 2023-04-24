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
  private Zoo zoo;

  public DrawAq(String fname, Zoo z){
    BufferedImage img = null;
    this.zoo = z;
    //t = new Plankton();
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
    for(Animal i : zoo){
      i.step();
    }
  }

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int curW = this.getWidth();
    int curH = this.getHeight();
    g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    System.out.println(this.getWidth() + " " + this.getHeight());
    for(Animal i : zoo){
      i.paint(g2);
    }
    



  }
}
