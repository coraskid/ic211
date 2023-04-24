import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class SFish extends Animal {
  //MOVES UP DOWN LEFT RIGHT
  private int stepCount = 0;
  private int direction;
  public SFish(){
    super();
    //depthGoal = rand.nextInt(820);
    this.y = rand.nextInt(820);
    this.x = 0;
    speed = 2;
    type = 2;
    direction = 1;
  }

  public void paint(Graphics2D g){
    g.setColor(new Color(50, 150, 0));
    g.fill(new Ellipse2D.Double(x,y,15,15));
  }

  public void step(){
    //if ( y < depthGoal)
    //  y += speed;
  }

  private void stepleft(





  





}
