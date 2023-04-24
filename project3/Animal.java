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

  public Animal(){
    alive = true;
    rand = new Random();
  }

  public abstract void paint(Graphics2D g);

  public abstract void step();




}
