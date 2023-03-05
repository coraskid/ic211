import java.util.*;
import java.io.*;
public class FileLineCounter {
  public static int countLines(String filename) throws FileNotFoundException{
    int lines = 0;

    Scanner sc = new Scanner(new FileReader(filename));
    while (sc.hasNextLine()) {
      sc.nextLine();
      lines++;
    }
    sc.close();
    return lines;
  }
}
