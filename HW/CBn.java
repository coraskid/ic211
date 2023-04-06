import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBn extends JButton implements ActionListener, WindowListener {
  private int count = 0;

  public void windowActivated(WindowEvent e) {}
  public void windowClosed(WindowEvent e)    {}
  public void windowClosing(WindowEvent e) {
    System.out.println("Button clicked " + count + " times.");
  }
  public void windowDeactivated(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowIconified(WindowEvent e)   {}
  public void windowOpened(WindowEvent e)      {}
  
  public CBn(String label) {
    super(label);
    this.addActionListener(this);
    //this.addWindowListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    count++;
  }
}
