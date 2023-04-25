public class MainThread extends Thread {
  private DrawAq da;
  private boolean kill;

  public MainThread(DrawAq d) {
    da = d;
    kill = false;
  }

  public void run() {
    while (!kill) {
      try {
        Thread.sleep(20);
      } catch (Exception e) {}
      da.step();
      da.repaint();
    }
  }
  public void kill(){
    this.kill = true;
  }

  public MainThread newCopy(){
    return new MainThread(da);
  }
}

