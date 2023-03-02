import java.util.*;
import java.io.*;
public class Lab07 {


  private static Record read(String[] line){
    Record n = new Record(line);
    return n;



  }



  public static void main(String[] args){
    int len = 0;
    
    Random rand;
    if( args.length == 3 )
      rand = new Random(Long.parseLong(args[2]));
    else
      rand = new Random(System.currentTimeMillis());

    Scanner sc = null;
    try{
      sc = new Scanner(new File(args[0]));
      len = FileLineCounter.countLines(args[0]);
      // put the call to file line counter 
      // in this scope as well
    }catch(Exception e){
      e.printStackTrace();
      System.exit(1);
    }
    
    Record[] arr = new Record[len];
    for(int i = 0; i < len; i++){
      String nextl = sc.nextLine(); 
      String[] nextlA = nextl.split(" ");
      arr[i] = read(nextlA);
    }

    for(int i = 0; i < len; i++){
      System.out.println(arr[i]);
    }

  }




}
