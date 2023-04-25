public class Vehicle {

    // fields
    private String type;
    private String model;
    private int mpg;
    protected int numWheels;
    protected boolean canfly;

    // constructor
    public Vehicle(String type, String model, int mpg) {
        this.type = type;
        this.model = model;
        this.mpg = mpg;
        this.canfly = false;
        this.numWheels = 4;
    }

    public boolean doesItFly() { return canfly; }

    public String noise() {
        return "hmmmm";
    }

    public String toString() {
        return model + " " + noise() + " does" + 
              (doesItFly() ? "" : " not") + " fly with " + 
              numWheels + " wheels.";
    }
}
