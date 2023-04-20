import java.awt.*;
import javax.swing.*;

//uses class notes

public class Proj {
  public static class MainThread extends Thread {
    private DrawAq da;
    
    public MainThread(DrawAq d) {
      da = d;
    }
    /*
    public void run() {
      while (true) {
        try {
          Thread.sleep(20);
        } catch (Exception e) {}
        da.step();
        da.repaint();
      }
    }
    */
  }

  public static void main(String[] args) {
    JFrame   f = new JFrame();
    DrawAq d = new DrawAq(args[0]);

    f.add(d);
    f.pack();
    f.setVisible(true);
    //Thread t = new MainThread(d);
    //t.start();
  }
}
