import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L10Timer {
  /*
  public int getCount() {
    return Integer.parseInt(b1.getText());
  }*/
  public static void main(String[] args) {

    JLabel label = new JLabel(" DONE ");
    label.setForeground(Color.RED);
    label.setPreferredSize(new Dimension(60,15));

    JTextField b1 = new JTextField("10", 10);
    b1.addActionListener(new Toggler(label));

    JButton b2 = new JButton("countdown");
    b2.addActionListener(new CountClick(label, b1));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(label, BorderLayout.WEST);
    f.add(b1, BorderLayout.CENTER);
    f.add(b2, BorderLayout.EAST);
    f.pack();
    f.setVisible(true);

  }
}
