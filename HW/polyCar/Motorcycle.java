import java.util.*;
public class Motorcycle extends Vehicle {
  private int numWheels;
  private boolean canfly;
  private String noise = "errrrm";


  public Motorcycle(String type, String model, int mpg){
    super(type, model, mpg);
    this.numWheels = 2;
    this.canfly = false;
  }

  public static Motorcycle read(Scanner sc){
    return new Motorcycle("motorcycle", sc.next(), sc.nextInt());
  }

  public String toString() {
    return super.toString() + " " + noise + " does not fly with " + numWheels + " wheels.";  
  }


}
