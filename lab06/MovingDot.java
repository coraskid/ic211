import java.util.*;

/**
 * This class deal with moving dots
 * It takes the same properties of the dot class and gives each dot a direction
 * that allows it to move around the screen
 * @author Cora Skidmore
 */
public class MovingDot extends Dot{
  private int d;
  private static Random rand = new Random();

  /**
   * Constructor
   * Sets row, column and direction of the dot
   * @param r int representation of row value
   * @param c int representation of column value
   */
  public MovingDot(int r, int c){
    super(r, c);
    this.d = 0;
  }

  /**
   * This method takes one step in the current direction
   */
  public void step(){
    if(this.d == 0)
      this.incRow();
    if(this.d == 1){
      this.incRow();
      this.incCol();
    }
    if(this.d == 2)
      this.incCol();
    if(this.d == 3){
      this.incCol();
      this.decRow();
    }
    if(this.d == 4)
      this.decRow();
    if(this.d == 5){
      this.decCol();
      this.decRow();
    }
    if(this.d == 6)
      this.decCol();
    if(this.d == 7){
      this.decCol();
      this.incRow();
    }
  }
  
  /**
   * NEEDED PROTECTED METHOD BECAUSE DOTS NEED TO CHANGE DIRECTION
   * This method allows you to change to a specific method
   * @param newD this int dictates what direction to change to
   */
  protected void changeDir(int newD){
    if(newD > 7 || newD < 0){
      //prints error and keeps same dir
      System.out.println("ERROR!!");
      return;
    }
    this.d = newD;
  }
  /**
   * NEEDED PROTECTED METHOD BECAUSE DOTS NEED TO CHANGE DIRECTION
   * This method changes the direction randomly, but only changes 90 degrees or
   * continues in the same direction.
   */
  protected void changeDir(){
    //Random rand = new Random();
    int k = rand.nextInt(3);
    if(k == 0){ //-2 or left
      this.d = (this.d + 6) % 8;
    }
    if(k == 1){ //+2, or right
      this.d = (this.d + 2) % 8; 
      //dont do anything for straight
    }
  }

  public static void main(String[] args){
    MovingDot blue = new MovingDot(0,0);
    System.out.println(blue.toString() + " " + blue.d);
    blue.step();
    System.out.println(blue.toString() + " " + blue.d);
    blue.changeDir();
    blue.step();
    System.out.println(blue.toString() + " " + blue.d);
  }
}
