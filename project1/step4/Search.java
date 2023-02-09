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

  /**
   * Checks if a tweet contains a certain keyword
   * @param keyword String you are looking for
   * @return Will return true if it is in the tweet, otherwise, returns false
   */
  public boolean containsKeyword(String keyword){
    String lower = this.text.toLowerCase();
    return lower.contains(keyword.toLowerCase());
  }


  public static void main(String[] args){
    Tweet test = new Tweet("hi", "this_is_me", "2013-08-14");
    System.out.println(test.toString());
    System.out.println(test.containsKeyword("hi"));
    System.out.println(test.containsKeyword("h"));
    System.out.println(test.containsKeyword("hiello"));

  }
}

