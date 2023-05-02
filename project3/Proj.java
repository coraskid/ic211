import java.awt.*;
import javax.swing.*;

/**
 * This class is the main driver of the aquarium, It sets up all necessray parts
 * and starts the inital thread
 * The frame work for this is from class notes
 * @author Cora Skidmore
 */

public class Proj {  
  public static void main(String[] args) {
    //Over arching frame
    JFrame   f = new JFrame();
    //allows all fish to know how big the current tank size is
    TankSize ts = new TankSize();
    //Zoo takes care of all animals and various things that happen to them
    Zoo zoo = new Zoo(ts);
    //Stats allow you to click on a fish and see their stats
    Stats stat = new Stats(zoo);
    
    //background based on user input or lack there of
    String background = "aq.jpg";
    if(args.length == 1){
      background = args[0];
    }
    //this class depicts how the area will be drawn
    DrawAq da = new DrawAq(background, zoo, ts, stat);
    //this is the thread that will run until it is paused
    MainThread t = new MainThread(da);
    //this is the panel with all the controls
    ControlPanel cp = new ControlPanel(t, zoo, stat);
    f.add(da);
    f.add(cp, BorderLayout.WEST);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setTitle("Skidmore, Corinna - m255844");
    f.pack();
    f.setVisible(true);
    t.start();
  }
}
