/**
 * Encryptor interface
 * Sets up all encryptors
 * @author 211 profs
 */
public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key);
  public String encrypt(String plain);
  public String decrypt(String cipher);
  /**
   * Added method
   * Tests strings for invalid characters
   * @param test the string you want to test
   * @param type where the string is in actual code (goes in error message)
   */
  public default void test(String test, String type) throws InvalidInputException {
    char[] t = test.toCharArray();
    for(int i = 0; i < t.length; i++){
      int ti = (int)t[i];
      if(ti < 42 || ti > 122){
        throw new InvalidInputException("Invalid symbol '" + t[i] + "' in " + type);
      }
    }
  }
}
