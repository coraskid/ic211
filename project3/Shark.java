import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class Shark extends Animal {
  //MOVES UP DOWN LEFT RIGHT
  private int stepCount = 0;
  private int dir;
  private BufferedImage img;
  private int stepRand;
  private final double MVE = .0001;
  public Shark(TankSize ts){
    super(ts);
    //depthGoal = rand.nextInt(820);
    this.y = rand.nextDouble();
    this.x = 0;
    speed = 2;
    type = 4;
    dir = 1;
    stepRand = rand.nextInt(750) + 500;
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("shark.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }

  public void paint(Graphics2D g){
    //g.setColor(new Color(50, 150, 0));
    //g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),15,15));
    if(alive && (dir == 1 || dir == 2))
      g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
    if(alive && (dir == 3 || dir == 4))
      g.drawImage(img, (int)(x*ts.getHorz()) + img.getWidth(), (int)(y*ts.getVert()), -this.img.getWidth(), this.img.getHeight(), null);

  }

  
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




    

  //private void stepleft(

  public Shape getShape(){
    return new Rectangle2D.Double((int)(x*ts.getHorz()), 
                                  (int)(y*ts.getVert()),
                                  this.img.getWidth(),
                                  this.img.getHeight());
  }




  





}


