import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PauseActionListener implements ActionListener {
  private JButton b;
  private MainThread t;
  private Zoo z;
  public PauseActionListener(JButton b, MainThread t, Zoo z){
    this.b = b;
    this.t = t;
    this.z = z;

  }

  public void actionPerformed(ActionEvent e){
    System.out.println("hi");
    if (t.isAlive()){
      t.kill();
      //Remove unused fish here?
      /*
      for(Animal i : z){
        if(!i.isAlive()){
          z.removeFish(i);
        }
      }*/
    } else {
      t = t.newCopy();
      t.start();
    }
  }
}
