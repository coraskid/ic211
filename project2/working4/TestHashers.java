import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws Throwable {

    /*ArrayList<Encryptor> E = new ArrayList<Encryptor>();
    E.add(new Clear());
    E.add(new Caesar());
    E.add(new Vigenere()); */
    Hash H = new Hash();

    System.out.print("algorithm: ");
    String hashEncalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    H.setName(hashEncalg);
    String encalg = H.getEncalgName(); //DONT THINK I NEED THIS LINE
    /*int i = -1;
    try {
      while( !E.get(++i).getAlgName().equals(encalg) );
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg + "'.");
    }
    H.E = E.get(i);
    */
    //H.setEncryptor();
    String hash = H.hash(password);
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed : " + hash);
  }
}
