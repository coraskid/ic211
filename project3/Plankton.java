import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class Plankton extends Animal {
  
  private double depthGoal;

  public Plankton(){
    super();
    Random rand = new Random();
    depthGoal = rand.nextInt(400);
    this.y = 0;
    this.x = rand.nextInt(400);
  }

  public void paint(Graphics2D g){
    g.fill(new Ellipse2D.Double(x,y,20,20));
  }

  public void step(){
    if ( y < depthGoal)
      y++;
  }
  





}
