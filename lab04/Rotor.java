import java.util.*;
/**
 *
 */
public class Rotor{
  private String order;
  private char top;

  //public Rotor(String s){
    //this.order = s;
    //this.top = s[0];
  //}
  public Rotor(String s, char t){
    this.order = s;
    this.top = t;
    while(s.charAt(0) != t){
      this.clockwise();
    }

  }
  //charAt(int index);
  //indexOf(char c);
  //lastIndexOf(char c);
  //split(String regex);
  //concat(String end);
  //toCharArray();
  //valueOf(char[] data) - returns string
  public void clockwise(){
    int len = this.order.length(); 
    char[] arr = this.order.toCharArray();
    char temp = arr[len -1];
    for(int j = len -1; j >= 1; j--){
      arr[j] = arr[j-1];
    }
    arr[0] = temp;
    this.order = String.valueOf(arr);
  }

  public static void main(String[] args){
    Rotor r = new Rotor("asdfghjkl", 'd');
    r.clockwise();
    System.out.println(r.order);


  }






}
