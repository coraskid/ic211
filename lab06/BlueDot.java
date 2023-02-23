import java.util.*;


public class BlueDot extends MovingDot{
  private int stepCount;

  public BlueDot(int r, int c){
    super(r, c);
    stepCount = 0;
  }

  public void step(){
    if(stepCount == 10){
      //this.getD();
      this.changeDir();
      //this.getD();
      this.stepCount = 0;
    }
    super.step();
    stepCount++;
  }

  public String toString(){
    String toS = super.toString() + " b";
    return toS;
  }

}
