import java.util.*;
public class HW09 {
  public static void main(String[] args) {
    boolean verbose = args.length > 0 && args[0].equals("-v");
    Scanner sc      = new Scanner(System.in);

    if (verbose) {
      System.out.print("Enter x, k, m: ");
    }
    int x, k, m, r;
    try{
      x = sc.nextInt();
      k = sc.nextInt();
      if(k < 0){
        throw new Exception();
      }
      m = sc.nextInt();
      r = MyMath.modexp(x, k, m);
    } catch(Exception e){
      if( verbose )
        System.out.println("Error in HW09! invalid input.");
      System.exit(1);
    } 
    if (verbose) {
      System.out.print(x + "^" + k + " % " + m + " = ");
    }
    System.out.println(r);
  }
}
