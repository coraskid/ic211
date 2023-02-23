import java.util.*;
import java.io.*;

public class Midshipman{
  private double speed;
  private double strength;
  private double intelligence;
  private double heart;
  private String alpha;
  private String first;
  private String last;
  private double ability;

  public Midshipman(String alpha, String first, String last, double sp, double st, double in, double hr){
    this.alpha = alpha;
    this.first = first;
    this.last = last;
    this.speed = sp;
    this.strength = st;
    this.intelligence = in;
    this.heart = hr;
    this.ability = (.3*sp) + (.2*st) + (.4*in) + (.1*hr);

  }

  public Midshipman(Scanner in){
    this.alpha = in.next();
    this.first = in.next();
    this.last = in.next();
    this.speed = in.nextDouble();
    this.strength = in.nextDouble();
    this.intelligence = in.nextDouble();
    this.heart = in.nextDouble();
    this.ability = (.3*this.speed) + (.2*this.strength) + (.4*this.intelligence) + (.1*this.heart);



  }

  public double getAbility(){
    return this.ability;
  }

  public boolean willBeat(Midshipman x){
    if(this.ability > x.ability)
      return true;
    else
      return false;
  }

  public boolean willBeat(Midshipman x, Random rand){
    double newThis = this.ability + 20*(rand.nextDouble());
    double newx = x.ability + 20*(rand.nextDouble());
    if(newThis > newx)
      return true;
    else
      return false;

  }

  public void print(){
    System.out.print(this.alpha + ": " + this.last + ", " + this.first);
  }





  public static void main(String[] args){


  }

}
