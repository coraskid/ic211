import java.util.*;
/**
 * This class represents a blue dot and has all properties of a moving dot
 * @author Cora Skidmore
 */
public class BlueDot extends MovingDot{
  private int stepCount;
  
  /**
   * Constructor
   * Calls constructor in Moving dot class to set row, column and direction
   * It also sets the stepCount (specific to bluedots) to 0
   * @param r int representation of row value
   * @param c int representation of column value
   */
  public BlueDot(int r, int c){
    super(r, c);
    stepCount = 0;
  }

  /**
   * This method determins the dots movements
   * The Blue dot gets a random direction (left, right, or straight) every 10th
   * step
   */
  public void step(){
    if(stepCount == 10){
      this.changeDir();
      this.stepCount = 0;
    }
    super.step();
    stepCount++;
  }

  /**
   * This method creates a string version of what the plotter needs 
   * It overrides the Dot class' toString method by adding the color (blue)
   * @return A string representation of the dots location and color
   */
  public String toString(){
    String toS = super.toString() + " b";
    return toS;
  }
}
