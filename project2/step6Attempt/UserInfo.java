import java.util.*;
/**
 * This class creates compact way to represent user information
 * @author Cora Skidmore
 */
public class UserInfo {
  private String user;
  private String encalg;
  private String hashalg;
  private String hash;
  private Hash hashObj;
  private int order;
  /**
   * Constructor
   * sets up all of the UserInfo
   * @param u username
   * @param e encalg
   * @param p password
   */
  public UserInfo(String u, String e, char[] p){
    user = u;
    hashalg = e;
    hashObj = new Hash();
    hashObj.setName(e);
    encalg = hashObj.getEncalgName();
    hash = hashObj.hash(p);
  }
  /**
   * Constructor
   * sets up all of the UserInfo, but doesnt know the password
   * @param u username
   * @param e encalg
   * @param h hash
   * @param i order
   */
  public UserInfo(String u, String e, String h, int i){
    order = i;
    user = u;
    hash = h;
    hashalg = e;
    hashObj = new Hash();
    hashObj.setName(e);
    encalg = hashObj.getEncalgName();
  }
  /**
   * Creates a UserInfo object given inputs
   * @param u username
   * @param e encalg
   * @param p password
   * @return UserInfo with all new info
   */
  public static UserInfo addUserInfo(String u, String e, char[] p) throws NoSuchElementException{
    UserInfo i = null;
    try {
      i = new UserInfo(u, e, p);
    } catch (NoSuchElementException nsee) {
      throw new NoSuchElementException("Error! Hash algorithm '" + e + "' not supported.");
    }
    return i;
  }
  /**
   * checks if the instance user is equal to given string
   * @param u string you are comparing to
   * @return boolean, true if they are equal, false otherwise
   */
  public boolean userEquals(String u){
    return this.user.equals(u);
  }
  /**
   * checks if the hash is equal to given string
   * @param h hash you are comparing to
   * @return boolean, true if they are equal, false otherwise
   */
  public boolean hashEquals(String h){
    return this.hash.equals(h);
  }
  /**
   * classic toString method
   * @return a string
   */
  public String toString(){
    return "user " + user + " " + hashalg + " " + hash;
  }
  /**
   * returns the hash
   * @return a hash
   */
  protected Hash getHash(){
    return hashObj;
  }
  /**
   * returns the algorithm name
   * @return algorithm name
   */
  public String getAlgName(){
    return encalg;
  }
  /**
   * returns order
   * @return order
   */
  public int getOrder() {
    return order;
  }
}

