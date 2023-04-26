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
  private int direction;
  private BufferedImage img;
  public MFish(TankSize ts){
    super(ts);
    //depthGoal = rand.nextInt(820);
    this.y = rand.nextDouble();
    this.x = 0;
    speed = 2;
    type = 3;
    direction = 1;

    BufferedImage image = null;
    try {
      image = ImageIO.read(new File("Mfish.png"));
    } catch (IOException ioe) {}
    this.img = image;
  }

  public void paint(Graphics2D g){
    //g.setColor(new Color(50, 150, 0));
    //g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),15,15));
    g.drawImage(img, (int)(x*ts.getHorz()), (int)(y*ts.getVert()), null);
  }

  public void step(){
    if ( x < ts.getHorz())
      x += (speed * .0001);
  }

  //private void stepleft(





  





}


