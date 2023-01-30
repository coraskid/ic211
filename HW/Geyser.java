import java.util.*;
public class Geyser {
  private String name;
  private double baseProbFactor;
  private int    daysSinceLastBlow;

  private Geyser(String n, double basePF, int daysSLB){
    this.name = n;
    this.baseProbFactor = basePF;
    this.daysSinceLastBlow = daysSLB;
  }
  /**
   * reads (and returns) geyser in the following format
   * <name> <initBlowProb> <days>
   */
  public static Geyser read(Scanner sc){
    String name           = sc.next();
    double baseProbFactor = 1.0 - sc.nextDouble();
    int daysSinceLastBlow = sc.nextInt();
    
    Geyser g = new Geyser(name, baseProbFactor, daysSinceLastBlow);
    return g;
  }
  /**
   * Simulate one day.  If g doesn't blow, return -1
   * if g blows, return number of days since last blow
   */

  public int simDay(Random r){
    int tmp = ++this.daysSinceLastBlow;
    double blowProb = 1 - Math.pow(this.baseProbFactor, tmp);

    if(r.nextDouble() <= blowProb){
      this.daysSinceLastBlow = 0;
    }
    else{
      tmp = -1;
    }
    return tmp;
  }

  /**
   * Simulate day d for array G of geysers & output results
   */
  public static void simDay(int d, Geyser[] G, Random r) {
    int k = 0;

    System.out.print("Day " + d + ":");

    for (int i = 0; i < G.length; i++) {
      if (G[i].simDay(r) != -1) {
        System.out.print((k++ > 0 ? ", " : " ") + G[i].name);
      }
    }
    System.out.println();
  }
}
