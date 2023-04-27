import java.awt.*;
import javax.swing.*;

public class Ex3 {
  public static class AniThread extends Thread {
    private DrawArea da;
    
    public AniThread(DrawArea d) {
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
    DrawArea d = new DrawArea();

    f.add(d);
    f.pack();
    f.setVisible(true);
    Thread t = new AniThread(d);
    t.start();
  }
}
