import java.util.*;

public class Point{
  private double x, y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public static Point read(Scanner sc){
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    Point p = new Point(x,y);
    return p;
  }

  private void print(){
    System.out.println("("+this.x+","+this.y+")");
  }
    
  public String toString(){    
    return (this.x + " " + this.y);
  }

  public double getx(){
    return this.x;
  }
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
