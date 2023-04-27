import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class DrawArea extends JComponent {
  private Ball ball;
  
  public DrawArea() {
    super();
    setPreferredSize(new Dimension(400, 400));
    ball = new Ball(200, 200);
    ball.setGoal(10, 20);
    addMouseListener(ball);
  }

  public void step() {
    ball.step();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    // This voodoo makes the output prettier
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);

    //here's the code for our ball
    ball.paint(g2);

    // This is an unfortunate necessity
    // that forces the underlying OS
    // windowing system to actually
    // show the updates we've made
    Toolkit.getDefaultToolkit().sync();
  }
}
