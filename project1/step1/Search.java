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
   */
  private static Tweet[] readfile(String path){
    Scanner fin = null;
    try {
      fin = new Scanner(new FileReader(path));
    } catch(IOException e) {
      e.printStackTrace(); System.exit(1);
    }

    Tweet[] arr = new Tweet[33];
    for(int i = 0; i < 33; i++){
      String text = fin.nextLine();
      String[] parts = text.split("\t");
      arr[i] = new Tweet(parts[0], parts[1], parts[2]);
    }
    return arr;
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
    Tweet[] arr = readfile(args[0]);
    System.out.println("Array size: " + arr.length);
    for(int i = 0; i < 33; i++){
      System.out.println(arr[i].toString());
    }

    //System.out.println(args.length);



  }
}
