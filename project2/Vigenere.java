public class Vigenere implements Encryptor {
  private int[] k;
  public String getAlgName() { return "vigenere"; }
  public void   init(char[] key) {
    test(new String(key), "key");
    k = new int[key.length];
    for(int i = 0; i < key.length; i++)
      k[i] = (int) key[i];
  }
  public String encrypt(String plain) {
    test(plain, "message");
    char[] plainC = plain.toCharArray();
    char[] cipher = new char[plain.length()];
    int lenK = k.length;
    for(int i = 0; i < plain.length(); i++){
      int temp = ((int)plainC[i] + (int)k[i%lenK] - 84) %81;
      cipher[i] = (char) (temp +42);
    }
    return new String(cipher);  
  }
  public String decrypt(String cipher){ 
    char[] cipherC = cipher.toCharArray();
    char[] plain = new char[cipher.length()];
    for(int i = 0; i < cipherC.length; i++){
      int temp = (((int)cipherC[i] -42) + (81 - ((int)k[i%(k.length)] -42))) %81;
      plain[i] = (char) (temp +42);
    }
    return new String(plain);
  }
}
