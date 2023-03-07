import java.util.*;
/**
 * Record class
 * Create basics of a financial record object
 * @author Cora Skidmore
 */
public class Record {

  /**
   * Inc class
   * Sets incrimination properites, allows you to incriment a date once 
   */
  public class Inc{
    private char type;
    private int amount;
    /**
     * Inc class Constructor
     * @param a integer representing how many days/months/years it incriments
     * each time nextDate is called
     * @param t String representing day, month or year
     */
    public Inc(int a, String t){
      this.type = t.equals("days") ? 'd' : t.equals("months") ? 'm' : 'y';
      this.amount = a;
    }
    /**
     * nextDate method takes a date and incriments it based on the instance's
     * incrimentaion specifications
     * @param base MyDate representing original date
     * @return MyDate representing incrimented date
     */
    public MyDate nextDate(MyDate base){
      MyDate copyBase = base.clone();
      if (this.type == 'd')
        copyBase.incDay(this.amount);
      else if (this.type == 'm')
        copyBase.incMonth(this.amount);
      else
        copyBase.incYear(this.amount);
      return copyBase;
    }
  }

  private MyDate start;
  private Inc incrim;
  private String name;
  
  /**
   * Record class Constructor
   * @param s Start Date
   * @param i integer required for Inc class instance
   * @param t String required for Inc class instance
   * @param n String representation of the name
   */
  public Record(MyDate s, int i, String t, String n){
    this.start = s;
    this.incrim = new Inc(i, t);
    this.name = n;
  }
  /**
   * makeRecord method
   * @param line String[] text file line representation of a financial event
   * @return Record parsing the string[] and returning an instance Record with
   * that data
   */
  public static Record makeRecord(String[] line){
    String[] startString = (line[4]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    int a = Integer.parseInt(line[1]);
    String n = line[6];
    for(int i = 7; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    return new Record(s, a, line[2], n);
  }
  /**
   * toString method
   * @return instances' name
   */
  public String toString(){
    return this.name;
  }
  /**
   * today method
   * Takes in a date and checks if it happens on that date
   * @param d MyDate - date to check event occurance
   * @return boolean if event happens on day d
   */
  public boolean today(MyDate d){
    MyDate i = this.start;
    while (i.daysUntil(d) > 0){
      i = this.incrim.nextDate(i);
    }
    if (i.daysUntil(d) == 0)

      return true;
    else
      return false;
  }
}
