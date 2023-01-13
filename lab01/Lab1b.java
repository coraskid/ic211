import java.util.*;

public class Lab1b {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = in.nextLine();
    System.out.print("Please input an integer: ");
    int n = in.nextInt();
    System.out.print("Please input a second integer: ");
    int k = in.nextInt();
    System.out.println("The two ints were " + n + " and " + k);
    
    int num = 1;
    for(int i = 0; i < k; i++){
      num *= (n - i);
    }
    System.out.println("numerator = " + num);
    int den = 1;
    for(int i = 1; i <= k; i++){
      den *= i;
    }
    System.out.println("denominator = " + den);
    int odd = num/den;
    System.out.println("odds = 1 in " + odd + " = " + 1/(double)odd);
    System.out.println("Goodbye " + name + ".");

  }
}

