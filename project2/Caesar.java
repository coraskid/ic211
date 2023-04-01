/**
 * 
 */
public class Caesar implements Encryptor {
  private int shift;
  public String getAlgName() { return "caesar"; }
  /**
   *
   */
  public void   init(char[] key) {
    int sc = 0;
    //Error check for chars outside of 42-122 and throw error if so
    test(new String(key), "password");
    //calculate shift value 
    for(int i = 0; i < key.length; i++){
      sc += (int)key[i] - 42;
    }
    sc += 18;
    sc = sc%81;
    this.shift = 42 + sc;
  }
  /**
   *
   */
  public String encrypt(String plain) throws InvalidInputException { 
    char[] cipher = new char[plain.length()];
    char[] plainC = plain.toCharArray();
    test(plain, "message"); //test message for invalid characters
    //shift every character in the plaintext by calculated shift value
    for(int i = 0; i < plainC.length; i++){
      int temp = (shift + (int)plainC[i] - 84) %81;
      cipher[i] = (char) (temp + 42);
    }
    return new String(cipher); 
  }
  /**
   * 
   */
  public String decrypt(String cipher){
    char[] cipherC = cipher.toCharArray();
    char[] plain = new char[cipher.length()];
    //reverse the shift on each character of the ciphertext
    for(int i = 0; i < cipherC.length; i++){
      int temp = (((int)cipherC[i] - 42) + (81 - (shift - 42))) %81;
      plain[i] = (char) (temp + 42);
    }
    return new String(plain); 
  }
}
