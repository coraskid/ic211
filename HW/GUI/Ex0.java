import java.awt.*;
import javax.swing.*;

public class Ex0 {
  public static void main(String[] args) {
    String  s = "Attention Please: This is a button";
    JFrame  f = new JFrame();
    JButton b = new GraffitiButton(s);

    b.setPreferredSize(new Dimension(320, 40));
    f.add(b);
    f.pack();
    f.setVisible(true);
  }
}
