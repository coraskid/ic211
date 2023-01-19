import java.util.*;

public class Mid {
  public String alpha;
  public String firstName;
  public String lastName;
  public int company;

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
    Mid A = createMid(in);
    printMid(A);

  }
}
