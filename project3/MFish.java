import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class MFish extends Animal {
  //MOVES UP DOWN LEFT RIGHT
  private int stepCount = 0;
  private int dir; //1 left, 3 right
  private BufferedImage img;
  private final double MVE = .0001;
  private double startY;
  private double angle;
  public MFish(TankSize ts){
    super(ts);
    //depthGoal = rand.nextInt(820);
    this.startY = rand.nextDouble();
    this.y = this.startY;
    this.x = 0;
    speed = 2;
    type = 3;
    dir = 1;
    angle = 0;

    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("Mfish.png"));
    } catch (IOException ioe) {}
    this.img = image;
    System.out.println((int)(x*ts.getHorz()) + " " + (int)(y*ts.getVert()));
  }

  public void paint(Graphics2D g){
    //g.setColor(new Color(50, 150, 0));
    //g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),15,15));
    if(alive && dir == 1)
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
    if(alive && dir == 3)
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), -this.img.getWidth(), this.img.getHeight(), null);
      
  }

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

  


  private void stepRight(){
    x += (speed * MVE);
    if( x >= 1) {
      dir = 3;
      x -= 2*(speed * MVE);
    }
  }
  private void stepLeft(){
    x -= (speed * MVE);
    if(x <= 0) {
      dir = 1;
      x += 2*(speed * MVE);
    }
  }




  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
                                  (int)(y*ts.getVert()),
                                  this.img.getWidth(),
                                  this.img.getHeight());
  }


  





}


