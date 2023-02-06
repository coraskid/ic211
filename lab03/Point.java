import java.util.*;
/**
 * The point class defines a point and various useful methods that come with it
 * @author cora skidmore
 */
public class Point{
  private double x, y;
  /**
   * Constructor
   * @param x Type double, x value associated with the point
   * @param y Type double, y value associated with the point
   */
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  /**
   * Creates a new point object given input to a scanner
   * @param sc The scanner used to read in the point
   * @return A Point which data members is based on input to scanner
   */
  public static Point read(Scanner sc){
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    Point p = new Point(x,y);
    return p;
  }
  /**
   * Prints x and y value of the instance point
   * Mainly used for inclass debugging
   * No arguements and no returns
   */
  private void print(){
    System.out.println("("+this.x+","+this.y+")");
  }
  /**
   * Represents the points x and y value as a string
   * @return A string that includes the point's x and y value seperated by a
   * space 
   */
  public String toString(){    
    return (this.x + " " + this.y);
  }
  /**
   * Getter for a point's x value
   * @return Double that equals the point's x value
   */
  public double getx(){
    return this.x;
  }
  /**
   * Getter for a point's y value
   * @return Double that equals the point's y value
   */
  public double gety(){
    return this.y;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    Point p = read(in);
    p.print();
    System.out.println(p.toString());
  }
}
