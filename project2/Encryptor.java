public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key);
  public String encrypt(String plain);
  public String decrypt(String cipher);
  public default void test(String test, String type) throws InvalidInputException {
    char[] t = test.toCharArray();
    for(int i = 0; i < t.length; i++){
      int ti = (int)t[i];
      if(ti < 42 || ti > 122){
        throw new InvalidInputException("Invalid input '" + t[i] + "' in " + type);
      }
    }
  }
}
