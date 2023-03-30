import java.util.*;
import java.io.*;

public class Vault {
  
  private class userInfo {
    private String user;
    private String encalg;
    private String hash;
    private Hash hashObj;
    public userInfo(String u, String e, String h){
      user = u;
      hash = h;
      hashObj = new Hash();
      hashObj.setName(e);
      encalg = hashObj.getEncalgName();
    }
    public boolean userEquals(String u){
      return this.user.equals(u);
    }
    public boolean hashEquals(String h){
      return this.hash.equals(h);
    }
    public String toString(){
      return user + " using " + encalg + " is " + hash;
    }
    protected Hash getHash(){
      return hashObj;
    }
    public String getAlgName(){
      return encalg;
    }
  }
  
  private ArrayList<userInfo> data = new ArrayList<userInfo>();

  private void readData(String filen){
    Scanner sc = null;

    try{
      sc = new Scanner(new File(filen));
    } catch(Exception e) {
      System.out.println("Error! File '" + filen + "' could not be opened.");
      System.exit(1);
    }

    while(sc.hasNextLine()){
      String[] line = sc.nextLine().split(" ");
      //could do a try except with seperate func if needed
      if(line.length != 4 || !line[0].equals("user")){
        System.out.println("Error! File '" + filen + "' improperly formatted.");
        System.exit(1);
      }
      userInfo cur = new userInfo(line[1], line[2], line[3]);
      this.data.add(cur);
    }

  }


  public static void main(String[] args) {
    //no command line arguement
    if(args.length == 0){
      System.out.println("usage: java Vault <filename>");
      System.exit(1);
    }
    Vault V = new Vault();
    V.readData(args[0]);
    Scanner in = new Scanner(System.in);
    /*
    for(userInfo i : V.data){
      System.out.println(i);
    }
    System.out.println();
    */
    System.out.print("username: ");
    String usern = System.console().readLine();
    System.out.print("password: ");
    char[] pswd = System.console().readPassword();
    
    int i = -1;
    try {
      while (!V.data.get(++i).userEquals(usern) );
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Access denied!");
      System.exit(1);
    }
    String newHash = null;
    try {
      newHash = V.data.get(i).getHash().hash(pswd);
    } catch (NoSuchElementException nsee){
      System.out.println("Error! Hash algorithm '" + V.data.get(i).getAlgName() + "' not supported.");
      System.exit(1);
    } catch (Exception e) {
      System.out.println("Access denied!");
      System.exit(1);
    }
    
    if(!V.data.get(i).hashEquals(newHash)){
      System.out.println("Access denied!");
      System.exit(1);
    }

    System.out.println("Access granted!");
    do{
      System.out.print("> ");
    } while(!in.next().equals("quit"));



      





  }
}
