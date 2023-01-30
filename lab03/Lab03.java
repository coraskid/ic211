import java.util.*;

public class Lab03{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String command = in.next();
    while (!command.equals("done")){
      if(command.equals("add")){
                break;
      }
      else if(command.equals("box") || command.equals("map")){
        System.out.println("Error, add point first");
      }
      else {
        System.out.println("Error! Unknown command \"" + command + "\"!");
      }
      command = in.next();
    }
    if(command.equals("done")){
      return;
    }
    Point p = Point.read(in);
    Box B = new Box(p);
    command = in.next();
    while(!command.equals("done")){
      if(command.equals("add")){
        B.add(in);
      }
      else if(command.equals("box")){
        System.out.println(B.toString());
      }
      else if(command.equals("map")){
        B.map(in);
      }
      else{
        System.out.println("Error! Unknown command \"" + command + "\"!");
      }
      command = in.next();
    }
  }
}
