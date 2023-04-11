import java.util.*;
public class Dice extends Piece {
  public Dice() {
    super(2, 4);
    //this.numBlack = 2;
    //this.numWhite = 4;
  }
  public void shake(Random r) {
    int k = r.nextInt(this.getNumBlack() + this.getNumWhite());
    this.setBlack(k < this.getNumBlack());
  }
}
