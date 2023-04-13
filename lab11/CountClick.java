import javax.swing.*;
import java.awt.event.*;

public class CountClick implements ActionListener {

  private JLabel label;
  private JTextField b1;
  private Thread prev;
  public CountClick(JLabel label, JTextField b) {
    this.label = label;
    this.b1 = b;
  }

  public void actionPerformed(ActionEvent e) {
    
    if(prev == null || !prev.isAlive()){
      int time = -1;
      try{
        time = Integer.parseInt(label.getText());
      } catch (NumberFormatException nfe) {
        label.setText("ERROR");
        return;
      }
      if(time < 0){
        label.setText("ERROR");
        return;
      }
      Thread t = new Timer(time, label);
      t.start();
      prev = t;
    }
    
  }
}
