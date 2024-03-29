import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddActionListener implements ActionListener {
  private JButton addFish;
  private JComboBox addType;
  private Zoo zoo;
  private MainThread mt;

  public AddActionListener(JButton aF, JComboBox aT, Zoo zoo, MainThread t){
    this.addFish = aF;
    this.addType = aT;
    this.zoo = zoo;
    this.mt = t;
  }

  public void actionPerformed(ActionEvent e){
    String type = (String) addType.getSelectedItem();
    if (type.equals("Plankton")){
      zoo.addP();
    }
    if (type.equals("SFish")){
      zoo.addSF();
    }
    if (type.equals("MFish")){
      zoo.addMF();
    }
    if (type.equals("Shark")){
      zoo.addSh();
    }
    if(!mt.isAlive()){
      mt.deadPaint();
    }
  }
  


}
