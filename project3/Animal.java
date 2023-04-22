import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public abstract class Animal {
  //private int health;
  //private int hunger;
  //private int speed;
  protected boolean alive;
  protected double x, y;
  
  public Animal(){
    alive = true;
  }

  public abstract void paint(Graphics2D g);

  public abstract void step();




}
