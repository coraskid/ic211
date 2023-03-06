import java.util.*;
import java.io.*;
public class Lab07 {


  private static Record read(String[] line){
    Record n;
    //if(line[5].equals("prob"))
      //n = makeRecordP(line);
    //else
      n = Record.makeRecord(line);
    return n;
  }



  public static void main(String[] args){
    int len = 0;
    MyDate begin = MyDate.makeDate(2017, 1, 1);
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
    /*
    for(int i = 0; i < len; i++){
      System.out.println(arr[i]);
    }*/

    //arr[0].today(arr[4].getDate());
    MyDate curDay = begin;
    int totalDays = Integer.parseInt(args[1]);
    for(int i = 0; i < totalDays; i++){
      Record[] today = new Record[len];
      int ti = 0;
      for(int j = 0; j < len; j++, ti++){
        if(arr[j].today(curDay))
          today[ti] = arr[j];
        else
          ti--;
      }
      if(today[0] != null){
        System.out.print(curDay + ": ");
        for(int k = 0; k < ti; k++){
          if(k != 0)
            System.out.print(", ");
          System.out.print(today[k]);
        }
        System.out.print("\n");
      }
      curDay.incDay(1);
    }

  }




}
