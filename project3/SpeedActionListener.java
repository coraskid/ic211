import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class listens to any change in the slider for the speed
 * @author Cora Skidmore
 */
public class SpeedActionListener implements ChangeListener {
  private JComboBox speedType;
  private JSlider speed;
  private Zoo zoo;

  /**
   * Constructor takes a combo box for the type of fish, the slider for the
   * changed speed, and the zoo to actually change everything of that type
   * @param sT speedType combo box
   * @param sF speed slider
   * @param zoo the zoo
   */
  public SpeedActionListener(JComboBox sT, JSlider sF, Zoo zoo){
    this.speedType = sT;
    this.speed = sF;
    this.zoo = zoo;
  }

  /**
   * Will change the speed based on the slider changing
   * @param e ChangeEvent
   */
  public void stateChanged(ChangeEvent e){
    int newSpeed = speed.getValue();
    String type = (String) speedType.getSelectedItem();
    int intType = 0;
    if (type.equals("Small Fish")){
      intType = 2;
    }
    if (type.equals("Medium Fish")){
      intType = 3;
    }
    if (type.equals("Shark")){
      intType = 4;
    }
    zoo.changeSpeed(intType, newSpeed);
  }
}

