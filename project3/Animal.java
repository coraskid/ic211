import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public abstract class Animal {
  private double health;
  //private int hunger;
  protected int speed;
  protected double metab;
  protected boolean alive;
  protected double x, y;
  protected int type;
  protected Random rand;
  protected TankSize ts;

  public Animal(TankSize ts){
    alive = true;
    rand = new Random();
    this.ts = ts;
    this.health = 100;
    this.metab = .01;
  }

  public abstract void paint(Graphics2D g);

  public void step(){
    health = health - metab;
    //System.out.println(health);
    if(health < 0)
      this.kill();
  }

  public int getType(){
    return this.type;
  }

  public void setSpeed(int s){
    this.speed = s;
  }
  public void setMetab(int m){
    this.metab = .01 * metab;
  }

  public abstract Shape getShape();

  public void kill(){
    //System.out.println("eaten");
    this.alive = false;
  }

  public void eat(){
    health += 5;
  }

  public boolean isAlive(){
    return this.alive;
  }
}
