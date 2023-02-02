import java.util.*;
/**
 *
 */
public class Rotor{
  private String order;
  private char top;

  public Rotor(String s){
    this.order = s;
    this.top = s[0];
  }
  public Rotor(String s, char t){
    this.order = s;
    this.top = t;
    while(s[0] != t){
      this.clockwise();
    }

  }

  public void clockwise(){
    char[] temp = this.order;
    temp[0] = this.order[this.order.length()-1];
    for(int i = 1; i < this.order.length(); i++){
      temp[i] = this.order[i-1];
    }
    this.order = temp;
  }

  public static void main(String[] args){
    Rotor r = new Rotor("asdfghjkl", 'd');
    System.out.println(r.order);


  }






}
