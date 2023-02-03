import java.util.*;
/**
 *
 */
public class Rotor{
  private String order;
  private char top;

  public Rotor(String s){
    this.order = s;
    this.top = s.charAt(0);
  }
  public Rotor(String s, char t){
    this.order = s;
    this.top = t;
    while(this.order.charAt(0) != t){
      this.clockwise();
    }
  }

  public String getO(){
    return this.order;
  }
  public char getT(){
    return this.top;
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
  
  public int index(char c){
    int ind = this.order.indexOf(c);
    return ind;
  }

  public char atIndex(int index){
    char c = this.order.charAt(index);
    return c;
  }

  public static void main(String[] args){
    Rotor r = new Rotor("asdfghjkl", 'd');
    System.out.println("hi");
    //r.clockwise();
    System.out.println(r.order);
    System.out.println(r.index('g'));
    System.out.println(r.atIndex(4));


  }






}
