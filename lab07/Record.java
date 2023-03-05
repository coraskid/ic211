import java.util.*;
public class Record {
  private class Inc{
    private char type;
    private int amount;
    private Inc(int a, String t){
      this.type = t.equals("days") ? 'd' : t.equals("months") ? 'm' : 'y';
      this.amount = a;
    }
    private MyDate nextDate(MyDate start){
      MyDate copyStart = start;
      if (this.type == 'd')
        copyStart.incDay(this.amount);
      else if (this.type == 'm')
        copyStart.incMonth(this.amount);
      else
        copyStart.incYear(this.amount);
      return copyStart;
    }
  }

  private MyDate start;
  private Inc incrim;
  private String name;
  
  public Record(MyDate s, int i, String t, String n){
    this.start = s;
    this.incrim = new Inc(i, t);
    this.name = n;
  }

  public static Record makeRecord(String[] line){
    String[] startString = (line[4]).split("/");
    int mon = Integer.parseInt(startString[0]);
    int day = Integer.parseInt(startString[1]);
    int year = Integer.parseInt(startString[2]);
    MyDate s = new MyDate(year, mon, day);
    int a = Integer.parseInt(line[1]);
    //Inc in = new Inc(Integer.parseInt(line[1]), line[2]);
    String n = line[6];
    for(int i = 7; i < line.length; i++){
      n = n.concat(" ");
      n = n.concat(line[i]);
    }
    return new Record(s, a, line[2], n);

        
    //System.out.println(n);
    //System.out.println(first);

  }

  public String toString(){
    return this.name;
  }
/*
  public MyDate getDate(){
    return this.start;
  }*/

  public boolean today(MyDate d){
    MyDate i = this.start;
    while (i.daysUntil(d) > 0){
      //System.out.println("Test: " + i + " " + i.daysUntil(d));
      i = this.incrim.nextDate(i);
    }
    /*
    for(MyDate i = this.start; i.daysUntil(d) > 0; i.incDay(1)){
      System.out.println(i);
      MyDate test = (this.incrim).nextDate(i);
      System.out.println("Test:" + test);
    }*/
    if (i.daysUntil(d) == 0)

      return true;
    else
      return false;
  }
}
