import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class establishes the basic characteristics of an Animal
 * @author Cora Skidmore
 */
public abstract class Animal {
  private double health;
  protected int speed;
  protected double metab;
  protected boolean alive;
  protected double x, y;
  protected int type;
  protected Random rand;
  protected TankSize ts;
  /**
   * Constructor takes the tanksize as all fish are drawn with respect to their
   * ratio in the tank
   * @param ts Tanksize
   */
  public Animal(TankSize ts){
    alive = true;
    rand = new Random();
    this.ts = ts;
    this.health = 100;
    this.metab = .01;
  }
  
  /**
   * Paint method will be defined in subclasses
   * @param g Graphics2D
   */
  public abstract void paint(Graphics2D g);

  /**
   * The step method will decrease health if the super.step() is called,
   * otherwise, likely overridden
   */
  public void step(){
    health = health - metab;
    if(health < 0)
      this.kill();
  }

  /**
   * Returns type (Plankton = 1, small fish = 2, medium fish = 3, shark = 4)
   * @return int type
   */
  public int getType(){
    return this.type;
  }
  /**
   * Returns speed
   * @returns int speed
   */
  public int getSpeed(){
    return this.speed;
  }
  /**
   * Returns health
   * @returns double health
   */
  public double getHealth(){
    return this.health;
  }
  /**
   * Sets speed
   * @param s new speed
   */
  public void setSpeed(int s){
    this.speed = s;
  }
  /**
   * Sets metabolism
   * @param m new metabolism
   */
  public void setMetab(int m){
    this.metab = .01 * metab;
  }
  /**
   * Defined in child classes - returns a shape outlining the animal; for
   * intersection purposes
   * @return Shape
   */
  public abstract Shape getShape();
  /**
   * This method kills the animal and will no long show in the aquarium
   */
  public void kill(){
    this.alive = false;
  }
  /**
   * Adds 5 to overall health of the fish
   */
  public void eat(){
    health += 5;
  }
  /**
   * Returns a boolean as to if the fish is alive or not
   * @return boolean dead (false) or alive (true)
   */
  public boolean isAlive(){
    return this.alive;
  }
}
