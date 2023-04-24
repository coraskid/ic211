import java.util.*;
import java.io.*;

public class HW18 {
  public static void main(String[] args) {
    LineNumberReader r = null;
    if (args.length == 1){
      try {
        r = new LineNumberReader(new InputStreamReader(new FileInputStream(args[0])));
      } catch (IOException ioe) {System.out.println("File not found");}
    }
    else {
      r = new LineNumberReader(new InputStreamReader(System.in));
    }

    Mystery myster = new Mystery();
    String line = null;
    try {
      line = r.readLine();
    } catch(Exception e) {}
    while(line != null) {
      Scanner sc = new Scanner(line);
      try {
        myster.compute(sc);
      } catch (Exception e) {
        System.out.println("Error on line " + r.getLineNumber() + ": " + e.getMessage());
        System.exit(1);
      }
      try {
        line = r.readLine();
      } catch(Exception e) {}
    }
    
    System.out.println(myster.result()); // only called once after all compute() calls are finished
    /*
    //Scanner sc = new Scanner(r);
    Mystery myster = new Mystery();
    //LineNumberReader lnr = new LineNumberReader(r);
    Scanner sc = new Scanner(r);
    try {
      myster.compute(sc); // can be called multiple times to continue computation
      System.out.println(myster.result()); // only called once after all compute() calls are finished
    } catch( Exception e ) {
      System.out.println("Error on line " + r.getLineNumber() + ": " + e.getMessage());
    } */
  }
}
