import java.util.*;

public class Midshipman{
  private double speed;
  private double strength;
  private double intelligence;
  private double heart;
  private double ability;

  public Midshipman(double sp, double st, double in, double hr){
    this.speed = sp;
    this.strength = st;
    this.intelligence = in;
    this.heart = hr;
    this.ability = (.3*sp) + (.2*st) + (.4*in) + (.1*hr);

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

  public void print(){
    System.out.println("Midshipman " + (this.speed) + " " + (this.strength) + " " + (this.intelligence) + " " + (this.heart));
  }





  public static void main(String[] args){


  }

}
