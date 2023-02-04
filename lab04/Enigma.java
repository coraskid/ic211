import java.util.*;

public class Enigma{
  private static final String[] roters = {"#GNUAHOVBIPWCJQXDKRYELSZFMT", 
                                          "#EJOTYCHMRWAFKPUZDINSXBGLQV", 
                                          "#BDFHJLNPRTVXZACEGIKMOQSUWY", 
                                          "#NWDKHGXZVRIFJBLMAOPSCYUTQE", 
                                          "#TGOWHLIFMCSZYRVXQABUPEJKND"}; 
  //private static final String r2 = "#EJOTYCHMRWAFKPUZDINSXBGLQV";
  //private static final String r3 = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
  //private static final String r4 = "#NWDKHGXZVRIFJBLMAOPSCYUTQE";
  //private static final String r5 = "#TGOWHLIFMCSZYRVXQABUPEJKND";

  private Rotor inner;
  private Rotor middle;
  private Rotor outer;

  public Enigma(int in, int mi, int out, String start){
    this.inner = new Rotor(roters[in-1], start.charAt(0));
    this.middle = new Rotor(roters[mi-1], start.charAt(1));
    this.outer = new Rotor(roters[out-1], start.charAt(2));
  }

  public String encrypt(String msg){

  }

  public String decrypt(String msg){

  }












}
