import java.util.*;


public class RedDot extends MovingDot{
  

  public RedDot(int r, int c){
    super(r, c);
  }

  public void step(){
    this.changeDir();
    super.step();
  }

  public String toString(){
    String toS = super.toString() + " r";
    return toS;
  }

}
