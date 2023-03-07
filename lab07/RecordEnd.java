import java.util.*;

public class RecordEnd extends Record{
  private MyDate end;

  public RecordEnd(MyDate s, int i, String t, String n, int e){
    super(s, i, t, n);
    Inc in = new Inc(i, t);
    MyDate cp = s.clone();
    for(int j = 0; j < e; j++){
      cp = in.nextDate(cp);
    }
    this.end = cp;

  }

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

  public boolean today(MyDate d){
    boolean result = super.today(d);
    //System.out.println("Checking lazy boy: " + d + result + this.end + " " + d.daysUntil(this.end));
    /*MyDate cp = this.start;
    for(int i = 0; i < this.e; i++){
      cp = nextDate(cp);
    }
    if(d.daysUntil(cp) < 0)
      return false;
    else
      return result;
*/
    if(d.daysUntil(this.end) < 0){
      System.out.println(d.daysUntil(this.end));
      return false;
    }
    else
      return result;
  }

}

