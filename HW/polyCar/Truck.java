import java.util.*;
public class Truck extends Vehicle {
  private int numWheels;
  private boolean canfly;
  private String noise = "bumbumbum";


  public Truck(String type, String model, int mpg){
    super(type, model, mpg);
    this.numWheels = 4;
    this.canfly = false;
  }

  public static Truck read(Scanner sc){
    return new Truck("truck", sc.next(), sc.nextInt());
  }

  public String toString() {
    return super.toString() + " " + noise + " does not fly with " + numWheels + " wheels.";  
  }


}
