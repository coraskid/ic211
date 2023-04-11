import java.util.*;
public class Coin extends Piece {
  public void shake(Random r) {
    this.setBlack(r.nextBoolean());
  }


}
