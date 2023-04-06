/**
 * This class outlines the Vignere encryption class
 * @author Cora Skidmore
 */
public class Vigenere implements Encryptor {
  private int[] k; //Stored shifting info of password
  /**
   * returns algorithm name
   * @return algorithm name
   */
  public String getAlgName() { return "vigenere"; }
  /**
   * Initilizeds the key and fills k with proper int values
   * @param key char array representation of the key
   */
  public void   init(char[] key) {
    //test for invalid char input
    test(new String(key), "password");
    //translates password into an int array and saves it in k
    k = new int[key.length];
    for(int i = 0; i < key.length; i++)
      k[i] = (int) key[i];
  }
  /**
   * encrypts a string based off of k values
   * @param plain text you want to encrypt
   * @return encrypted text
   */
  public String encrypt(String plain) {
    //test for invalid char input
    test(plain, "message");
    char[] plainC = plain.toCharArray();
    char[] cipher = new char[plain.length()];
    int lenK = k.length;
    //shifts each letter by corresponding shift amount in key
    for(int i = 0; i < plain.length(); i++){
      int temp = ((int)plainC[i] + (int)k[i%lenK] - 84) %81;
      cipher[i] = (char) (temp +42);
    }
    return new String(cipher);  
  }
  /**
   * decrypts a string
   * @param cipher text that you want to decrypt
   * @return decrypted text
   */
  public String decrypt(String cipher){
    test(cipher, "cipher");
    char[] cipherC = cipher.toCharArray();
    char[] plain = new char[cipher.length()];
    //unshifts each letter undoing encryption
    for(int i = 0; i < cipherC.length; i++){
      int temp = (((int)cipherC[i] -42) + (81 - ((int)k[i%(k.length)] -42))) %81;
      plain[i] = (char) (temp +42);
    }
    test(new String(plain), "plain");
    return new String(plain);
  }
}
