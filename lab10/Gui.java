import javax.swing.*;

public class LoanGui extends JFrame {
  private JTextField loanAmt;
  private JComboBox<Double> intRate;
  private JTextField monPay;
  private JTextField monToPayOff;
  private JTextField cost;
  private final double[] rates = {5.00, 5.25, 5.50, 5.75};


  public LoanGui() {

    loanAmt = new JTextField("10000.00", 10);
    intRate = new JComboBox<Double>(rates);
    monPay = new JTextField("250", 10);


    JPanel tPanel = new JPanel(new FlowLayout());
    tPanel.add(new JLabel("loan amount"));
    tPanel.add(loanAmt);
    tPanel.add(new JLabel("interest rate"));
    tPanel.add(intRate);
    tPanel.add(new JLabel("monthly payment"));
    tPanel.add(monPay);




    this.add(tPanel, BorderLayout.NORTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();//idk if needed?
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
