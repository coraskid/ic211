/**
 * This class just holds the current tanksize for all the animals to use
 * @author Cora Skidmore
 */
public class TankSize {
  private int horz;
  private int vert;

  /**
   * Constructor: initial values are some what arbitrary, but allows fish to go
   * to the generally correct location
   */
  public TankSize(){
    horz = 4496;
    vert = 3000;
  }
  /**
   * Returns the horzional length of the tank
   * @return int horizontal length
   */
  public int getHorz(){
    return horz;
  }
  /**
   * Returns the vertical length of the tank
   * @return int vertical length
   */
  public int getVert(){
    return vert;
  }
  /**
   * Sets the horizontal length of the tank
   * @param h new horizontal length
   */
  public void setHorz(int h){
    horz = h;
  }
  /**
   * Sets the vertical length of the tank
   * @param v new vertical length
   */
  public void setVert(int v){
    vert = v;
  }
}
