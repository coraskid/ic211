import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class established the plankton in the tank; they move at a random speed
 * down to a random depth (only 75% max)
 * NOTE: I am aware I should have had a seperate plankton and fish classes as
 * plankton dont always behave as fish, but its a little to late, so they just
 * have some extra, unused variables
 * @author Cora Skidmore
 */
public class Plankton extends Animal {
  private double depthGoal;
  /**
   * constructor creates a plankton and puts it on the screen based on the
   * tanksize
   * @param ts tanksize
   */
  public Plankton(TankSize ts){
    super(ts);
    depthGoal = rand.nextDouble() * .75;
    this.y = 0;
    this.x = rand.nextDouble();
    speed = rand.nextInt(20);
    type = 1;
  }
  /**
   * defines how to paint the plankton on the screen
   * @param g Graphics2D
   */
  public void paint(Graphics2D g){
    if(this.alive){
    g.setColor(new Color(50, 150, 100));
    g.fill(new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),10,10));
    }
  }
  /**
   * This is how a plankton steps
   */
  public void step(){
    if ( y < depthGoal)
      y += (speed * .0001);
  }
  /**
   * This returns the shape that defines where the fish is; used for any
   * overlapping or containing methods
   * @return Shape 
   */
  public Shape getShape(){
    return new Ellipse2D.Double((x*ts.getHorz()),(y*ts.getVert()),10,10);
  }
}
