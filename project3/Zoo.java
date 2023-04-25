import java.util.*;

public class Zoo extends ArrayList<Animal>{
  private TankSize ts;
  public Zoo(TankSize ts){
    super();
    this.ts = ts;
    for(int i = 0; i < 10; i++){
      Plankton p = new Plankton(ts);
      this.add(p);
    }
    SFish s = new SFish(ts);
    this.add(s);
  }
  
  public void addP(){
    Plankton p = new Plankton(ts);
    this.add(p);
  }


}
