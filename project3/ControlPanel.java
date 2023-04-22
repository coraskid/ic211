import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControlPanel extends JPanel{
  JLabel test;
  JTextField t2;

  public ControlPanel(){
    test = new JLabel("Working?");
    test.setPreferredSize(new Dimension(60,15));

    t2 = new JTextField("please", 10);
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS)); 
    p.add(test);
    p.add(t2);

    this.add(p, BorderLayout.NORTH);
  }

  public static void main(String[] args){
    ControlPanel f = new ControlPanel();
    //f.setTitle("HI?");
    //f.setResizable(false);
    //f.pack();
    f.setVisible(true);
  }


}
