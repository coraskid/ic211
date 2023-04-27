import java.awt.*;
import javax.swing.*;

//uses class notes

public class Proj {

  public class MainThread extends Thread {
    private DrawAq da;
    private boolean kill;

    public MainThread(DrawAq d) {
      da = d;
      kill = false;
    }

    public void run() {
      while (!kill) {
        try {
          Thread.sleep(10);
        } catch (Exception e) {}
        da.step();

        da.overlap();
        //check overlaps
        da.repaint();
      }
    }
    public void kill(){
      this.kill = true;
    }
    public void deadPaint(){
      da.repaint();
    }

    public MainThread newCopy(){
      return new MainThread(da);
    }
  }

  private JFrame f;
  private MainThread t;
  public Proj(DrawAq da){
    this.f = new JFrame();
    this.t = new MainThread(da);

  }
  public void turnOnOff(){
    if(this.t.isAlive()){
      this.t.kill();
    } else {
      this.t = t.newCopy();
      this.t.start();
    }
  }
  public void ifDeadPaint(){
    if(!this.t.isAlive()){
      this.t.deadPaint();
    }
  }
  public void start(){
    this.t.start();
  }
  public static void main(String[] args) {
    //JFrame   f = new JFrame();
    TankSize ts = new TankSize();
    Zoo zoo = new Zoo(ts);
    //do without args[0] 
    DrawAq d = new DrawAq(args[0], zoo, ts);
    //MainThread t = new MainThread(d);
    Proj full = new Proj(d);
    ControlPanel cp = new ControlPanel(full, zoo);
    full.f.add(d);
    full.f.add(cp, BorderLayout.WEST);
    full.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    full.f.pack();
    full.f.setVisible(true);
    //sleep(5);
    full.start();
    //zoo.changeSpeed(1, 4);


  }
}
