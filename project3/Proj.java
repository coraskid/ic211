import java.awt.*;
import javax.swing.*;

//uses class notes

public class Proj {
  
  public static void main(String[] args) {
    JFrame   f = new JFrame();
    TankSize ts = new TankSize();
    Zoo zoo = new Zoo(ts);
    
    DrawAq d = new DrawAq(args[0], zoo, ts);
    MainThread t = new MainThread(d);
    ControlPanel cp = new ControlPanel(t, zoo);
    f.add(d);
    f.add(cp, BorderLayout.WEST);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.pack();
    f.setVisible(true);
    t.start();
    zoo.changeSpeed(1, 4);
  }
}
