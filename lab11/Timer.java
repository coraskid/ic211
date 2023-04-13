import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Timer extends Thread {
  private int amount;
  private JLabel label;

  public Timer(int a, JLabel l){
    label = l;
    amount = a;
  }

  public void run() {
    for(int i = amount; i > 0; i--){
      label.setText("" + i);
      try{
        Thread.sleep(1000);
      } catch(InterruptedException ie){
        System.out.println("IDK what to do heree :)");
      }
    }
    label.setText("DONE");

  }
}
