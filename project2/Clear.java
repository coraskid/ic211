/**
 * This class outlines the encryption class that does nothing
 * @author 211 profs
 */
public class Clear implements Encryptor {
  /**
   * returns algorithm name
   * @return algorithm name
   */
  public String getAlgName() { return "clear"; }
  /**
   * sets key, but due to nature of the cipher, doesnt do something
   * @param key password
   */
  public void   init(char[] key) { 
    //test for invalid characters
    test(new String(key), "password"); 
  }
  /**
   * encrypts a String, but due to the nature of the cipher, returns same text
   * @param plain text that you want to encrypt
   * @return encrypted message
   */
  public String encrypt(String plain) {
    test(plain, "message");
    return plain;
  }
  /**
   * decrypts a String, but due to the nature of the cipher, returns same text
   * @param cipher text that you want to decrypt
   * @return decrypted message
   */
  public String decrypt(String cipher){ 
    test(cipher, "cipher");
    return cipher; 
  }
}
