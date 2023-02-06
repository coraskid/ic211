import java.util.*;
/**
 * The Box class creates a representation of a box around all points in the box,
 * the ability to add points and therefor expand the box and map points within
 * the box
 * @author cora skidmore
 */
public class Box {
  private double xmin, xmax, ymin, ymax;
  /**
   * Constructor
   * Will define both x and y's mins and maxes appropriatly
   * @param a Initial point to define the box
   */
  public Box(Point a){
    this.xmin = a.getx();
    this.xmax = a.getx();
    this.ymin = a.gety();
    this.ymax = a.gety();
  }
  /**
   * Constructor
   * Will define both x and y's mins and maxes appropriatly
   * @param a 1 of 2 initial points to define the box
   * @param b 2 of 2 initial points to define the box
   */
  public Box(Point a, Point b){
    if(a.getx() == b.getx()){
      this.xmin = a.getx();
      this.xmax = a.getx();
    }else if(a.getx() > b.getx()){
      this.xmin = b.getx();
      this.xmax = a.getx();
    }else {
      this.xmin = a.getx();
      this.xmax = b.getx();
    }
    
    if(a.gety() == b.gety()){
      this.ymin = b.gety();
      this.ymax = b.gety();
    }else if(a.gety() > b.gety()){
      this.ymin = b.gety();
      this.ymax = a.gety();
    }else {
      this.ymin = a.gety();
      this.ymax = b.gety();
    }
  }
  /**
   * Adds a point to the box and adjusts both x and y mins and maxes
   * appropriatly
   * @param p Point added to the box
   */
  public void growBy(Point p){
    if(p.getx() > this.xmax)
      this.xmax = p.getx();
    if(p.getx() < this.xmin)
      this.xmin = p.getx();
    if(p.gety() > this.ymax)
      this.ymax = p.gety();
    if(p.gety() < this.ymin)
      this.ymin = p.gety();
  }
  /**
   * Maps a point in the box and gives you the relivant ratios the point is
   * in comparison to the box
   * @param p point you want to map into the box
   * @return A point where the x and y value are the ratio of the given point
   * with respect to the box
   * @return Will return null is point p is not with in the box
   */
  public Point mapIntoUnitSquare(Point p){
    if (p.getx() > this.xmax || p.getx() < this.xmin || 
        p.gety() > this.ymax || p.gety() < this.ymin){
      return null;
    }
    double x = (p.getx() - this.xmin) / (this.xmax - this.xmin);
    double y = (p.gety() - this.ymin) / (this.ymax - this.ymin);
    Point l = new Point(x, y);
    return l;
  }
  /**
   * Represents the box in a string
   * @return A string representation of the min and max values of the box
   */
  public String toString(){
    return (this.xmin + " < x < " + this.xmax + ", " + this.ymin + " < y < " + this.ymax);
  }
  /**
   * Adds a point to the instance Box based on input from a scanner
   * @param in Scanner where two doubles will be read in
   */
  public void add(Scanner in){
    Point p = Point.read(in);
    this.growBy(p);
  }
  /**
   * Maps a point to the instance box based on input from a scanner
   * Will print 'error' if inputed point is not within box bounds
   * @param in Scanner where two doubles will be read in
   */
  public void map(Scanner in){
    Point p = Point.read(in);
    Point k = this.mapIntoUnitSquare(p);
    if(k == null){
      System.out.println("error");
    }
    else{
      System.out.println(k.toString());
    }
  }

  public static void main(String[] args){
    Point p = new Point(1,2);
    Point q = new Point(4,7);
    Box a = new Box(p);
    Box b = new Box(p, q);
    a.growBy(q);
    System.out.println(a.toString());
    Point j = new Point(3, 18);
    if (b.mapIntoUnitSquare(j) == null){ 
      System.out.println("error2");
    }
    Point k = b.mapIntoUnitSquare(j);
  }
}
