import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
/**
 * This class controls all of the GUI controls on the left side
 * @author Cora Skidmore
 */
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
  private Stats stat;
  private final String[] types = {"Shark", "Medium Fish", "Small Fish", "Plankton", "10 Plankton"};
  /**
   * Constructor: sets up all of the controls
   * @param t main thread (for pauseActionLsitener)
   * @param zoo the zoo
   * @param s the stats panel
   */
  public ControlPanel(MainThread t, Zoo zoo, Stats s){
    //Add fish panel
    addType = new JComboBox<String>(types);
    addFish = new JButton("Add");
    addFish.addActionListener(new AddActionListener(addFish, addType, zoo, t));
    JPanel addPanel = new JPanel(new FlowLayout());
    addPanel.add(addType);
    addPanel.add(addFish);
    //Speed controls
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
    //metabolism controls
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
    //on off button
    onOff = new JButton("Run/Pause");
    onOff.addActionListener(new PauseActionListener(onOff, t));
    //stats
    stat = s;
    //full vertical layout of panel
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS)); 
    p.add(onOff);
    p.add(addPanel);
    p.add(speedPanel);
    p.add(metabPanel);
    p.add(stat);
    this.add(p, BorderLayout.NORTH);
  }
}
