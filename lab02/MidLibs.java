import java.util.*;
public class MidLibs{
  public static String[] replace(String[] A, String[] n, String[] adj, String[] v){
    Random rand = new Random(890);
    for(int i = 0; i < A.length; i++){
      if(A[i].charAt(0) == '@'){
        if (A[i].charAt(1) == 'n' && A.length == 5)
          System.out.print("Hi");
      }
    }
    return A;

  }

  public static void main(String args[]){
    Random rand = new Random(890);
    if (args.length == 0){
      System.out.println("usage: java MidLibs <filename>");
      System.exit(1);
    }
    String arr[] = WordRead.get(args[0]);
    
    String noun[] = WordRead.get("nouns.txt");
    String adj[] = WordRead.get("adjectives.txt");
    String verb[] = WordRead.get("verbs.txt");
    arr = replace(arr, noun, adj, verb);


    Formatter.writeInColumns(arr, 35);


  }


}
