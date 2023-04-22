import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

public class Ball implements MouseListener {
  private double goalx, goaly;
  protected double x, y, r, delta;
  private ArrayList<Ball> balls;
  private boolean mouseListenerAssigned = false;
  protected Random rand;

  
  public Ball(double x, double y, ArrayList<Ball> b, Random ran) {
    this.x = x;
    this.y = y;

    //This will let us add Balls to the Arraylist shared by components in the scene
    this.balls = b;
    rand =ran;
    r = 4 + rand.nextInt(5);
    //delta is speed of movement
    delta = 3 + rand.nextInt(8);
  }

  public Ball(double x, double y) {
    this.x = x;
    this.y = y;
    r = 4;
    delta = 6;
  }

  public void setMouseListenerAssigned(){
    mouseListenerAssigned = true;
  }

  public boolean getMouseListenerAssigned(){
    return mouseListenerAssigned;
  }

  public void setGoal(double gx, double gy) {
    goalx = gx;
    goaly = gy;
  }
 // update the position of the ball
  public void step() {
    if (Math.sqrt(Math.pow(goaly - y, 2) + Math.pow(goalx - x, 2)) < delta){
      x = goalx;
      y = goaly;
    } else{
      double a = Math.atan2(goaly - y, goalx - x);
      x += delta * Math.cos(a);
      y += delta * Math.sin(a);
    }
  }
//how the ball is actually drawn
  public void paint(Graphics2D g) {
    g.setColor(Color.BLUE);
   g.fill(new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r));
  }


  // when the mouse is clicked, create a new instance of ball and add it to the ArrayList
  public void mouseClicked(MouseEvent e) {
    setGoal(e.getX(), e.getY());
    
   
    //remove excess balls, keeps program from crashing, there is probably a better way to do this
    if(balls.size()>5){
      balls.remove(balls.get(2));
    }
  }

  public void mouseEntered(MouseEvent e)  {}
  public void mouseExited(MouseEvent e)   {}
  public void mousePressed(MouseEvent e)  {}
  public void mouseReleased(MouseEvent e) {}
}