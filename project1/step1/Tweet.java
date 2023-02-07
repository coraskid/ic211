import java.util.*;
/**
 * The Tweet class creates a tweet given the text, user and date
 * @author Cora skidmore
 */
public class Tweet {
  private String text, user;
  private int day, mon, year;
  /**
   * Constructor
   * Creates a tweet given the text, user and date
   * @param newtext String representation of the text in the tweet
   * @param newuser String representation of the usersname
   * @param newdate String representation of the date in "YYYY-MM-DD" format
   */
  public Tweet(String newtext, String newuser, String newdate) {
    this.text = newtext;
    this.user = newuser;
    String[] date = newdate.split("-");
    this.year = Integer.parseInt(date[0]);
    this.mon = Integer.parseInt(date[1]);
    this.day = Integer.parseInt(date[2]);

  }
  /**
   * Converts a tweet to a string in the format:
   * Tweet \t [user] \t MM/DD/YY
   */
  public String toString(){
    return (this.text + "\t[" + this.user + "]\t" + this.mon + "/" + this.day + "/" + this.year);  
  }


  public static void main(String[] args){
    Tweet test = new Tweet("hi", "this_is_me", "2013-08-14");
    System.out.println(test.toString());

  }
}
