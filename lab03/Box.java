import java.util.*;

public class Box {
  //private Point[] arr;
  private double xmin, xmax, ymin, ymax;

  public Box(Point a){
    this.xmin = a.getx();
    this.xmax = a.getx();
    this.ymin = a.gety();
    this.ymax = a.gety();
  }

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

  public Point mapIntoUnitSquare(Point p){
    //System.out.println(p.getx() + " " + p.gety());
    //System.out.println(this.toString());
    if (p.getx() > this.xmax || p.getx() < this.xmin || p.gety() > this.ymax || p.gety() < this.ymin){
      return null;
    }

    double x = (p.getx() - this.xmin) / (this.xmax - this.xmin);
    double y = (p.gety() - this.ymin) / (this.ymax - this.ymin);

    Point l = new Point(x, y);
    return l;
  }

  public String toString(){
    return (this.xmin + " < x < " + this.xmax + ", " + this.ymin + " < y < " + this.ymax);

  }

  public void add(Scanner in){
    Point p = Point.read(in);
    this.growBy(p);
    //System.out.println("this is box add");
  }

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
    if (b.mapIntoUnitSquare(j) == null){ ///HOW TO DEAL WITH NULL
      System.out.println("error2");
    }
    Point k = b.mapIntoUnitSquare(j);
    //if (k.getx() == null){
      //System.out.print("error");
    //}
    //System.out.println(k.getx() + " " + k.gety());
    //System.out.println(k.toString());
    //System.out.println(Point.mapIntoUnitSquare(j).toString());
  }
}
