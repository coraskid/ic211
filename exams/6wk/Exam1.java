import java.util.*;


public class Exam1{


  



  public static void main(String[] args){
    int len = (args.length)/4;
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

  }

}
