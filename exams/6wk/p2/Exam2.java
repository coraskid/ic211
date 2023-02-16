import java.util.*;
import java.io.*;

public class Exam2{


  



  public static void main(String[] args){
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(args[0]));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    } 
    Queue n = new Queue();

    while(sc.hasNextInt()){
      Midshipman temp = new Midshipman(sc);
      temp.print();
      System.out.print("\n");
      n.enqueue(temp);
    }
    System.out.println("Now the matchups!!!");
    while (!(n.empty())){
      Midshipman m1 = n.dequeue();
      Midshipman m2 = n.dequeue();
      m1.print();
      System.out.print(" VS ");
      m2.print();
      System.out.print("\nWinner: ");
      if(m1.willBeat(m2))
        m1.print();
      else
        m2.print();
      System.out.print("\n");
    }


    //Midshipman test = n.dequeue();
    //test.print();



    /*int len = (args.length)/4;
    Midshipman[] arr = new Midshipman[len];

    for(int i = 0; i < len; i++){
      double sp = Double.parseDouble(args[4*i + 0]);
      double st = Double.parseDouble(args[4*i + 1]);
      double in = Double.parseDouble(args[4*i + 2]);
      double hr = Double.parseDouble(args[4*i + 3]);
      arr[i] = new Midshipman(sp, st, in, hr);
    }
    
    Midshipman best = arr[0];
    for(int i = 0; i < len; i++){
      if(arr[i].willBeat(best)){
        best = arr[i];
      }
    }
    System.out.print("Best Boxer: ");
    best.print();
    */
  }

}
