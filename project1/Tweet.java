import java.util.*;

public class Tweet {
  private String text, user;
  private int day, mon, year;

  public Tweet(String newtext, String newuser, String newdate) {
    this.text = newtext;
    this.user = newuser;
    String[] date = newdate.split("-");
    this.year = Integer.parseInt(date[0]);
    this.mon = Integer.parseInt(date[1]);
    this.day = Integer.parseInt(date[2]);

  }
  
  public String toString(){
    return (this.text + "\t[" + this.user + "]\t" + this.mon + "/" + this.day + "/" + this.year);  
  }


  public static void main(String[] args){
    Tweet test = new Tweet("hi", "this_is_me", "2013-08-14");
    System.out.println(test.toString());

  }
}
