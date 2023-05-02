import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
/**
 * This class establishes the small fish in the tank; this fish moves left and
 * right with a random up and down component
 * @author Cora Skidmore
 */
public class SFish extends Animal {
  //MOVES UP DOWN LEFT RIGHT
  private int stepCount = 0;
  private int dir;
  private BufferedImage img;
  private final double MVE = .0001;
  /**
   * constructor Creates a small fish and puts in on the screen base on teh tank
   * size
   * @param ts Tanksize
   */
  public SFish(TankSize ts){
    super(ts);
    this.y = rand.nextDouble() * .6;
    this.x = rand.nextDouble();
    speed = 2;
    type = 2;
    dir = 1;
    //image
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("Sfish.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }
  /**
   * This is how this fish is drawn onto the screen
   * @param g Graphics2D
   */
  public void paint(Graphics2D g){
    //Forward
    if(alive && dir == 1)
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
    //backward
    if(alive && dir == 3)
      g.drawImage(img, (int)(x*ts.getHorz()) + img.getWidth(), (int)(y*ts.getVert()), -this.img.getWidth(), this.img.getHeight(), null);
  }
  /**
   * This is how the fish steps
   */
  public void step(){
    super.step();
    if (dir == 1){
      this.stepRight();
    } else if (dir == 3){
      this.stepLeft();
    }
    //FIX
    int vertMove = rand.nextInt(10);
    //System.out.println(vertMove);
    if(vertMove == 2){
      this.stepUp();
    }
    if(vertMove == 3){
      this.stepDown();
    }
  }
  /**
   * This method steps right and turns around as nessesary
   */
  private void stepRight(){
    x += (speed * MVE);
    if( x >= 1) {
      dir = 3;
      x -= 2*(speed * MVE);
      for(int i = 0; i < 10; i++)
        this.stepDown();
    }
  }
  /**
   * This method steps left and turns around as nessesary
   */
  private void stepLeft(){
    x -= (speed * MVE);
    if(x <= 0) {
      dir = 1;
      x += 2*(speed * MVE);
      for(int i = 0; i < 10; i++)
        this.stepUp();
    }
  }
  /**
   * This method steps up is there is room to do so
   */
  private void stepUp(){
    if((y + (500 * MVE)) > 1)
      y += (500 * MVE);
  }
  /**
   * This method steps down if there is room to do so
   */
  private void stepDown(){
    if((y - (500 * MVE)) < 0)
      y -= (500 *MVE);
  }
  /**
   * This method returns a shape that defines where the fish is; used for any
   * overlapping or containing methods
   * @return Shape
   */
  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
        (int)(y*ts.getVert()),
        this.img.getWidth(),
        this.img.getHeight());
  }
}


