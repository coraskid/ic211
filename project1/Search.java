import java.util.*;
import java.io.*;

public class Search{


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
