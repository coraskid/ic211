import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class listens for the add fish button to be pressed
 * @author Cora Skidmore
 */
public class AddActionListener implements ActionListener {
  private JButton addFish;
  private JComboBox addType;
  private Zoo zoo;
  private MainThread mt;

  /**
   * Constructor takes the button, the combo box for the type of fish, the zoo
   * to update the fish, and the main thread to make sure fish get added even if
   * paused
   * @param aF addFish button
   * @param aT addType combo box
   * @param zoo the Zoo
   * @param t main thread
   */
  public AddActionListener(JButton aF, JComboBox aT, Zoo zoo, MainThread t){
    this.addFish = aF;
    this.addType = aT;
    this.zoo = zoo;
    this.mt = t;
  }
  /**
   * Will add a fish to the tank based on the type selected
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e){
    String type = (String) addType.getSelectedItem();
    if (type.equals("Plankton")){
      zoo.addP();
    }
    if (type.equals("Small Fish")){
      zoo.addSF();
    }
    if (type.equals("Medium Fish")){
      zoo.addMF();
    }
    if (type.equals("Shark")){
      zoo.addSh();
    }
    if (type.equals("10 Plankton")){
      for(int i = 0; i < 10; i++)
        zoo.addP();
    }
    //Adds fish and paints them even if the thread is paused
    if(!mt.isAlive()){
      mt.deadPaint();
    }
  }
  


}
