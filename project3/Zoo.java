import java.util.*;

public class Zoo extends ArrayList<Animal>{

  public Zoo(){
    super();

    for(int i = 0; i < 10; i++){
      Plankton p = new Plankton();
      this.add(p);
    }
  }
  
  public void addP(){
    Plankton p = new Plankton();
    this.add(p);
  }


}
