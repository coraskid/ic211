import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PauseActionListener implements ActionListener {
  private JButton b;
  private Proj t;

  public PauseActionListener(JButton b, Proj t){
    this.b = b;
    this.t = t;

  }

  public void actionPerformed(ActionEvent e){
    System.out.println("hi");
    t.turnOnOff();
/*
    if (t.isAlive()){
      t.kill();
    } else {
      t = t.newCopy();
      t.start();
    } */
  } 
}
