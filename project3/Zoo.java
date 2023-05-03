import java.util.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * This class manages all of the fish as a whole in an arraylist;
 * controls species speed changes, adding species
 * @author Cora Skidmore
 */
public class Zoo extends ArrayList<Animal>{
  private TankSize ts;
  /**
   * Constructor, starts with 10 plankton, a shark, a small and medium fish
   * @param ts Tanksize
   */
  public Zoo(TankSize ts){
    super();
    this.ts = ts;
    //Plankton
    for(int i = 0; i < 10; i++){
      Plankton p = new Plankton(ts);
      this.add(p);
    }
    //Fish and shark
    SFish s = new SFish(ts);
    this.add(s);
    MFish m = new MFish(ts);
    this.add(m);
    Shark sh = new Shark(ts);
    this.add(sh);
  }
  /**
   * Adds 1 plankton
   */
  public void addP(){
    Plankton p = new Plankton(ts);
    this.add(p);
  }
  /**
   * Adds 1 small fish
   */
  public void addSF(){
    SFish s = new SFish(ts);
    this.add(s);
  }
  /**
   * Adds 1 medium fish
   */
  public void addMF(){
    MFish m = new MFish(ts);
    this.add(m);
  }
  /**
   * Adds 1 shark
   */
  public void addSh(){
    Shark sh = new Shark(ts);
    this.add(sh);
  }
  /**
   * Changes the speed of all of 1 species type
   * @param type species you want to change
   * @param speed new speed to change to
   */
  public void changeSpeed(int type, int speed){
    for(Animal i : this) {
      if(i.getType() == type){
        i.setSpeed(speed);
      }
    }
  }
  /**
   * Changes the metabolism of all of 1 species type
   * @param type species you want to change
   * @param metab new metabolism to change to
   */
  public void changeMetab(int type, int metab){
    for(Animal i : this) {
      if(i.getType() == type){
        i.setMetab(metab);
      }
    }
  }
  /**
   * Copies the array list of only alive fish
   * @return ArrayList of all alive Animals
   */
  public ArrayList<Animal> cpy(){
    ArrayList<Animal> cpy = new ArrayList<Animal>();
    for(Animal i : this){
      if(i.isAlive())
        cpy.add(i);
    }
    return cpy;
  }
  /**
   * This method removes fish in tohe array list - not currently used
   * @param i Animal to remove
   */
  public void removeFish(Animal i){
    try{
      this.remove(i);
    } catch (Exception e){}
  }
  /**
   * Check if a mouse click was on an animal, otherwise throws an
   * AnimalException
   * @param xClick double x coord
   * @param yClick double y coord
   * @return Animal that was clicked
   */
  public Animal checkClicked(double xClick, double yClick){
    for(Animal i : this){
      if(i.getShape().contains(xClick, yClick) && i.getType() != 1){
        return i;
      }
    }
    throw new AnimalException("Fish not found");
  }
}
