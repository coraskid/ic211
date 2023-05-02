import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * This class listens to any change in the slider for the metabolism
 * @author Cora Skidmore
 */
public class MetabActionListener implements ChangeListener {
  private JComboBox metabType;
  private JSlider metab;
  private Zoo zoo;
  /**
   * Constructor takes the combo box for the type of fish, the slider for
   * changed metabolism, and the zoo to actually change evething of that type
   * @param mT metabType combo box
   * @param mF metabSlider
   * @param zoo the Zoo
   */ 
  public MetabActionListener(JComboBox mT, JSlider mF, Zoo zoo){
    this.metabType = mT;
    this.metab = mF;
    this.zoo = zoo;
  }
  /**
   * Will change the metabolism based on the slider changing
   * @param e ChangeEvent
   */
  public void stateChanged(ChangeEvent e){
    int newMetab = metab.getValue();
    String type = (String) metabType.getSelectedItem();
    int intType = 0;
    if (type.equals("SFish")){
      intType = 2;
    }
    if (type.equals("MFish")){
      intType = 3;
    }
    if (type.equals("Shark")){
      intType = 4;
    }
    zoo.changeMetab(intType, newMetab);
  }
}

