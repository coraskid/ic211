import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * This class listens for the clear button to be pressed
 * @author Cora Skidmore
 */
public class StatsActionListener implements ActionListener {
  private JButton clear;
  private JLabel typeF;
  private JLabel speedF;
  private JLabel healthF;
  /**
   * Constructor takes the clear button, the type label, speed label, and health
   * label
   * @param c clear button
   * @param t type label
   * @param s speed label
   * @param h health label
   */
  public StatsActionListener(JButton c, JLabel t, JLabel s, JLabel h){
    clear = c;
    typeF = t;
    speedF = s;
    healthF = h;
  }
  /**
   * Sets all of the labels to "-----" when buttons pressed
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e){
    typeF.setText("-----");
    speedF.setText("-----");
    healthF.setText("-----");
  }
}

