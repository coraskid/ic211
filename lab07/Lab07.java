import java.util.*;
import java.io.*;
/**
 * Lab07 impliments Record class and child classes to process a finance txt file
 * and turn it into a day by day financial event output
 * @author Cora Skidmore
 */


public class Lab07 {
  

  private static Record read(String[] line, Random r){
    Record n;
    if(line[3].equals("for"))
      n = RecordEnd.makeRecordEnd(line);
    else if(line[5].equals("prob"))
      n = RecordP.makeRecordP(line, r);
    else
      n = Record.makeRecord(line);
    return n;
  }



  public static void main(String[] args){
    if(args.length < 2){
      System.out.println("usage: java Lab07 <infilename> <numDays>");
      return;
    }
    //code from 211 website
    Random rand;
    if( args.length == 3 )
      rand = new Random(Long.parseLong(args[2]));
    else
      rand = new Random(System.currentTimeMillis());
    int len = 0;
    MyDate begin = MyDate.makeDate(2017, 1, 1); 
    Scanner sc = null;
    try{
      sc = new Scanner(new File(args[0]));
      len = FileLineCounter.countLines(args[0]);
    }catch(Exception e){
      e.printStackTrace();
      System.exit(1);
    }
    //Read in arr with all of the records from the file
    Record[] arr = new Record[len];
    for(int i = 0; i < len; i++){
      String nextl = sc.nextLine(); 
      String[] nextlA = nextl.split(" ");
      arr[i] = read(nextlA, rand);
    }
    
    //Run through all of the days and check if any happen today and print those
    //events
    MyDate curDay = begin.clone();
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
