import java.util.*;
/**
 * This class runs basic hash operations
 * @author Cora Skidmore
 */
public class TestHashers {
  public static void main(String[] args) throws Throwable {
    Hash H = new Hash();

    //ask for algorithm and password
    System.out.print("algorithm: ");
    String hashEncalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    
    //set up and compute hash
    H.setName(hashEncalg);
    String hash = H.hash(password);
    
    //print out password and computed hash
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed : " + hash);
  }
}
