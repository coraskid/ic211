import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class establishes the medium fish in the tank; this fish moves in a wave
 * pattern, although the speed is solely horizontal
 * @author Cora Skidmore
 */
public class MFish extends Animal {
  //MOVES SIN WAVE
  private int stepCount = 0;
  private int dir; //1 left, 3 right
  private BufferedImage img;
  private final double MVE = .0001;
  private double startY;
  private double angle;
  /**
   * Constructor creates a meduim fish and puts in on the screen based on the
   * tank size
   * @param ts TankSize
   */
  public MFish(TankSize ts){
    super(ts);
    this.startY = rand.nextDouble()*.8 + .1;
    this.y = this.startY;
    this.x = rand.nextDouble();
    speed = 2;
    type = 3;
    dir = 1;
    angle = 0;
    //image
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("Mfish.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }
  /**
   * This is how this fish is drawn onto the screen
   * @param g Graphics2D
   */
  public void paint(Graphics2D g){
    //forward
    if(alive && dir == 1)
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
    //backward
    if(alive && dir == 3)
      g.drawImage(img, (int)(x*ts.getHorz()) + img.getWidth(), (int)(y*ts.getVert()), -this.img.getWidth(), this.img.getHeight(), null);
  }
  /**
   * This is how this fish steps
   */
  public void step(){
    super.step();
    if (dir == 1){
      this.stepRight();
    }
    if (dir == 3){
      this.stepLeft();
    }
    y = startY + .1 * Math.cos(angle);
    angle = (angle + .005) % 360;
  }
  /**
   * This is a single step right used in the step method
   */
  private void stepRight(){
    x += (speed * MVE);
    if( x >= 1) {
      dir = 3;
      x -= 2*(speed * MVE);
    }
  }
  /**
   * this is a single step left used in the step method
   */
  private void stepLeft(){
    x -= (speed * MVE);
    if(x <= 0) {
      dir = 1;
      x += 2*(speed * MVE);
    }
  }
  /**
   * this method returns a shape that defines where the fish is; used for any
   * overlapping or conataining methods
   * @return Shape
   */
  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
                                  (int)(y*ts.getVert()),
                                  this.img.getWidth(),
                                  this.img.getHeight());
  }
}


