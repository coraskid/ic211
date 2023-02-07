import java.util.*;

public class Search{


  private Tweet[] readfile(String path){
    Scanner fin = new Scanner(path);
    Tweet[] arr = new Tweet[33];
    for(int i = 0; i < 33; i++){
      String text = fin.next();
      String user = fin.next();
      String date = fin.next();
      arr[i] = new Tweet(text, user, date);
    }

  }




  public static void main(String[] args){
    if (args.length == 0){
      System.out.println("usage: java Search <tweets-file>");
      return;
    }
    Tweet[] arr = readfile(args[0]);

    //System.out.println(args.length);



  }
}
