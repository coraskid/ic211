import java.util.*;
import java.io.*;

public class Vault {

  private ArrayList<UserInfo> data = new ArrayList<UserInfo>();
  private ArrayList<DataInfo> dataS = new ArrayList<DataInfo>();
  private int totalData;
  /**
   * Read data from a file into data (for users) and dataS (for data)
   * @param filen file name
   */
  private void readData(String filen){
    //set up scanner with filen as filename
    Scanner sc = null;
    try{
      sc = new Scanner(new File(filen));
    } catch(Exception e) {
      System.out.println("Error! File '" + filen + "' could not be opened.");
      System.exit(1);
    }
    
    //read each line of file and add it to this instances data ArrayList
    int count = 0;
    while(sc.hasNextLine()){
      String[] line = sc.nextLine().split(" ");
      //could do a try except with seperate func if needed
      if(line.length != 4 || !(line[0].equals("user") || line[0].equals("data"))){
        System.out.println("Error! File '" + filen + "' improperly formatted.");
        System.exit(1);
      }
      //read in a user and add it to data
      if(line[0].equals("user")){
        UserInfo cur = new UserInfo(line[1], line[2], line[3], count);
        this.data.add(cur);
      }
      //read in a data and add it to dataS
      if(line[0].equals("data")){
        DataInfo cur = new DataInfo(line[1], line[2], line[3], count);
        this.dataS.add(cur);
      }
      count++;
    }
    totalData = count;
  }
  /**
   * verify a user, will print out access denied and quit the program or print
   * out access granted and continue
   * @param pswd password
   * @param usern username
   * @param in Scanner for system.in
   */
  public void verify(char[] pswd, String usern, Scanner in) {
    //Find the correct userInfo object in data 
    int i = -1;
    try {
      while (!this.data.get(++i).userEquals(usern) );
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Access denied!");
      System.exit(1);
    }
    //create a new hash Object for the user to calculated their inputted
    //password
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
    //checks if computed hash and stored hash are equal
    if(!this.data.get(i).hashEquals(newHash)){
      System.out.println("Access denied!");
      System.exit(1);
    }
    System.out.println("Access granted!");
  }
  /**
   * This method adds a user to the file based on user input to the terminal
   * @param filen filename
   * @param u username
   * @param p password
   */
  public void addUser(String filen, String u, char[] p){
    //ask and get hash algorithm
    System.out.print("Hash algorithm: ");
    String hashAlg = System.console().readLine();
    //check if username is already in use
    for(UserInfo i : this.data){
      if(i.userEquals(u)){
        System.out.println("Error! Username '" + u + "' already in use.");
        System.exit(1);
      }
    } 
    //create the UserInfo in order to automatically create the hash and all info
    //needed to write to the file
    UserInfo N = null;
    try {
      N = UserInfo.addUserInfo(u, hashAlg, p);
    } catch (InvalidInputException iie) {
      System.out.println("Error! " + iie.getMessage() + "." );
      System.exit(1);
    } catch (NoSuchElementException nsee) {
      System.out.println(nsee.getMessage());
      System.exit(1);
    }
    //Print the gathered UserInfo to the file
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(new BufferedWriter(new FileWriter(filen, true)));
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace(); //should never get here due to prior exceptions
      System.exit(1);
    }
    pw.print(N.toString());
    if (pw != null) pw.close();
  }


  public void addData(Scanner in, String usern, String filen, ArrayList<DataInfo> userData, char[] p){
    String encalg = in.next();
    String label = in.next();
    String text = in.next();
    try {
      Encryptor testLabel = new Clear();
      testLabel.test(label, "label");
    } catch(InvalidInputException iie) {
      System.out.println("Error! Label '" + label + "' is invalid.");
      return;
    }
    if(label.contains("_")){
      System.out.println("Error! Label '" + label + "' is invalid.");
      return;
    }
    int useri = -1;
    boolean repeat = true;
    try {
      while (!userData.get(++useri).getLabel().equals(label));
    } catch(IndexOutOfBoundsException e ) {
      repeat = false;
    }

    if (repeat) {
      int index = -1;
      try { 
        while (!this.dataS.get(++index).equals(userData.get(useri)));
      } catch(IndexOutOfBoundsException e) {
        repeat = false; 
      } //should never happen
      dataS.get(index).setCiphertext(text);
    } else {
      dataS.add(new DataInfo(usern, encalg, label, text, totalData, p));
      totalData++;
    }


    for(DataInfo i : dataS){
      System.out.println(i);
    }
    
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(new File(filen));
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }
    
    for(int i = 0; i < totalData; i++){
      int ui = -1;
      int di = -1;
      try {
        while (!(this.data.get(++ui).getOrder() == i));
        pw.println(data.get(ui));
      } catch (IndexOutOfBoundsException eoobe) {}
      
      while(!(this.dataS.get(++di).getOrder() == i));
      pw.println(dataS.get(di));
    }

  
    if (pw != null) pw.close();

    

  }

  public static void main(String[] args) {
    //no command line arguement or invalid tac option
    if(args.length == 0 || (args.length == 2 && !args[0].equals("-au"))){
      System.out.println("usage: java Vault [-au] <filename>");
      System.exit(1);
    }

    //create Vault and read in data
    Vault V = new Vault();
    String filen;
    if(args.length == 2)
      filen = (args[1]);
    else
      filen = (args[0]);
    V.readData(filen);
    //collect username and password
    System.out.print("username: ");
    String usern = System.console().readLine();
    System.out.print("password: ");
    char[] pswd = System.console().readPassword();

    
    //Add user option (-au)
    if(args.length == 2){
      V.addUser(args[1], usern, pswd);
      System.exit(1);
    }

    //Authentication option
    Scanner in = new Scanner(System.in);
    V.verify(pswd, usern, in);
    
    ArrayList<DataInfo> userData = new ArrayList<DataInfo>();
    for(DataInfo i : V.dataS){
      if(i.getUser().equals(usern)){
        i.initP(pswd);
        userData.add(i);
      }
    }
    System.out.print("> ");
    String cmd = in.next();
    while(!cmd.equals("quit")){
      //LABELS cmd 
      if(cmd.equals("labels")){
        for(DataInfo i : userData){
          try{
            System.out.println(i.getLabel());
          } catch (Exception e) {
            System.out.println("Error! Corrupted entry '" + i.getCipher() + "' in vault file.");
          }
        }
      } 
      //GET cmd
      else if(cmd.equals("get")){
        String l = in.next();
        for(DataInfo i : userData){
          if(i.getLabel().equals(l)){
            try{
              System.out.println(i.getPlain(pswd));
            } catch (Exception e) {
              System.out.println("Error! Corrupted entry '" + i.getCipher() + "' in vault file.");
            }
          }
        }
      }
      
      //ADD cmd
      else if(cmd.equals("add")){
        V.addData(in, usern, filen, userData, pswd);  


      }
      //UNKNOWN cmd
      else {
        System.out.println("Unknown command '" + cmd + "'.");
      }
      System.out.print("> ");
      cmd = in.next();
    }
  }
}
