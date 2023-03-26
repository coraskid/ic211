public class ShiftCaesar implements Hash {
  private String initVec = "GO_NAVY_2018^mid";
  public String getAlgName() { return "shift+caesar"; }
  public String hash(char[] pswd){
    Encryptor E = new Caesar();
    System.out.println(xxtend(pswd));
    E.init(xxtend(pswd));
    char[] x = initVec.toCharArray();
    System.out.println("base: " + new String(x));
    for(int i = 0; i < 16; i++){
      int k = ((int)x[i] -42) %16;
      System.out.println("k: " + k + " i : " + i + " " + new String(x));
      x = shift(x, k);
      x = (E.encrypt(new String(x))).toCharArray();
    }
    return new String(x); 
  }

}
