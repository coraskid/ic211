import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class establishes the shark in the tank; the shark moves diagonally for
 * a randomly set amound of steps and then chooses a new direction
 * @author Cora Skidmore
 */
public class Shark extends Animal {
  //MOVES diagonally
  private int stepCount = 0;
  private int dir;
  private BufferedImage img;
  private int stepRand;
  private final double MVE = .0001;
  /**
   * constructor creates a shark and puts it on the screen based on the
   * tanksize
   * @param ts Tanksize
   */
  public Shark(TankSize ts){
    super(ts);
    this.y = rand.nextDouble();
    this.x = rand.nextDouble();
    speed = 2;
    type = 4;
    dir = 1;
    stepRand = rand.nextInt(750) + 500;
    //image
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("shark.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }
 
  /**
   * This is how a shark is drawn onto the screen
   * @param g Graphics2D
   */
  public void paint(Graphics2D g){
    //forward
    if(alive && (dir == 1 || dir == 2))
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
    //backward
    if(alive && (dir == 3 || dir == 4))
      g.drawImage(img, (int)(x*ts.getHorz()) + img.getWidth(), (int)(y*ts.getVert()), -this.img.getWidth(), this.img.getHeight(), null);
  }
  /**
   * This is how the shark steps
   */
  public void step(){
    super.step();
    if(stepRand != 0){
      stepRand --;
    } else {
      if(dir == 2 || dir == 4)
        dir --;
      else
        dir++;
      stepRand = rand.nextInt(750) + 500;
    }
    if(dir == 1)
      this.stepRightUp();
    if(dir == 2)
      this.stepRightDown();
    if(dir == 3)
      this.stepLeftDown();
    if(dir == 4)
      this.stepLeftUp();
  }
  /**
   * This dictates a single step up and right
   */
  public void stepRightUp(){ //dir =1 
    x += (speed * MVE);
    y -= (speed * MVE);
    if(x >=1){
      dir = 4;
      x -= 2*(speed * MVE);
    }
    if(y <= 0){
      dir = 2;
      y += 2*(speed * MVE);
    }
    if (x >= 1 && y <= 0){
      dir = 3;
    }
  }
  /**
   * This dictates a single step right and down
   */
  public void stepRightDown(){ //dir =2 
    x += (speed * MVE);
    y += (speed * MVE);
    if(x >=1){
      dir = 3;
      x -= 2*(speed * MVE);
    }
    if(y >= 1){
      dir = 1;
      y -= 2*(speed * MVE);
    }
    if (x >= 1 && y <= 0){
      dir = 4;
    }
  }
  /**
   * This dictates a single step left and down
   */
  public void stepLeftDown(){ //dir =3 
    x -= (speed * MVE);
    y += (speed * MVE);
    if(x <= 0){
      dir = 2;
      x += 2*(speed * MVE);
    }
    if(y >= 1){
      dir = 4;
      y -= 2*(speed * MVE);
    }
    if (x <= 0 && y >= 1){
      dir = 1;
    }
  }
  /**
   * This dicatates a single step left and up
   */
  public void stepLeftUp(){ //dir =4 
    x -= (speed * MVE);
    y -= (speed * MVE);
    if(x <=0){
      dir = 1;
      x += 2*(speed * MVE);
    }
    if(y <= 0){
      dir = 3;
      y += 2*(speed * MVE);
    }
    if (x <= 0 && y <= 0){
      dir = 2;
    }
  }
  /**
   * This method returns a shape the defines where the sharl is; used for any
   * overlapping or containign methods
   * @return Shape
   */
  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
                                  (int)(y*ts.getVert()),
                                  this.img.getWidth(),
                                  this.img.getHeight());
  }
}


