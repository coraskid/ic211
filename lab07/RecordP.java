import java.util.*;
import java.lang.*;

public class RecordP extends Record{
  private double prob;
  private Random rand;

  public RecordP(MyDate s, int i, String t, String n, double p, Random r){
    super(s, i, t, n);
    this.prob = p;
    this.rand = r;
  }

  public static Record makeRecordP(String[] line, Random r){
    String[] startString = (line[4]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    int amount = Integer.parseInt(line[1]);
    String n = line[8];
    for(int i = 9; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    double p = Double.parseDouble(line[6]);
    return new RecordP(s, amount, line[2], n, p, r);
  }

  public boolean today(MyDate d){
    boolean result = super.today(d);
    if(result){
      Double chance = rand.nextDouble();
      //System.out.println("this is rand val: " + chance);
      if(chance < this.prob)
        return true;
    }
    return false;
  }




}
