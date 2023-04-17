import java.awt.*;
import javax.swing.*;

public class Ex2 {
  public static void main(String[] args) {
    JFrame f     = new JFrame();
    JComponent c = new DrawArea();

    f.add(c);
    f.pack();
    f.setVisible(true);
  }
}
