import java.util.*;
public class Hash {
  private String initVec = "GO_NAVY_2018^mid";
  public Encryptor E; 
  public String hashName;
  public void setName(String name) { hashName = name; }
  /**
   * Get the name for the Encryptor 
   */
  public String getEncalgName() {
    if (hashName.equals("clear"))
      return "clear";
    char[] test = hashName.toCharArray();
    if (test.length < 7 || !hashName.substring(0,6).equals("shift+"))
      return hashName;
    return hashName.substring(6);
  }

  private void setEncryptor() throws NoSuchElementException{
    //Set all encryptor options
    ArrayList<Encryptor> En = new ArrayList<Encryptor>();
    En.add(new Clear());
    En.add(new Caesar());
    En.add(new Vigenere());
    String encalg = this.getEncalgName();
    int i = -1;
    try {
      while( !En.get(++i).getAlgName().equals(encalg) );
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Error! Hash algorithm '" + encalg + "' not supported.");
    }
    this.E = En.get(i);
  }
  public char[] xxtend(char[] s){
    char[] finalS = new char[16];
    for(int i = 0; i < 16; i++){
      if(s.length > i)
        finalS[i] = s[i];
      else
        finalS[i] = 'x';
    }
    return finalS;
  }

  public char[] shift(char[] str, int shift){
    char[] newStr = new char[str.length];
    for(int i = 0; i < str.length; i++){
      newStr[i] = str[(i+shift)%str.length];
    }
    return newStr;
  }
  public String hash(char[] pswd){
    //set up the encryptor 
    this.setEncryptor();
    E.init((pswd));
    //handle the clear encryption
    if(E.getAlgName().equals("clear"))
      return new String(xxtend(pswd));
    //handle caesar and vigenere encryption
    char[] x = initVec.toCharArray();
    for(int i = 0; i < 16; i++){
      int k = ((int)x[i]) %16;
      x = shift(x, k);
      x = (E.encrypt(new String(x))).toCharArray();
    }
    return new String(x); 
  }

}
