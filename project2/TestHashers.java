import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws Throwable {

    ArrayList<Hash> H = new ArrayList<Hash>();
    H.add(new ShiftCaesar());


    System.out.print("algorithm: ");
    String encalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    

    int i = -1;
    try {
      while( !H.get(++i).getAlgName().equals(encalg) );
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg + "'.");
    }

    
    String hash = H.get(i).hash(password);
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed : " + hash);
  }
}
