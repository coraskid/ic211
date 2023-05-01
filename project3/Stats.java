import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stats implements JPanel, MouseListener {
  private double clickX, clickY;
  private Zoo zoo;


  public Stats(Zoo zoo) {
    this.zoo = zoo;
    title = new JLabel("Fish Stats");
    clear = new JButton("Clear Stats");
    

    

    JPanel main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
    


  }

  public void setGoal(double gx, double gy) {
    goalx = gx;
    goaly = gy;
  }

  public void mouseClicked(MouseEvent e) {
    setGoal(e.getX(), e.getY());
  }

  public void mouseEntered(MouseEvent e)  {}

  public void mouseExited(MouseEvent e)   {}

  public void mousePressed(MouseEvent e)  {}

  public void mouseReleased(MouseEvent e) {}
}
