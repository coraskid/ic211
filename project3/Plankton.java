import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class Plankton extends Animal {
  
  private double depthGoal;
   

  public Plankton(TankSize ts){
    super(ts);
    //Random rand = new Random();
    //depthGoal = rand.nextInt(820);
    depthGoal = rand.nextDouble() * .75;
    this.y = 0;
    //this.x = rand.nextInt(1791);
    this.x = rand.nextDouble();
    speed = rand.nextInt(20);
    type = 1;
  }

  public void paint(Graphics2D g){
    if(this.alive){
    g.setColor(new Color(50, 150, 100));
    g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),10,10));
    }
  }

  public void step(){
    if ( y < depthGoal)
      y += (speed * .0001);
  }

  public Shape getShape(){
    return new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),10,10);
  }
  





}
