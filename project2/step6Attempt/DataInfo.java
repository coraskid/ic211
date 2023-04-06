import java.util.*;
/**
 * This class creates a compact way to represent data information
 * @author cora Skidmore
 */
public class DataInfo {
  private String user;
  private String encalg;
  private String ciphertext;
  private Encryptor E;
  private String label;
  private int order;
  /**
   * Constructor
   * sets up all of the data information
   * @param u username
   * @param e encalg
   * @param c ciphertext
   * @param o order
   */
  public DataInfo(String u, String e, String c, int o) {
    order = o;
    user = u;
    encalg = e;
    ciphertext = c;
    //set up correct encryptor
    ArrayList<Encryptor> EOp = new ArrayList<Encryptor>();
    EOp.add(new Clear());
    EOp.add(new Caesar());
    EOp.add(new Vigenere());
    int i = -1;
    try {
      while ( !EOp.get(++i).getAlgName().equals(encalg) ) ;
    } catch(IndexOutOfBoundsException ioobe) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg +"'.");
    }
    E = EOp.get(i);
  }
  /**
   * Constructor for when you are trying to make a new DataInfo object but still
   * need to encrypt data
   * @param u username
   * @param e encalg
   * @param l label
   * @param t text
   * @param o order
   * @param pswd user's password
   */
  public DataInfo(String u, String e, String l, String t, int o, char[] pswd){
    this.user = u;
    this.encalg = e;
    this.label = l;
    this.order = o;
    ArrayList<Encryptor> EOp = new ArrayList<Encryptor>();
    EOp.add(new Clear());
    EOp.add(new Caesar());
    EOp.add(new Vigenere());
    int i = -1;
    try {
      while ( !EOp.get(++i).getAlgName().equals(encalg) ) ;
    } catch(IndexOutOfBoundsException ioobe) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg +"'.");
    }
    E = EOp.get(i);
    this.initP(pswd);
    String fullText = l + "_" + t;
    ciphertext = E.encrypt(fullText);
    

  }
  /**
   * Initialize password to the encyptor
   * @param p password
   */
  public void initP(char[] p){
    E.init(p);
  }
  /**
   * get username
   * @return username
   */
  public String getUser(){
    return this.user;
  }
  /**
   * classic toString method
   * @return string representation of DataInfo
   */
  public String toString(){
    return "data " + user + " " + encalg + " " + ciphertext;
  }
  /**
   * returns the label section of the data field
   * @return label
   */
  public String getLabel() throws VaultException{
    String plain;
    try{
      plain = E.decrypt(ciphertext);
    } catch (InvalidInputException iie) {
      throw new VaultException(ciphertext);
    }
    int index = plain.indexOf("_");
    if(index == -1){
      throw new VaultException(ciphertext);
    }
    label = plain.substring(0, index);
    return label;
  }
  /**
   * returns the plaintext section of the data field
   * @param p password
   * @return data field
   */
  public String getPlain(char[] p) throws VaultException{
    String plain;
    try {
      plain = E.decrypt(ciphertext);
    } catch (InvalidInputException iie) {
      throw new VaultException(ciphertext);
    }
    int index = plain.indexOf("_");
    if(index == -1){
      throw new VaultException(ciphertext);
    }
    return plain.substring(index+1);
  }
  /**
   * returns ciphertext
   * @return ciphertext
   */
  public String getCipher(){
    return ciphertext;
  }
  /**
   * returns order
   * @return order
   */
  public int getOrder(){
    return order;
  }
  /**
   * sets a new ciphertext given a new text value
   * @param text new text value you want to replace
   */
  public void setCiphertext(String text){
    String plain = this.getLabel() + "_" + text;
    String cipher;
    try {
      cipher = E.encrypt(plain);
    } catch (InvalidInputException iie) {
      //SET CHARACTERS
      throw new InvalidInputException("Error! Invalid characer '" + iie.getCharError() + "' in text.", iie.getCharError());
    }
    this.ciphertext = cipher;
  }
  /**
   * checks to see if two DataInfo objects are equal
   * @param i DataInfo object you are checking against the instance object
   * @return true if equal, false otherwise
   */
  public boolean equals(DataInfo i){
    if(!(this.toString()).equals(i.toString()))
      return false;
    return true;

  }
}
