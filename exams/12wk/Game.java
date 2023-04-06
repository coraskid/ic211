//Cora Skidmore

import java.util.*;

public class Game {

  public static void main(String[] args) {
    int seed = 0;
    if( args.length == 1 )
      seed = Integer.parseInt(args[0]);
    Random r = new Random(seed);

    Piece[] P = new Piece[3];
    P[0] = new Ball(r.nextBoolean());
    P[1] = new Coin();
    P[2] = new Dice();
    
    for( int j = 0; j < 10; j++ ) {
      for( int i = 0; i < P.length; i++ ) {
        P[i].shake(r);
        if( P[i].getBlack() )
          System.out.print("B");
        else
          System.out.print("W");
      }
      System.out.println();
    }
  }
}
