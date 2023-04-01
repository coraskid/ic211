import java.util.*;
import java.io.*;

public class Vault {
 /* 
  private class UserInfo {
    private String user;
    private String encalg;
    private String hash;
    private Hash hashObj;
    
    public UserInfo(String u, String e, char[] p){
      user = u;
      hashObj = new Hash();
      hashObj.setName(e);
      encalg = hashObj.getEncalgName();
      hash = hashObj.hash(p);
    }
    public UserInfo(String u, String e, String h){
      user = u;
      hash = h;
      hashObj = new Hash();
      hashObj.setName(e);
      encalg = hashObj.getEncalgName();
    }
    
    public static UserInfo addUserInfo(String u, String e, char[] p){
      //UserInfo nui = new UserInfo(u, e);
      //nui.hash = nui.hashObj.hash(p);
      return new UserInfo(u, e, p);
    }
    public boolean userEquals(String u){
      return this.user.equals(u);
    }
    public boolean hashEquals(String h){
      return this.hash.equals(h);
    }
    public String toString(){
      return "user " + user + " " + encalg + " " + hash;
    }
    protected Hash getHash(){
      return hashObj;
    }
    public String getAlgName(){
      return encalg;
    }
  }
  */
  private ArrayList<UserInfo> data = new ArrayList<UserInfo>();

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
      UserInfo cur = new UserInfo(line[1], line[2], line[3]);
      this.data.add(cur);
    }

  }

  public void verify(char[] pswd, String usern, Scanner in) {
     
    //Scanner in = new Scanner(System.in);
    int i = -1;
    try {
      while (!this.data.get(++i).userEquals(usern) );
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Access denied!");
      System.exit(1);
    }
    String newHash = null;
    try {
      newHash = this.data.get(i).getHash().hash(pswd);
    } catch (NoSuchElementException nsee){
      System.out.println("Error! Hash algorithm '" + this.data.get(i).getAlgName() + "' not supported.");
      System.exit(1);
    } catch (Exception e) {
      System.out.println("Access denied!");
      System.exit(1);
    }
    
    if(!this.data.get(i).hashEquals(newHash)){
      System.out.println("Access denied!");
      System.exit(1);
    }

    System.out.println("Access granted!");
    /*
    do{
      System.out.print("> ");
    } while(!in.next().equals("quit"));
    */
  }

  public void addUser(String filen, String u, char[] p){
    System.out.print("Hash algorithm: ");
    String hashAlg = System.console().readLine();
    for(UserInfo i : this.data){
      if(i.userEquals(u)){
        System.out.println("Error! Username '" + u + "' already in use.");
        System.exit(1);
      }
    }



    UserInfo N = null;
    try {
      N = UserInfo.addUserInfo(u, hashAlg, p);
    } catch (InvalidInputException iie) {
      System.out.println("Error! " + iie.getMessage() + "." );//GET CHAR
      //System.out.println(iie.getMessage());
      //iie.printStackTrace();
      System.exit(1);
    } catch (NoSuchElementException nsee) {
      System.out.println(nsee.getMessage());
      System.exit(1);
    }
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(new BufferedWriter(new FileWriter(filen, true)));
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.print("not sure what to do here?");
      System.exit(1);
    }
    pw.print(N.toString());

    if (pw != null) pw.close();


  }

  public static void main(String[] args) {
    //no command line arguement or invalid tac option
    if(args.length == 0 || (args.length == 2 && !args[0].equals("-au"))){
      System.out.println("usage: java Vault [-au] <filename>");
      System.exit(1);
    }

    System.out.print("username: ");
    String usern = System.console().readLine();
    System.out.print("password: ");
    char[] pswd = System.console().readPassword();

    Vault V = new Vault();
    if(args.length == 2){
      V.readData(args[1]);
      V.addUser(args[1], usern, pswd);
      System.exit(1);
    }


    V.readData(args[0]);
    Scanner in = new Scanner(System.in);
    

    
    V.verify(pswd, usern, in);
    do{
      System.out.print("> ");
    } while(!in.next().equals("quit"));



     

   
 
    



  }
}
