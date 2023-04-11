import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoanGui extends JFrame {
  private JTextField loanAmt;
  private JComboBox<String> intRate;
  private JTextField monPay;
  private JTextField monToPayOff;
  private JTextField cost;
  private JButton calc;
  private final String[] rates = {"3.50", "3.75", "4.00", "4.25", "4.50", "4.75", "5.00", "5.25", "5.50", "5.75", "6.00", "6.25", "6.50", "6.75", "7.00", "7.25", "7.50"}; //FINISH THIS

  
  public LoanGui() {

    loanAmt = new JTextField("10000.00", 10);
    intRate = new JComboBox<String>(rates);
    monPay = new JTextField("250", 10);
    monToPayOff = new JTextField("45", 10);
    cost = new JTextField("1128.33", 10);
    calc = new JButton("calculate");
    monToPayOff.setEditable(false);
    cost.setEditable(false);

    JPanel tPanel = new JPanel(new FlowLayout());
    tPanel.add(new JLabel("loan amount"));
    tPanel.add(loanAmt);
    tPanel.add(new JLabel("interest rate"));
    tPanel.add(intRate);
    tPanel.add(new JLabel("monthly payment"));
    tPanel.add(monPay);

    JPanel mPanel = new JPanel();
    mPanel.add(new JLabel("months to payoff"));
    mPanel.add(monToPayOff);
    JPanel cPanel = new JPanel();
    cPanel.add(new JLabel("cost"));
    cPanel.add(cost);

    ActionListener a = new LoanActionListener(this);
    calc.addActionListener(a);


    this.add(tPanel, BorderLayout.NORTH);
    this.add(mPanel, BorderLayout.CENTER);
    this.add(cPanel, BorderLayout.SOUTH);
    this.add(calc, BorderLayout.EAST);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Skidmore, Corinna - m255844");
    this.pack();//idk if needed?
  }
  
  public double getLoanAmt() {
    return Double.parseDouble(loanAmt.getText());
  }

  public double getRate() {
    return Double.parseDouble((String)intRate.getSelectedItem());
  }

  public double getMonPay() {
    return Double.parseDouble(monPay.getText());
  }
  public void setCost(String c) {
    cost.setText(c);
  }
  public void setMonToPay(String m) {
    monToPayOff.setText(m);
  }


  public static void main(String[] args){
    JFrame f = new JFrame();
    f.setTitle("Skidmore, Corinna - m255844");
    f.setSize(300,400);
    f.setLocation(100,100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);


  }
}
