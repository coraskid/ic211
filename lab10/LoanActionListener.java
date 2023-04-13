/**
 * This class runs the listener for when anything happens in the window and what
 * to do if it does
 * @author Cora Skidmore
 */

import java.awt.event.*;

class LoanActionListener implements ActionListener {
  private LoanGui lg;
  /**
   * Constructor
   * @param lg the loanGui
   */
  public LoanActionListener(LoanGui lg){
    this.lg = lg;
  }
  /**
   * Tells you what to do when an action event happens
   * @param e specific action event
   */
  public void actionPerformed(ActionEvent e) {
    double amount = lg.getLoanAmt();
    double rate = lg.getRate();
    double pay = lg.getMonPay();
    financeStuff a = null;
    try {
      a = new financeStuff(amount, rate, pay);
    } catch(InfinateLoanException ile){

      lg.setCost("infinate");
      lg.setMonToPay("infinate");
      return;
    } 
    lg.setCost("" + a.getCost());
    lg.setMonToPay("" + a.getMonths());
   }
}

