import java.util.*;
/**
 * This class manipulates and prints boxes and maps points with in boxes
 * It can handle 4 different commands
 * add - adds a point to the box (must be followed by two doubles/ints)
 * box - prints out the min and max representation of the box
 * map - maps the ratio of a given point and prints the ratios x and y value
 *     - (must be followed by two doubles/ints)
 * done - exit out of the program
 * @author cora skidmore
 */
public class Lab03{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String command = in.next();
    //Checks for first add statement to create box without scope errors
    //Now understand how to initialize as null
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
    //creates box
    Point p = Point.read(in);
    Box B = new Box(p);
    command = in.next();
    //continues with any other function inputed into the system
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
