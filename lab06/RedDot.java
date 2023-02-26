import java.util.*;
/**
 * This class represents a red dot and has all properties of a moving dot
 * @author Cora Skidmore
 */
public class RedDot extends MovingDot{
  
  /**
   * Constructor
   * Calls constructor in Moving dot class to set row, column and direction
   * @param r int representation of row value
   * @param c int representation of column value
   */
  public RedDot(int r, int c){
    super(r, c);
  }
  
  /**
   * This method determins the dots movements
   * The Red dot gets a random direction (left, right, or straight) every step
   */
  public void step(){
    this.changeDir();
    super.step();
  }
  
  /**
   * This method creates a string version of what the plotter needs 
   * It overrides the Dot class' toString method by adding the color (red)
   * @return A string representation of the dots location and color
   */
  public String toString(){
    String toS = super.toString() + " r";
    return toS;
  }
}
