import java.util.*;

public class Lab1c {
  public static void main(String[] args){
    Random rand = new Random(42);
    Scanner in = new Scanner(System.in);
    int n = rand.nextInt(11);
    //System.out.print("Guess a number between 0 and 10: ");
    int g = in.nextInt();
    int cnt = 1;
    while(g != n){
      cnt ++;
      //
      //if (cnt < 4)
      //  System.out.print("Nope. ");
      //else if (cnt < 6)
      //  System.out.print("Seriously? ");
      //else if (cnt < 9)
      //  System.out.print("How are you still wrong? ");
      //else
      //  System.out.print("Are you even trying? ");
      
      //System.out.print("Guess again: ");
      g = in.nextInt();
    }
    System.out.println("Right after " + cnt + " guesses!");
  }
}

