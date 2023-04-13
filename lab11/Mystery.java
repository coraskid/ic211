import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener {
  private JLabel label;
  private Thread prev;
  public Mystery(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    if(prev == null || !prev.isAlive()){
      Thread t = new CChange(label);
      t.start();
      prev = t;
    }
    
  }
}
