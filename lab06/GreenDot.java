import java.util.*;
/**
 * This class represents a Green dot and has all properties of a moving dot
 * @author Cora Skidmore
 */
public class GreenDot extends MovingDot{
  private int stepCount;

  /**
   * Constructor
   * Calls constructor in Moving dot class to set row, column and direction
   * It sets the stepCount (specific to greendots) to 0
   * It sets the Direction to 1 initially (so that it is on the diagonals)
   * @param r int representation of row value
   * @param c int representation of column value
   */
  public GreenDot(int r, int c){
    super(r, c);
    this.changeDir(1);
    stepCount = 0;
  }

  /**
   * This method determins the dots movements
   * The Green dot gets a random direction (left, right, or straight) every 10th
   * step, however, it moves only along the diagonals
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
   * It overrides the Dot class' toString method by adding the color (green)
   * @return A string representation of the dots location and color
   */
  public String toString(){
    String toS = super.toString() + " g";
    return toS;
  }

}
