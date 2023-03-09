import java.util.*;
/**
 * RecordEnd class
 * Takes Record class and adds end date
 * @author Cora Skidmore
 */
public class RecordEnd extends Record{
  private MyDate end;
  /**
   * RecordEnd class constructor
   * @param s Start Date
   * @param i integer required for Inc class instance
   * @param t String required for Inc class instance
   * @param n String representation of the name
   * @param e integer for how many times event occurs
   */
  public RecordEnd(MyDate s, int i, String t, String n, int e){
    super(s, i, t, n);
    Inc in = new Inc(i, t);
    MyDate cp = s.clone();
    for(int j = 0; j < (e-1); j++){
      cp = in.nextDate(cp);
    }
    this.end = cp;
  }
   /**
   * makeRecordEnd method
   * @param line String[] text file line representation of a financial event
   * @return Record parsing the string[] and returning an instance Record with
   * that data
   */
  public static Record makeRecordEnd(String[] line){
    String[] startString = (line[6]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    int e = Integer.parseInt(line[4]);
    int amount = Integer.parseInt(line[1]);
    String n = line[8];
    for(int i = 9; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    return new RecordEnd(s, amount, line[2], n, e);
  }

  /**
   * today method
   * Takes in a date and checks if it happens on that date (including checking
   * if its past end)
   * @param d MyDate - date to check event occurance
   * @return boolean if event happens on day d
   */
  public boolean today(MyDate d){
    boolean result = super.today(d);
    if(d.daysUntil(this.end) < 0){
      //System.out.println(d.daysUntil(this.end));
      return false;
    }
    else
      return result;
  }
}

