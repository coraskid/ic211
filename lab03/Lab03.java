import java.util.*;

public class Lab03{
//private Box B;
//private void nextCmd(Scanner in){
//  String cmd = in.next();
//  System.out.println(cmd);
//  while(!cmd.equals("done!")){
//  if(cmd.equals("add")){
//      Point k = Point.read(in);
//      this.growBy(k);    
//    }
//  }
//  System.out.println(this.toString());
//}


  public static void main(String[] args){
    //Point l = new Point(3,4);
    Point f = new Point(4,3);
    //Hi = new Box(f);
    //Hi.growBy(f);
    //if(K == null){
    //  System.out.println("hii");
    //}
    //System.out.println(Hi.toString());
    //K.growBy(f);
    //System.out.println(K.toString());
   

    Scanner in = new Scanner(System.in);
    String command = in.next();

    boolean boxCreated = false;
    //var B;
    //if (Lab03.B == null){
    //  System.out.println("PLEASE");
    //}
    //System.out.println(B.toString());
    while (!command.equals("done")){
      if(command.equals("add")){
        //Point p = Point.read(in);
        //Box B = new Box(p);
        //else if(B==null){
          //System.out.println("no")
          //B.growBy(p);
        //}
        System.out.println("add");
        break;
      }
      else if(command.equals("box") || command.equals("map")){
        System.out.println("Error, add point first");
        //B.growBy(q);
      }
      else {
        System.out.println("Error! Unknown command \"" + command + "\"!");
      }

      System.out.println(command);
      command = in.next();
    }
    Point p = Point.read(in);
    Box B = new Box(p);
    //B.nextCmd(in);
    System.out.println("OUt?");
    System.out.println(B.toString());

    command = in.next();
    System.out.println(command);
    while(!command.equals("done!")){
      if(command.equals("add")){
        B.add(in);
        //Point k = Point.read(in);
        //B.growBy(k);   
        System.out.println(B.toString());
      }
      command = in.next();
    }
    System.out.println(B.toString());
    

  }
}
