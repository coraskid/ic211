import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ball implements MouseListener {
  private double goalx, goaly;
  private double x, y, r, delta;
  
  public Ball(double x, double y) {
    this.x = x;
    this.y = y;
    r = 4;
    delta = 2;
  }

  public void setGoal(double gx, double gy) {
    goalx = gx;
    goaly = gy;
  }

  public void step() {
    double a = Math.atan2(goaly - y, goalx - x);

    x += delta * Math.cos(a);
    y += delta * Math.sin(a);
  }

  public void paint(Graphics2D g) {
    g.fill(new Ellipse2D.Double(x + r, y + r, 2 * r, 2 * r));
  }

  public void mouseClicked(MouseEvent e) {
    setGoal(e.getX(), e.getY());
  }

  public void mouseEntered(MouseEvent e)  {}

  public void mouseExited(MouseEvent e)   {}

  public void mousePressed(MouseEvent e)  {}

  public void mouseReleased(MouseEvent e) {}
}
