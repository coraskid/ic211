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

  public Animal(TankSize ts){
    alive = true;
    rand = new Random();
    this.ts = ts;
  }

  public abstract void paint(Graphics2D g);

  public abstract void step();




}
