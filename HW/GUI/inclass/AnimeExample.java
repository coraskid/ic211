import java.awt.*;
import javax.swing.*;
import java.util.*;

public class AnimeExample {

  public static void main(String[] args) {
    JFrame   frame = new JFrame();
    Random random = new Random();

    //thing that holds objects in the scene
    ArrayList<Ball> balls = new ArrayList<Ball>();
    
    ExampleDrawArea drawArea = new ExampleDrawArea(balls, random);

    //this is an example of a panel.
    //just adding it here to show an example of a panel with the DrawArea
    ExamplePanel panel = new ExamplePanel(balls, random);

    frame.add(drawArea);
    // add the TimerPanel to the top of the frame
    frame.add(panel, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);
    //since drawArea implements Runnable we can pass it to the Thread constructor
    Thread thread = new Thread(drawArea);
    //create new Thread, calls drawArea's run() method
    thread.start();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}