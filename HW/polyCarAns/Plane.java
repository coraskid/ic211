import java.util.*;
public class Plane extends Vehicle {
  private int numWheels;
  private boolean canfly;
  private String noise = "woooosh";


  public Plane(String type, String model, int mpg){
    super(type, model, mpg);
    this.numWheels = 3;
    this.canfly = true;
  }

  public static Plane read(Scanner sc){
    return new Plane("plane", sc.next(), sc.nextInt());
  }

  public String toString() {
    return super.toString() + " " + noise + " does fly with " + numWheels + " wheels.";  
  }


}
