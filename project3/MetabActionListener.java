import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MetabActionListener implements ChangeListener {
  private JComboBox metabType;
  private JSlider metab;
  private Zoo zoo;

  public MetabActionListener(JComboBox mT, JSlider mF, Zoo zoo){
    this.metabType = mT;
    this.metab = mF;
    this.zoo = zoo;
  }

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

