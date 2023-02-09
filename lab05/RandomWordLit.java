/**
 * This class builds off of the RandomWord class by only producing words with
 * the same first letter
 * @author Cora Skidmore
 */
public class RandomWordLit extends RandomWord {

  private char start;
  
  /**
   * constructor
   * creates an instance of RandomWordLit given a seed
   * @param seed long representing the see you want to create your randomness
   * from
   */
  public RandomWordLit(long seed){
    super(seed);
  }

  /**
   * Overridding the next() method from RandomWord
   * Gives only words with the same first letter as the first random word
   * produced in the given instance
   * @return A string of the random word
   */
  public String next(){
    String next = super.next();
    if(this.start == '\u0000'){
      this.start = next.charAt(0);
      return next;
    }
    while(next.charAt(0) != this.start){
      next = super.next();
    }
    return next;
  }

}
