import java.util.*;
public class HW3{

  public static Mid createMid(Scanner in){
    Mid A = new Mid();
    System.out.print("Alpha? ");
    A.alpha = in.next();
    System.out.print("First name? ");
    A.firstName = in.next();
    System.out.print("Last name? ");
    A.lastName = in.next();
    System.out.print("Company? ");
    A.company = in.nextInt();
    return A;
  }

  public static void printMid(Mid A){
    System.out.println(A.alpha + " " + A.lastName + " " + A.firstName + " " + A.company);
    return;
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("How many mids? ");
    int n = in.nextInt();
    Mid[] A = new Mid[n];
    for(int i = 0; i < n; i++){
      A[i] = createMid(in);
    }
    System.out.print("What company would you like to print out? ");
    int c = in.nextInt();
    for(int i = 0; i < n; i++){
      if(A[i].company == c)
        printMid(A[i]);
    }
  }

}

