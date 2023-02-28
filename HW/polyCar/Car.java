public class Car extends Vehicle {
  private int numWheels;
  private boolean canfly;
  private String noise = "vroom";


  public Car(String type, String model, int mpg){
    super(type, model, mpg);
    this.numWheels = 4;
    this.canfly = false;
  }

  public static Car read(Scanner sc){
    return new Car("car", sc.next(), sc.next())
  }

  public String toString() {
    return super.toString() + " " + noise + " does not fly with " + numWheels + " wheels.";  
  }


}
