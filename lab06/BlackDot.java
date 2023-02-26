import java.util.*;


public class BlackDot extends MovingDot{
  private int stepCount;

  public BlackDot(int r, int c){
    super(r, c);
    stepCount = 0;
  }

  public void step(){
    int tS = 85; //totalStep
    if(stepCount % tS == 0)
      this.changeDir(2);
    else if(stepCount % tS < 5)
      this.changeDir(0);
    else if(stepCount % tS < 9)
      this.changeDir(3);
    else if(stepCount % tS < 13)
      this.changeDir(0);
    else if(stepCount % tS < 17)
      this.changeDir(4);
    else if(stepCount % tS < 18)
      this.changeDir(2);
    else if(stepCount % tS < 19)
      this.changeDir(0);
    else if(stepCount % tS < 20)
      this.changeDir(1);
    else if(stepCount % tS < 21)
      this.changeDir(0);
    else if(stepCount % tS < 22)
      this.changeDir(1);
    else if(stepCount % tS < 23)
      this.changeDir(3);
    else if(stepCount % tS < 24)
      this.changeDir(5);
    else if(stepCount % tS < 25)
      this.changeDir(2);
    else if(stepCount % tS < 26)
      this.changeDir(3);
    else if(stepCount % tS < 27)
      this.changeDir(4);
    else if(stepCount % tS < 28)
      this.changeDir(2);
    else if(stepCount % tS < 29)
      this.changeDir(1);
    else if(stepCount % tS < 30)
      this.changeDir(0);
    else if(stepCount % tS < 31)
      this.changeDir(7);
    else if(stepCount % tS < 32)
      this.changeDir(0);
    else if(stepCount % tS < 33)
      this.changeDir(4);
    else if(stepCount % tS < 34)
      this.changeDir(3);
    else if(stepCount % tS < 35)
      this.changeDir(4);
    else if(stepCount % tS < 36)
      this.changeDir(3);
    else if(stepCount % tS < 37)
      this.changeDir(1);
    else if(stepCount % tS < 38)
      this.changeDir(0);
    else if(stepCount % tS < 39)
      this.changeDir(1);
    else if(stepCount % tS < 40)
      this.changeDir(0);
    else if(stepCount % tS < 41)
      this.changeDir(2);
    else if(stepCount % tS < 42)
      this.changeDir(4);
    else if(stepCount % tS < 44)
      this.changeDir(3);
    else if(stepCount % tS < 45)
      this.changeDir(4);
    else if(stepCount % tS < 46)
      this.changeDir(0);
    else if(stepCount % tS < 48)
      this.changeDir(1);
    else if(stepCount % tS < 49)
      this.changeDir(0);
    else if(stepCount % tS < 55)
      this.changeDir(2);
    else if(stepCount % tS < 60)
      this.changeDir(4);
    else if(stepCount % tS < 62)
      this.changeDir(3);
    else if(stepCount % tS < 63)
      this.changeDir(4);
    else if(stepCount % tS < 80)
      this.changeDir();
    else
      this.changeDir(2);
    super.step();
    stepCount++;
  }

  public String toString(){
    String toS = super.toString() + " k";
    return toS;
  }

}
