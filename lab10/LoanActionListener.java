import java.awt.event.*;

class LoanActionListener implements ActionListener {
  private LoanGui lg;
  public LoanActionListener(LoanGui lg){
    this.lg = lg;
  }

  public void actionPerformed(ActionEvent e) {
    double amount = lg.getLoanAmt();
    double rate = lg.getRate();
    double pay = lg.getMonPay();
    financeStuff a = new financeStuff(amount, rate, pay);
    try {
      lg.setCost("" + a.getCost());
      lg.setMonToPay("" + a.getMonths());
    } catch (InfinateLoanException ile){
      lg.setCost("infinate");
      lg.setMonToPay("infinate");
    }



   }
}

