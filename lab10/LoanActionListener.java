import java.awt.event.*;

class LoanActionListener implements ActionListener {
  private LoanGui lg;
  public LoanActionListener(LoanGui lg){
    this.lg = lg;
  }

  public void actionPerformed(ActionEvent e) {
    double la = lg.getLoanAmt();
    lg.setCost(la);



   }
}

