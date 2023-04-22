import java.awt.*;
import javax.swing.*;

//uses class notes

public class Proj {
  public static class MainThread extends Thread {
    private DrawAq da;
    
    public MainThread(DrawAq d) {
      da = d;
    }
    
    public void run() {
      while (true) {
        try {
          Thread.sleep(20);
        } catch (Exception e) {}
        da.step();
        da.repaint();
      }
    }
    
  }

  public static void main(String[] args) {
    JFrame   f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    DrawAq d = new DrawAq(args[0]);
    ControlPanel cp = new ControlPanel();
    f.add(d);
    f.add(cp, BorderLayout.WEST);
    f.pack();
    f.setVisible(true);
    Thread t = new MainThread(d);
    t.start();
  }
}
