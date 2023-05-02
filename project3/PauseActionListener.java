import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class listens for the on/off button to be pressed
 * @author Cora Skidmore
 */
public class PauseActionListener implements ActionListener {
  private JButton b;
  private MainThread t;
  private Zoo z;
  /**
   * Constructor takes the on/off button, the main thread and teh zoo
   * @param b on/off button
   * @param t main thread
   * @param z the Zoo
   */
  public PauseActionListener(JButton b, MainThread t, Zoo z){
    this.b = b;
    this.t = t;
    this.z = z;

  }
  /**
   * This is where the thread will be killed or restarted based on its current
   * state
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e){
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
