import java.util.*;
import java.io.*;
/**
 * The Search class currently has the ability to just read in a list of 33
 * tweets from a file
 * @author Cora Skidmore
 */
public class Search{

  /**
   * This method reads in a bunch of tweets from a file and returns them in an
   * array of tweets
   * @param path String representation of the file
   * @return Queue containing all of the tweets just read in
   */
  private static Queue readfile(String path){
    Scanner fin = null;
    System.out.println("please print");
    try {
      fin = new Scanner(new FileReader(path));
    } catch(IOException e) {
      e.printStackTrace(); System.exit(1);
    }

    System.out.println("please print2");
    Queue Q = new Queue();
    int i = 0;
    while(fin.hasNextLine()){
      String text = fin.nextLine();
      System.out.println(i);
      i++;
      String[] parts = text.split("\t");
      Q.enqueue(new Tweet(parts[0], parts[1], parts[2]));
    }
    System.out.println("pleas9e print");

    return Q;

  }



  /**
   * Mains current funciton is to take in a file and output the tweets
   * @param args needs a file name to work
   */
  public static void main(String[] args){
    if (args.length == 0){
      System.out.println("usage: java Search <tweets-file>");
      return;
    }
    
    System.out.println("please 3print");
    Queue Q = readfile(args[0]);
    System.out.println("please2 print");
    System.out.println("Queue size: " + Q.length());
    Queue M = Q.copy();
    System.out.println("please4 print");
    //M.printall();
    //Q.printall();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("? ");
    String cmd = sc.next();
    while(!cmd.equals("!quit")){
      if(cmd.equals("!dump")){
      System.out.println("please while print");
        M.printall();
      }
      else{
        M = M.filterForKeyword(cmd);
      }
      System.out.println("Queue size: " + M.length());
      System.out.print("? ");
      cmd = sc.next();
    }

  }
}
