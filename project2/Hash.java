public interface Hash {
  public String hash(char[] pswd);
  public String getAlgName();
  public default char[] xxtend(char[] s){
    char[] finalS = new char[16];
    for(int i = 0; i < 16; i++){
      if(s.length > i)
        finalS[i] = s[i];
      else
        finalS[i] = 'x';
    }
    return finalS;
  }
  public default char[] shift(char[] str, int shift){
    char[] newStr = new char[str.length];
    for(int i = 0; i < str.length; i++){
      newStr[i] = str[(i+shift)%str.length];
    }
    System.out.println("in SHift: " + new String(newStr));
    return newStr;
  }
}
