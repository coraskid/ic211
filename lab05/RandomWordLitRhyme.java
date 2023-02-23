/**
 * This class builds off of the RandomWordLit class by only producing words with
 * the same last two letters
 * @author Cora Skidmore
 */
public class RandomWordLitRhyme extends RandomWordLit {

  private String end;

  /**
   * constructor
   * creates an instance of RandomWordLit given a seed
   * @param seed long representing the see you want to create your randomness
   * from
   */
  public RandomWordLitRhyme(long seed) {
    super(seed);
  }

  /**
   * Overridding the next() method from RandomWordLit
   * Gives only words with the same last two letters as the first random word
   * produced in the given instance
   * @return A string of the random word
   */
  public String next(){
    String next = super.next();
    if(this.end == null){
      this.end = next.substring(next.length() -2);
      return next;
    }
    while(!next.substring(next.length() -2).equals(this.end)){
      next = super.next();
    }
    return next;
    
  }

}
