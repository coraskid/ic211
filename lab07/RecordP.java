import java.util.*;

public class RecordP extends Record{
  private double prob;
  private static Random rand = (args.length == 3) ? new Random(Long.parseLong(args[2])) : new Random(System.currentTimeMillis());

  public RecordP(MyDate s, int i, String t, String n, double p){
    super(s, i, t, n);
    this.prob = p;
  }

  public Record makeRecordP(String[] line){
    String[] startString = (line[4]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    this.start = s;
    this.incrim = new Inc(Integer.parseInt(line[1]), line[2]);
    String n = line[8];
    for(int i = 9; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    this.name = n;
    
    this.prob = Double.parseDouble(startString[6]);
  }

  public boolean today(MyDate d){
    boolean result = super.today(d);
    Double chance = rand.nextDouble();
    if(result && chance < this.prob)
      return true;
    else
      return false;
  }




}
