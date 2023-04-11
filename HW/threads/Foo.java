public class Foo implements Runnable {
  private String msg, tab;

  public Foo(String s, String t) {
    this.msg = s;
    this.tab = t;
  }

  public void run() {
    Ex1.printSlow(this.msg, this.tab);
  }
}
