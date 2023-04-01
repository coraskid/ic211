public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  public void   init(char[] key) { 
    //test for invalid characters
    test(new String(key), "password"); 
  }
  public String encrypt(String plain) throws InvalidInputException {
    test(plain, "message");
    return plain;
  }
  public String decrypt(String cipher){ return cipher; }
}
