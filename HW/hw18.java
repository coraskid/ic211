import java.util.*;
import java.io.*;

public class HW18 {
  public static void main(String[] args) {
    Reader r = null;
    if (args.length == 1){
      try {
        r = new InputStreamReader(new FileInputStream(args[0]));
      } catch (IOException ioe) {System.out.println("File not found");}
    }
    else {
      Reader r = new InputStreamReader(System.in);
    }
    Scanner sc = new Scanner(r);
    Mystery myster = new Mystery();
    LineNumberReader lnr = new LineNumberReader(r);
    try {
      myster.compute(sc); // can be called multiple times to continue computation
      System.out.println(myster.result()); // only called once after all compute() calls are finished
    } catch( Exception e ) {
      System.out.println("Error on line " + lnr.getLineNumber() + e.getMessage());
    }
  }
}
