import java.util.*;
/**
 * This class represents and establishes rotors in their correct position, it
 * also has the ability to rotate a rotor clockwise or counterclockwise by one
 * @author cora skidmore
 */
public class Rotor{
  private String order;
  private char top;
  /**
   * Constructor
   * Takes a string that will represent the order of the rotor and uses the
   * first letter in the string to represent the top
   * @param s Order of letters on the rotor represented by a string
   */
  public Rotor(String s){
    this.order = s;
    this.top = s.charAt(0);
  }
  /**
   * Constructor (more useful)
   * Takes a string that represents the order of the rotor and a char that will
   * be start of the rotor and adjusts the rotor accordingly
   * @param s Order of letters on the rotor represended by a string
   * @param t Char that will be the top of the rotor
   */
  public Rotor(String s, char t){
    this.order = s;
    this.top = t;
    while(this.order.charAt(0) != t){
      this.clockwise();
    }
  }
  /**
   * A getter method for the order of the rotor
   * Not yet needed in another class, remains private
   */
  private String getO(){
    return this.order;
  }
  /**
   * A getter method for the char that was originally on top 
   */
  public char getT(){
    return this.top;
  }
  /**
   * Rotates the rotor by one clockwise
   */
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
  
  /**
   * Rotates the rotor by one clockwise
   */
  public void ccw(){
    int len = this.order.length(); 
    char[] arr = this.order.toCharArray();
    char temp = arr[0];
    for(int j = 0; j < len-1; j++){
      arr[j] = arr[j+1];
    }
    arr[len-1] = temp;
    

  }
  /**
   * Finds the index of a given char in the current order of the rotor
   * @param c The char that we want the index of
   */
  public int index(char c){
    int ind = this.order.indexOf(c);
    return ind;
  }
  /**
   * Finds the char of a given index in the current order of the rotor
   * @param index The int that we want the char at
   */
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
