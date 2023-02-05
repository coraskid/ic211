import java.util.*;
/**
 * This class represents the function of an enigma machine and is able to
 * encrypt and decrypt messages
 * @author cora skidmore
 */
public class Enigma{
  private static final String[] roters = {"#GNUAHOVBIPWCJQXDKRYELSZFMT", 
                                          "#EJOTYCHMRWAFKPUZDINSXBGLQV", 
                                          "#BDFHJLNPRTVXZACEGIKMOQSUWY", 
                                          "#NWDKHGXZVRIFJBLMAOPSCYUTQE", 
                                          "#TGOWHLIFMCSZYRVXQABUPEJKND"}; 
  private Rotor inner;
  private Rotor middle;
  private Rotor outer;

  /**
   * Constructor
   * Takes 3 rotor choices (taken from the 5 set rotor arrangements), and where
   * the top is supposed to be and establishes the three rotors that will be
   * used in the enigma
   * @param in inner rotor number
   * @param mi middle rotor number
   * @param out outer rotor number
   * @param start a string with 3 letters representing the top of each rotor in
   * order (inner, middle, outer)
   */
  public Enigma(int in, int mi, int out, String start){
    this.inner = new Rotor(roters[in-1], start.charAt(0));
    this.middle = new Rotor(roters[mi-1], start.charAt(1));
    this.outer = new Rotor(roters[out-1], start.charAt(2));
  }
  /**
   * Finds the corresponding char on another rotor given two rotors and a char
   * @param c the char that you have
   * @param from the rotor you are starting at
   * @param to the rotor you are going to
   * @return the Char found at the 'to' rotor that matches
   */
  private static char match(char c, Rotor from, Rotor to){
    int i = from.index(c);
    char newC = to.atIndex(i);
    return newC;
  }
  /**
   * Encrypts a message based on the current enigma set up
   * @param msg The message you want to encrypt
   */
  public String encrypt(String msg){
    int len = msg.length();
    char[] encMsg = new char[len];
    
    for(int i = 0; i < len; i++){
      char stepOne = match(msg.charAt(i), this.inner, this.outer);
      char stepTwo = match(stepOne, this.middle, this.outer);
      encMsg[i] = stepTwo;  
      
      this.inner.clockwise();
      if (this.inner.atIndex(0) == this.inner.getT()){
        this.middle.clockwise();
        if (this.middle.atIndex(0) == this.middle.getT()){
          this.outer.clockwise();
        }
      }
    }
    return String.valueOf(encMsg);
  }
  /**
   * Decrypts a message based on the current enigma set up
   * @param msg The message you want decrypted
   */
  public String decrypt(String msg){
   // String set roters = this.encrypt(msg);

    int len = msg.length();
    char[] decMsg = new char[len];
      
    for(int i = 0; i < len; i++){
      char stepOne = match(msg.charAt(i), this.outer, this.middle);
      char stepTwo = match(stepOne, this.outer, this.inner);
      decMsg[i] = stepTwo;
     
      this.inner.clockwise();
      if (this.inner.atIndex(0) == this.inner.getT()){
        this.middle.clockwise();
        if (this.middle.atIndex(0) == this.middle.getT()){
          this.outer.clockwise();
        }
      }
    }
    return String.valueOf(decMsg);
  }

  public static void main(String[] args){
    Enigma t = new Enigma(1,2,3, "###");
    System.out.println(t.decrypt("XXMMJ#UBHRWSHYSSTGWIGMMMAKTFSWZD#PU#CZIQADCDQY#NHN#SJVJTKZVVHOZBABLYMWBWWLNGAWWXEBWNXQQBQQRNMJGYXRYBKISBBFHGOO"));
  }

}
