//Cora Skidmore
import java.util.*;
public class Dice extends Piece {
  private int numBlack;
  private int numWhite;
  public Dice() {
    super();
    this.numBlack = 2;
    this.numWhite = 4;
  }
  public int getNumBlack(){
    return numBlack;
  }
  public int getNumWhite(){
    return numWhite;
  }
  public void shake(Random r) {
    int k = r.nextInt(this.numBlack + this.numWhite);
    this.setBlack(k < this.numBlack);
  }
}
