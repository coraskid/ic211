import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PauseActionListener implements ActionListener {
  private JButton b;
  private MainThread t;

  public PauseActionListener(JButton b, MainThread t){
    this.b = b;
    this.t = t;

  }

  public void actionPerformed(ActionEvent e){
    System.out.println("hi");
    if (t.isAlive()){
      t.kill();
    } else {
      t = t.newCopy();
      t.start();
    }
  }
}
