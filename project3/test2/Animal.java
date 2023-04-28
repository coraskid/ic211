import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public abstract class Animal {
  //private int health;
  //private int hunger;
  protected int speed;
  protected boolean alive;
  protected double x, y;
  protected int type;
  protected Random rand;
  protected TankSize ts;
  protected int id;
  private static int idNum = 1;

  public Animal(TankSize ts){
    alive = true;
    rand = new Random();
    this.ts = ts;
    this.id = idNum;
    idNum ++;

  }

  public abstract void paint(Graphics2D g);

  public abstract void step();

  public int getType(){
    return this.type;
  }

  public void setSpeed(int s){
    this.speed = s;
  }

  public abstract Shape getShape();

  public void kill(){
    System.out.println("eaten");
    this.alive = false;
  }

  public boolean isAlive(){
    return this.alive;
  }
  public int getID(){
    return this.id;
  }
}
