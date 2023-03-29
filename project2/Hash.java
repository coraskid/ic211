import java.util.*;
public class Hash {
  private String initVec = "GO_NAVY_2018^mid";
  public Encryptor E; 
  public String hashName;
  public void setName(String name) { hashName = name; }
  public String getEncalgName() {
    if (hashName.equals("clear"))
      return "clear";
    char[] test = hashName.toCharArray();
    if (test.length < 7 || !hashName.substring(0,6).equals("shift+"))
      return hashName;
    return hashName.substring(6);
    //System.out.println(test[0]);
    //System.out.println(test[1]);

    //return hashName.split("+")[1];

  }

  private void setEncryptor(){
    ArrayList<Encryptor> En = new ArrayList<Encryptor>();
    En.add(new Clear());
    En.add(new Caesar());
    En.add(new Vigenere());
    String encalg = this.getEncalgName();
    int i = -1;
    try {
      while( !En.get(++i).getAlgName().equals(encalg) );
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg + "'.");
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
    //System.out.println("in SHift: " + new String(newStr));
    return newStr;
  }
  public String hash(char[] pswd){
    //Encryptor E = new Caesar();
    //System.out.println(xxtend(pswd));
    this.setEncryptor();
    E.init((pswd));

    if(E.getAlgName().equals("clear"))
      return new String(xxtend(pswd));
    
    char[] x = initVec.toCharArray();
    //System.out.println("base: " + new String(x));
    for(int i = 0; i < 16; i++){
      int k = ((int)x[i]) %16;
      //System.out.println("k: " + k + " i : " + i + " " + new String(x));
      x = shift(x, k);
      x = (E.encrypt(new String(x))).toCharArray();
    }
    return new String(x); 
  }

}
