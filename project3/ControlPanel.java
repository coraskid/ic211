import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControlPanel extends JPanel{
  private JLabel test;
  private JTextField t2;
  private JButton onOff;
  private JComboBox addType;
  private JButton addFish;
  private final String[] types = {"Shark", "MFish", "SFish", "Plankton"};

  public ControlPanel(MainThread t, Zoo zoo){
    test = new JLabel("Working?");
    test.setPreferredSize(new Dimension(60,15));

    t2 = new JTextField("please", 10);
    
    addType = new JComboBox<String>(types);
    addFish = new JButton("Add");
    addFish.addActionListener(new AddActionListener(addFish, addType, zoo, t));
    JPanel addPanel = new JPanel(new FlowLayout());
    addPanel.add(addType);
    addPanel.add(addFish);

    

    onOff = new JButton("Run/Pause");
    onOff.addActionListener(new PauseActionListener(onOff, t));
    
    //full vertical layout of panel
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS)); 
    p.add(onOff);
    p.add(addPanel);
    p.add(test);
    p.add(t2);

    this.add(p, BorderLayout.NORTH);
  }

  public static void main(String[] args){
    //ControlPanel f = new ControlPanel();
    //f.setTitle("HI?");
    //f.setResizable(false);
    //f.pack();
    //f.setVisible(true);
  }


}
