/**
 * This class dictates the main thread and when the fish move
 * NOTE: I purposefully moved this class out of the nested class in the main
 * driver class becuase I wanted some of my buttons to have complete access to
 * the class and the methods inside, I am aware I could have done it differently
 * , but I am in too deep
 * @author Cora Skidmore
 */
public class MainThread extends Thread {
  private DrawAq da;
  private boolean kill;
  /**
   * Constructor
   * @param d DrawAq instance
   */
  public MainThread(DrawAq d) {
    da = d;
    kill = false;
  }
  /**
   * The method called when the thread is started
   * Will run forever until the thread is killed
   */
  public void run() {
    while (!kill) {
      try {
        Thread.sleep(10);
      } catch (Exception e) {}
      //moves everyone one step forward
      da.step();
      //check overlaps
      da.overlap();
      //repains
      da.repaint();
    }
  }
  /**
   * This method will end the thread by breaking it out of the while loop in run
   */
  public void kill(){
    this.kill = true;
  }
  /**
   * Calls a repaint, usually used when the thread is dead
   */
  public void deadPaint(){
    da.repaint();
  }
  /**
   * Makes a new thread, allows you to start the thread back up with the same
   * look
   * @return MainThread, that is a copy of the current thread
   */
  public MainThread newCopy(){
    return new MainThread(da);
  }
}

