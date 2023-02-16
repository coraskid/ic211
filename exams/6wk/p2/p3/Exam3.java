import java.util.*;
import java.io.*;

public class Exam3{


  



  public static void main(String[] args){
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(args[0]));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    Random rand = new Random(Integer.parseInt(args[1]));

    Queue n = new Queue();

    while(sc.hasNextInt()){
      Midshipman temp = new Midshipman(sc);
      temp.print();
      System.out.print("\n");
      n.enqueue(temp);
    }
    System.out.println("Now the matchups!!!");
    Queue R2 = new Queue();
    while((R2.empty())){

      while (!(n.empty())){
        Midshipman m1 = n.dequeue();
        Midshipman m2 = n.dequeue();
        m1.print();
        System.out.print(" VS ");
        m2.print();
        System.out.print("\nWinner: ");
        if(m1.willBeat(m2, rand)){
          m1.print();
          R2.enqueue(m1);
        }
        else {
          m2.print();
          R2.enqueue(m2);
        }
        System.out.print("\n");
      }
      
      //R2 and n have next round Queue
      n = R2;

      if(R2.one()){
        System.out.print("The Brigade champion is: ");
        Midshipman winner = R2.dequeue();
        winner.print();
        System.out.print("\n");
        break;
      }
      /*
      else
        System.out.print("FALSE");
      /*Midshipman top = R2.dequeue();
      if (R2.empty()){
        top.print();
        break;
      }*/
      R2 = new Queue(); 

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
