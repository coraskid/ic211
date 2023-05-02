/**
 * This class establishes an exception for anything having to do with animals
 * @author Cora Skidmore
 */
public class AnimalException extends RuntimeException{
  /**
   * Constructor: sets up exception based on message
   * @param msg error message
   */
  public AnimalException(String msg){
    super(msg);
  }
}
