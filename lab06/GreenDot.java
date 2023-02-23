import java.util.*;


public class GreenDot extends MovingDot{
  private int stepCount;

  public GreenDot(int r, int c){
    super(r, c);
    this.changeDir(1);
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
    String toS = super.toString() + " g";
    return toS;
  }

}
