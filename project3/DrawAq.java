import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

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
  private TankSize ts;

  public DrawAq(String fname, Zoo z, TankSize ts){
    BufferedImage img = null;
    this.ts = ts;
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
    ArrayList<Animal> cpy = zoo.cpy();
    for(Animal i : cpy){
      i.step();
    }
    //zoo.overlap();
  }
    
  public void overlap(){
    ArrayList<Animal> cpy = zoo.cpy();
    for(Animal i : cpy){ //bigger fish
      
      for(Animal j : cpy){ //smaller fish that gets eaten
        int iT = i.getType();
        int jT = j.getType();
        if((iT == 4 && (jT == 2 || jT == 3)) || ((iT == 2 || iT == 3) && jT == 1)){
          //System.out.println("checking");
          if(j.getShape().intersects((Rectangle2D)i.getShape())){
            //System.out.println("checked!");
            j.kill();
          }
        }
      }
      
    }
   /* 
    for(Animal i : zoo){
      if(!i.isAlive()){
        zoo.removeFish(i);
      }
    }
    */
  }

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);

    ts.setHorz(this.getWidth());
    ts.setVert(this.getHeight());
    g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    //System.out.println(this.getWidth() + " " + this.getHeight());
    ArrayList<Animal> cpy = zoo.cpy();
    for(Animal i : cpy){
      i.paint(g2); 
      //i.step();
    }
   
    //this.overlap();
    



  }
}
