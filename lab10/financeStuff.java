import java.util.*;

public class financeStuff {
  private double amt;
  private double bal;
  private double rate;
  private double payment;
  private int months = 0;
  private double cost;

  public financeStuff(double a, double r, double p){
    amt = a;
    rate = r;
    payment = p;
    bal = a;
    //System.out.println(a);
    //System.out.println(payment);
    while(bal > 0) {
      //System.out.println(bal);
      this.addMonInterest();
      //System.out.println(bal);
      this.payMon();
    }
    cost = this.calcCost();
    cost = moneyRound(cost);
    //System.out.println(cost);

  }


  public void addMonInterest() throws InfinateLoanException{
    double interest = (bal*rate)/1200;
    bal = bal + interest;
    if (interest > payment) {
      throw new Exception();
    }
  }

  public void payMon(){
    bal = bal - payment;
    months++;
  }

  public double calcCost(){
    double totalPaid = months * payment;
    double cost = totalPaid + bal - amt;
    return cost;

  }

  public static double moneyRound(double c){
    return Math.round(c*100)/100;
  }

  public static void main(String[] args){


    financeStuff a = new financeStuff(4500.00, 4.25, 95.50);

    System.out.println("hi: " + a.months + " " + a.cost);

  }





}
