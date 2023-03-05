import java.util.*;
public class Record {
  private class Inc{
    private char type;
    private int amount;
    private Inc(int a, String t){
      this.type = t.equals("days") ? 'd' : t.equals("months") ? 'm' : 'y';
      this.amount = a;
    }
  }

  private static MyDate first = null;
  private MyDate start;
  private Inc incrim;
  private String name;
  
  public Record(MyDate s, int i, String t, String n){
    this.start = s;
    this.incrim = new Inc(i, t);
    this.name = n;
  }

  public Record(String[] line){
    String[] startString = (line[4]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    this.start = s;
    this.incrim = new Inc(Integer.parseInt(line[1]), line[2]);
    String n = line[6];
    for(int i = 7; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    this.name = n;

    if(first == null || s.daysUntil(first) > 0)
      first = s;
    
    System.out.println(n);
    System.out.println(first);

  }

  public String toString(){
    return this.name;
  }


  //public boolean today(MyDate d){




  //}
}
