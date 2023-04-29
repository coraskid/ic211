import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class SFish extends Animal {
  //MOVES UP DOWN LEFT RIGHT
  private int stepCount = 0;
  private int dir;
  private BufferedImage img;
  private final double MVE = .0001;
  public SFish(TankSize ts){
    super(ts);
    //depthGoal = rand.nextInt(820);
    this.y = rand.nextDouble();
    this.x = 0;
    speed = 2;
    type = 2;
    dir = 1;

    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("Sfish.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }

  public void paint(Graphics2D g){
    //g.setColor(new Color(50, 150, 0));
    //g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),15,15));
    if(alive)
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
  }

  public void step(){
    if (dir == 1){
      this.stepLeft();
    } else if (dir == 3){
      this.stepRight();
    }
    //FIX
    int vertMove = rand.nextInt(10);
    //System.out.println(vertMove);
    if(vertMove == 2){
      this.stepUp();
      System.out.println(vertMove);
    }
    if(vertMove == 3){
      this.stepDown();
      System.out.println(vertMove);
    }
  }
  private void stepLeft(){
    x += (speed * MVE);
    if( x >= 1) {
      dir = 3;
      x -= 2*(speed * MVE);
      for(int i = 0; i < 10; i++)
        this.stepDown();
    }
  }
  private void stepRight(){
    x -= (speed * MVE);
    if(x <= 0) {
      dir = 1;
      x += 2*(speed * MVE);
      for(int i = 0; i < 10; i++)
        this.stepUp();
    }
  }
  private void stepUp(){
    if((y + (500 * MVE)) > 1)
      y += (500 * MVE);
  }
  private void stepDown(){
    if((y - (500 * MVE)) < 0)
      y -= (500 *MVE);
  }


  //private void stepleft(

  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
        (int)(y*ts.getVert()),
        this.img.getWidth(),
        this.img.getHeight());
  }










}


