import java.util.*;

public class Lab03{




  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String command = in.next();
    boolean boxCreated = false;
    while (!command.equals("done")){
      if(command.equals("add")){
        Point p = new Point(in);
        if(!boxCreated){
          Box B = new Box(p);
          boxCreated = true;
        }
        else{
          B.growBy(p);
        }
        System.out.println("add");
      }
      else if(command.equals("box")){
        System.out.println(B.toString());
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
