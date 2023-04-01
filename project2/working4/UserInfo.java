import java.util.*;
public class UserInfo {
  private String user;
  private String encalg;
  private String hashalg;
  private String hash;
  private Hash hashObj;
    
  public UserInfo(String u, String e, char[] p){
    user = u;
    hashalg = e;
    hashObj = new Hash();
    hashObj.setName(e);
    encalg = hashObj.getEncalgName();
    hash = hashObj.hash(p);
  }
  public UserInfo(String u, String e, String h){
    user = u;
    hash = h;
    hashalg = e;
    hashObj = new Hash();
    hashObj.setName(e);
    encalg = hashObj.getEncalgName();
  }
    
  public static UserInfo addUserInfo(String u, String e, char[] p) throws NoSuchElementException{
      //UserInfo nui = new UserInfo(u, e);
      //nui.hash = nui.hashObj.hash(p);
    UserInfo i = null;
    try {
      i = new UserInfo(u, e, p);
    } catch (NoSuchElementException nsee) {
      throw new NoSuchElementException("Error! Hash algorithm '" + e + "' not supported.");
    }
    return i;
  }
  public boolean userEquals(String u){
    return this.user.equals(u);
  }
  public boolean hashEquals(String h){
    return this.hash.equals(h);
  }
  public String toString(){
    return "user " + user + " " + hashalg + " " + hash;
  }
  protected Hash getHash(){
    return hashObj;
  }
  public String getAlgName(){
    return encalg;
  }
}

