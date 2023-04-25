public class Plane extends Vehicle {

    // constructor
    public Plane(String type, String model, int mpg) {
        super(type, model, mpg);
        numWheels = 3;
        canfly = true; 
    }

    public String noise() {
        return "woooosh";
    }

}
