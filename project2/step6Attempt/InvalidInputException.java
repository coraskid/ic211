public class InvalidInputException extends RuntimeException{
  private char error;
  public InvalidInputException(String msg){
    super(msg);
  }
  public InvalidInputException(String msg, char err){
    super(msg);
    error = err;
  }
  public char getCharError(){
    return error;
  }

}
