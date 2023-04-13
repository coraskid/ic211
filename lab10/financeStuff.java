/**
 * This class is essentially a loan calculator
 * @author Cora Skidmore
 */

import java.util.*;

public class financeStuff {
  private double amt;
  private double bal;
  private double rate;
  private double payment;
  private int months = 0;
  private double cost;
  /**
   * Constructor that establishes the parameters of a loan
   * @param a the amount
   * @param r the rate
   * @param p the monthly payment
   */
  public financeStuff(double a, double r, double p){
    amt = a;
    rate = r;
    payment = p;
    bal = a;
    while(bal > 0) {
      this.addMonInterest();
      this.payMon();
    }
    cost = this.calcCost();
    cost = moneyRound(cost);
  }
  /**
   * This method adds the interest and creates a new balance
   * math helper function
   * Throws an exception if there you will never pay off your loan
   */
  public void addMonInterest() throws InfinateLoanException{
    double interest = (bal*rate)/1200;
    bal = bal + interest;
    if (interest > payment) {
      throw new InfinateLoanException("You will never pay it off");
    }
  }
  /**
   * This method adds a month and makes a monthly payment
   * math helper function
   */
  public void payMon(){
    bal = bal - payment;
    months++;
  }
  /**
   * This method calculates the total cost of the loan
   * @return the total cost
   */
  public double calcCost(){
    double totalPaid = months * payment;
    double cost = totalPaid + bal - amt;
    return cost;

  }
  /**
   * This method rounds a double to two decimal points
   * @param c double you want to round
   * @return rounded double
   */
  public static double moneyRound(double c){
    return ((int)Math.round(c*100))/100.00;
  }
  /**
   * Returns the amount of months it will take to pay off
   * @return number of months to pay off
   */
  public int getMonths(){
    return this.months;
  }
  /**
   * Returns the total cost of the loan
   * @return cost of the loan
   */
  public double getCost(){
    return this.cost;
  }
  public static void main(String[] args){
    if(args.length != 3){
      System.out.println("usage: java Calc <amount> <rate> <payment>");
      System.exit(1);
    }
    double amount = 0, rate = 0, payment = 0;
    try {
      amount = Double.parseDouble(args[0]);
      rate = Double.parseDouble(args[1]);
      payment = Double.parseDouble(args[2]);
    } catch (Exception e) {
      System.out.println("Error");
      System.exit(1);
    }

    financeStuff a = new financeStuff(amount, rate, payment);

    System.out.println("months = " + a.getMonths() + " cost = " + a.getCost());

  }
}
