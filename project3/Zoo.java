import java.util.*;
import java.awt.*;
import java.awt.geom.*;

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
    MFish m = new MFish(ts);
    this.add(m);
    Shark sh = new Shark(ts);
    this.add(sh);
  }
  
  public void addP(){
    Plankton p = new Plankton(ts);
    this.add(p);
  }
  public void addSF(){
    SFish s = new SFish(ts);
    this.add(s);
  }
  public void addMF(){
    MFish m = new MFish(ts);
    this.add(m);
  }
  public void addSh(){
    Shark sh = new Shark(ts);
    this.add(sh);
  }

  public void changeSpeed(int type, int speed){
    for(Animal i : this) {
      if(i.getType() == type){
        i.setSpeed(speed);
      }
    }
  }

  public void changeMetab(int type, int metab){
    for(Animal i : this) {
      if(i.getType() == type){
        i.setMetab(metab);
      }
    }
  }

  //only alive fish
  public ArrayList<Animal> cpy(){
    ArrayList<Animal> cpy = new ArrayList<Animal>();
    for(Animal i : this){
      if(i.isAlive())
        cpy.add(i);
    }
    /*
    try {
      cpy = (ArrayList<Animal>) this.clone();
    } catch (Exception e){} */
    return cpy;
  }
/*
  public void overlap(){
    ArrayList<Animal> cpy = (ArrayList<Animal>) this.clone(); 
    for(Animal i : cpy){

      for(Animal j : cpy){
        int iT = i.getType();
        int jT = j.getType();
        if((iT == 4 && (jT == 2 || jT == 3)) || ((iT == 2 || iT == 3) && jT == 1)){
          //System.out.println("checking");
          if(j.getShape().intersects((Rectangle2D)i.getShape())){
            System.out.println("test!");
            j.kill();
          }
        }



      }
    }

    for(Animal i : this){
      if(i.isAlive()){
        this.removeFish(i);
      }
    }
    //this = cpy;
  } */

  public void removeFish(Animal i){
    try{
      this.remove(i);
    } catch (Exception e){}
  }


}
