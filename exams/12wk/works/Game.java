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
    /*
    P[0] = new Piece();
    P[0].what = 0;
    P[0].black = r.nextBoolean();
    P[0].numBlack = P[0].numWhite = 0;
    P[1] = new Piece();
    P[1].what = 1;
    P[1].black = false;
    P[1].numBlack = P[1].numWhite = 0;
    P[2] = new Piece();
    P[2].what = 2;
    P[2].black = false;
    P[2].numBlack = 2;
    P[2].numWhite = 4;
    */
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
