public class Truck extends Vehicle {

  // constructor
  public Truck(String type, String model, int mpg) {
    super(type, model, mpg);
  }

  public String noise() {
      return "bumbumbum";
  }

}
