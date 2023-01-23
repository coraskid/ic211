import java.io.*;
import java.util.*;

public class WordRead {
  public static String[] get(String fname){
    //turns an text file and turns it into an array of strings 
    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(fname));
    } catch(IOException e) {
      e.printStackTrace(); System.exit(1);
    }
    StringNode L = null;
    while (sc.hasNext()){
      L = ListStuff.addToFront(sc.next(), L);     
    }
    String arr[] = ListStuff.listToArray(L);
    String arr2[] = new String[arr.length];
    for(int i = 0; i < arr.length; i++){
      arr2[i] = arr[arr.length - i - 1];
    }
    return arr2;
  }

  public static void main(String[] args){
    //tests function in WordRead.java
    String arr[] = get("nouns.txt");
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
