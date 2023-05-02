import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class StatsActionListener implements ActionListener {
  private JButton clear;
  private JLabel typeF;
  private JLabel speedF;
  private JLabel healthF;

  public StatsActionListener(JButton c, JLabel t, JLabel s, JLabel h){
    clear = c;
    typeF = t;
    speedF = s;
    healthF = h;
  }

  public void actionPerformed(ActionEvent e){
    typeF.setText("-----");
    speedF.setText("-----");
    healthF.setText("-----");
  }
}

