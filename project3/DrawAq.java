import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * This class draws the aquarium whenever it is told to due so; it does so by
 * looking at all the current fish (not dead) and drawing them on the screen; it
 * also sets up the mouse listener the stats class
 * This has a lot of elements from class notes
 * @author Cora Skidmore
 */
public class DrawAq extends JComponent {
  private Plankton t;
  BufferedImage img;
  private Zoo zoo;
  private TankSize ts;
  /**
   * constructor: sets up background photo and mouse listener; also saves the
   * zoo and the tank size
   * @param fname file name of the background image
   * @param z Zoo
   * @param ts Tanksize
   * @param stat stats (mouseListener)
   */
  public DrawAq(String fname, Zoo z, TankSize ts, Stats stat){
    addMouseListener(stat);
    this.ts = ts;
    this.zoo = z;
    //Image set up
    BufferedImage img = null;
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
    setPreferredSize(new Dimension(height, width));
  }
  /**
   * This method steps every Animal in the zoo one spot forward
   */
  public void step(){
    ArrayList<Animal> cpy = zoo.cpy();
    for(Animal i : cpy){
      i.step();
    }
  }
  /**
   * This method checks if any Animals (that are alive) are overlapping
   */
  public void overlap(){
    ArrayList<Animal> cpy = zoo.cpy(); //only copies alive fish
    for(Animal i : cpy){ //bigger fish
      for(Animal j : cpy){ //smaller fish that gets eaten
        int iT = i.getType();
        int jT = j.getType();
        //check that overlapping fish can actually eat the other
        if((iT == 4 && (jT == 2 || jT == 3)) || ((iT == 2 || iT == 3) && jT == 1)){
          if(j.getShape().intersects((Rectangle2D)i.getShape())){
            i.eat(); //updating health (+5)
            j.kill(); //killing
          }
        }
      }
    }
  }
  
  /**
   * This method paints the area every time repaint method is called
   * @param g Graphics
   */
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    //Voodoo?
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);
    //reset the tanksize incase of window movement
    ts.setHorz(this.getWidth());
    ts.setVert(this.getHeight());
    //draw background image
    g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    //draw fish
    ArrayList<Animal> cpy = zoo.cpy();
    for(Animal i : cpy){
      i.paint(g2); 
    }
  }
}
