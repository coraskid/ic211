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
    try {
      fin = new Scanner(new FileReader(path));
    } catch(IOException e) {
      e.printStackTrace(); System.exit(1);
    }

    Queue Q = new Queue();
    int i = 0;
    while(fin.hasNextLine()){
      String text = fin.nextLine();
      i++;
      String[] parts = text.split("\t");
      Q.enqueue(new Tweet(parts[0], parts[1], parts[2]));
    }

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
    
    Queue Q = readfile(args[0]);
    System.out.println("Queue size: " + Q.length());
    Queue M = Q.copy();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("? ");
    String cmd = sc.next();
    while(!cmd.equals("!quit")){
      if(cmd.equals("!dump")){
        M.printall();
      }
      else{
        M = M.filterForKeyword(cmd);
      }
      System.out.println("Queue size: " + M.length());
      System.out.print("? ");
      cmd = sc.next();
    }

    System.out.println("Goodbye!");

  }
}

