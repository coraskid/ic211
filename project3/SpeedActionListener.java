import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SpeedActionListener implements ChangeListener {
  private JComboBox speedType;
  private JSlider speed;
  private Zoo zoo;

  public SpeedActionListener(JComboBox sT, JSlider sF, Zoo zoo){
    this.speedType = sT;
    this.speed = sF;
    this.zoo = zoo;
  }

  public void stateChanged(ChangeEvent e){
    int newSpeed = speed.getValue();
    String type = (String) speedType.getSelectedItem();
    int intType = 0;
    if (type.equals("Plankton")){
      intType = 1;
    }
    if (type.equals("SFish")){
      intType = 2;
    }
    if (type.equals("MFish")){
      intType = 3;
    }
    if (type.equals("Shark")){
      intType = 4;
    }
    zoo.changeSpeed(intType, newSpeed);
  }
}

