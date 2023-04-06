//Cora Skidmore
import java.util.*;
public abstract class Piece {
  private boolean black;
  public Piece(){
    black = false;
  }
  public void setBlack(boolean b){
    this.black = b;
  }
  public boolean getBlack(){
    return black;
  }
  public abstract void shake(Random r);
}
