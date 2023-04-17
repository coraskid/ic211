import java.awt.*;
import javax.swing.*;

public class GraffitiButton extends JButton {
  public GraffitiButton(String s) {
    super(s);
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(75, 5, 140, 15);
    g.setColor(Color.RED);
    g.drawString("this button stinks!", 80, 18);
  }
}
