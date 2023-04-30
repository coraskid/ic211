import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
public class ControlPanel extends JPanel{
  private JLabel test;
  private JTextField t2;
  private JButton onOff;
  private JComboBox addType;
  private JButton addFish;
  private JComboBox speedType;
  private JSlider speedChange;
  private JLabel speedTitle;
  private JComboBox metabType;
  private JSlider metabChange;
  private JLabel metabTitle;
  private final String[] types = {"Shark", "MFish", "SFish", "Plankton", "10 Plankton"};

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
  
    speedType = new JComboBox<String>(Arrays.copyOfRange(types, 0, 3));
    speedChange = new JSlider(1, 15, 1);
    speedChange.setMinorTickSpacing(1);
    speedChange.setPaintTicks(true);
    speedChange.addChangeListener(new SpeedActionListener(speedType, speedChange, zoo));
    speedTitle = new JLabel("SPEED");
    JPanel speedPanel = new JPanel(new BorderLayout());
    speedPanel.add(speedType, BorderLayout.WEST);
    speedPanel.add(speedChange, BorderLayout.EAST);
    speedPanel.add(speedTitle, BorderLayout.NORTH);

    metabType = new JComboBox<String>(Arrays.copyOfRange(types, 0, 3));
    metabChange = new JSlider(1, 15, 1);
    metabChange.setMinorTickSpacing(1);
    metabChange.setPaintTicks(true);
    metabChange.addChangeListener(new MetabActionListener(metabType, metabChange, zoo));
    metabTitle = new JLabel("METABOLISM");
    JPanel metabPanel = new JPanel(new BorderLayout());
    metabPanel.add(metabType, BorderLayout.WEST);
    metabPanel.add(metabChange, BorderLayout.EAST);
    metabPanel.add(metabTitle, BorderLayout.NORTH);

 
    

    onOff = new JButton("Run/Pause");
    onOff.addActionListener(new PauseActionListener(onOff, t, zoo));
    
    //full vertical layout of panel
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS)); 
    p.add(onOff);
    p.add(addPanel);
    p.add(speedPanel);
    p.add(metabPanel);
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
