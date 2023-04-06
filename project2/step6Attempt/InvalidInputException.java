/**
 * This class handles Invalid inputs and saves the char that was causing the
 * invalid input
 * @author Cora Skidmore
 */
public class InvalidInputException extends RuntimeException{
  private char error;
  /**
   * Standard Constructor
   * @param msg message
   */
  public InvalidInputException(String msg){
    super(msg);
  }
  /**
   * Constructor that also saves the problematic char
   * @param msg message
   * @param err problamatic char
   */
  public InvalidInputException(String msg, char err){
    super(msg);
    error = err;
  }
  /**
   * return the problematic char
   * @return problematic char
   */
  public char getCharError(){
    return error;
  }
}
