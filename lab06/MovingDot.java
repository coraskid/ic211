import java.util.*;


public class MovingDot extends Dot{
  private int d;
  private static Random rand = new Random();

  /*
   * Constructor
   */
  public MovingDot(int r, int c){
    super(r, c);
    this.d = 0;
  }

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
     * NEEDED METHOD BECAUSE BLUE AND RED DOTS NEED TO CHANGE DIRECTION
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
     * This method changes direction but only left right or straight
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

  protected void getD(){
    System.out.println(this.d);
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
