import java.util.*;
public abstract class Piece {
  // what = 0 <-- ball
  //        1 <-- chip
  //        2 <-- die
  private boolean black;
  //public int what;

  // only for what=2
  private int numBlack;
  private int numWhite;
  
  public Piece(){
    black = false;
    numBlack = 0;
    numWhite = 0;
  }
  public Piece(int a, int b){
    black = false;
    numBlack = a;
    numWhite = b;
  }
  public Piece(boolean b){
    black = b;
    numBlack = 0;
    numWhite = 0;
  }
    

  public void setBlack(boolean b){
    this.black = b;
  }
  public int getNumBlack(){
    return numBlack;
  }
  public int getNumWhite(){
    return numWhite;
  }
  public boolean getBlack(){
    return black;
  }

  public abstract void shake(Random r);
}
