import java.util.*;

public class Lab03{
  private Box Hi;

  private void add(Scanner in){
        


  }


  public static void main(String[] args){
    //Point l = new Point(3,4);
    Point f = new Point(4,3);
    //Hi = new Box(f);
    //Hi.growBy(f);
    //if(K == null){
    //  System.out.println("hii");
    //}
    System.out.println(Hi.toString());
    //K.growBy(f);
    //System.out.println(K.toString());
   

    Scanner in = new Scanner(System.in);
    String command = in.next();
    boolean boxCreated = false;
    //Box B = new Box;
    //System.out.println(B.toString());
    while (!command.equals("done")){
      if(command.equals("add") && !boxCreated){
        
        Point p = Point.read(in);
        //B = new Box(p);
        //if(!boxCreated){
        //  B = new Box(p);
        //  boxCreated = true;
        //}
        //else{
        //  //B.growBy(p);
        //}
        System.out.println("add");
      }
      else if(command.equals("add")){
        Point q = Point.read(in);
        //B.growBy(q);
      }
      else if(command.equals("box")){
        if(!boxCreated){
          //System.out.println(B.toString());
        }
        System.out.println("box");
      }
      else if(command.equals("map")){
        
        System.out.println("mpa");
      }
      else {
        System.out.println("Error! Unknown command \"" + command + "\"!");
      }

      System.out.println(command);
      command = in.next();
    }

  }
}
