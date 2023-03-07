import java.util.*;
import java.lang.*;
/**
 * RecordP class
 * Takes Record class and adds probiblity aspects
 * @author Cora Skidmore
 */
public class RecordP extends Record{
  private double prob;
  private Random rand;
  /**
   * RecordP class Constructor
   * @param s Start Date
   * @param i integer required for Inc class instance
   * @param t String required for Inc class instance
   * @param n String representation of the name
   * @param p double representation of probability of event
   * @param r Random object for probibility
   */
  public RecordP(MyDate s, int i, String t, String n, double p, Random r){
    super(s, i, t, n);
    this.prob = p;
    this.rand = r;
  }
  /**
   * makeRecordP method
   * @param line String[] text file line representation of a financial event
   * @param r Random object used to get probility
   * @return Record parsing the string[] and returning an instance Record with
   * that data
   */
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

  /**
   * today method
   * Takes in a date and checks if it happens on that date and roles a
   * probibilty if it will actually occur that day
   * @param d MyDate - date to check event occurance
   * @return boolean if event happens on day d
   */
  public boolean today(MyDate d){
    boolean result = super.today(d);
    if(result){
      Double chance = rand.nextDouble();
      if(chance < this.prob)
        return true;
    }
    return false;
  }




}
