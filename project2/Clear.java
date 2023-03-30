public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  public void   init(char[] key) { test(new String(key), "key"); }
  public String encrypt(String plain) throws InvalidInputException {
    test(plain, "message");
    return plain; //System.out.println(new String(key)); 
  }
  public String decrypt(String cipher){ return cipher; }
}
