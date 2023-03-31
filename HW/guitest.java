import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterWindow extends JFrame {
  private JTextField fromValue;
  private JTextField toValue;
  private JComboBox<String> fromUnits;
  private JComboBox<String> toUnits;
  private final String[] units = {
    "feet", "inches", "meters", "centimeters"
  };
  private final double[] cfact = {
    1.0000, 1.0 / 12, 3.28084, 0.0328084
  };

  class ConverterActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Response to any action is to update toValue based on the values
      // of fromUnits, toUnits and fromValue.,
      double fv = Double.parseDouble(fromValue.getText());
      String fu = (String)fromUnits.getSelectedItem();
      String tu = (String)toUnits.getSelectedItem();
      int    i  = 0;

      while (i < units.length && !units[i].equals(fu)) {
        ++i;
      }

      int j = 0;

      while (j < units.length && !units[j].equals(tu)) {
        ++j;
      }
      double tv = fv * cfact[i] / cfact[j];
      double wp = Math.round(tv * 10000) / 10000.0;
      toValue.setText("" + wp);
    }
  }

  public ConverterWindow() {
    // Create the four interactive elements of the GUI
    fromValue = new JTextField("1.0", 10);
    toValue   = new JTextField("1.0", 10);
    fromUnits = new JComboBox<String>(units);
    toUnits   = new JComboBox<String>(units);
    toValue.setEditable(false);

    // Create panel with flow layout and add GUI elements
    JPanel dpanel = new JPanel(new FlowLayout());
    dpanel.add(new JLabel("from: "));
    dpanel.add(fromValue);
    dpanel.add(fromUnits);
    dpanel.add(new JLabel(" to: "));
    dpanel.add(toValue);
    dpanel.add(toUnits);

    // Create the ConverterActionListener and set it to listen
    // for any changes to the three editable elements of the GUI
    ActionListener a = new ConverterActionListener();
    fromValue.addActionListener(a);
    fromUnits.addActionListener(a);
    toUnits.addActionListener(a);

    // Add panel to the frame, and do some bookkeeping on frame
    this.add(dpanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
