import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;


public class ExampleDrawArea extends JComponent implements Runnable {
  private Ball ball; 
  private Cat cat; 

  //holds the background image
  private BufferedImage img = null;

  // we're going to use this ArrayList to hold all the objects in the scene
  private ArrayList<Ball> balls;

  private Random random;


  public ExampleDrawArea(ArrayList<Ball> b, Random ran) {
    super();
    setPreferredSize(new Dimension(600, 400));

    // Load the background image up front.
    //do this here not in any of the loops for better performance, Thank you Capt Escamilla
    try {
      img = ImageIO.read(new File("car.png"));
    } catch (IOException e) {}

    //create empty ArrayList<Ball>
    balls = b;
    random = ran;

    //ball instantiated, note we pass the ArrayList and random
    ball = new Ball(200, 200, balls, random);
    ball.setGoal(10, 20);
    // cat instantiated
    cat = new Cat(100,100,random);
    cat.setGoal(10, 20);
    
    
    //add ball and cat to ArrayList balls
    balls.add(ball);
    balls.add(cat);
  }


  //step is the "heartbeat", we update all the object in the scene by calling their step() method
  public void step() {
   
    //for each loop call step() for all the ball objects in balls
    for(Ball i: balls){
      i.step();

      // this if statement adds a MouseListener to any ball object that does not already have one
      if(!i.getMouseListenerAssigned()){
        i.setMouseListenerAssigned();
        addMouseListener(i);
      }
      
    }
    
  }

  //run is needed to implement runnable, in your projcet you should
  //have something that updates the scene (in this case step()) and
  //something that paints the scene, repaint()
  public void run() {
    while( true ) {
      try {
        Thread.sleep(20);
      } catch (Exception e) {}
      step();

      // repaint calls the paintComponent() method
      repaint();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;

    // This voodoo makes the output prettier
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);

      
      //draw the background first, so everything is drawn on top of it
      //background scales with frame, thank you MIDN Tauteoli
      g2.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),null);
    
      g2.setColor(Color.BLUE);
    // for each loop draws each object in balls into the scene
    for(Ball i: balls){
      i.paint(g2);
    }

    // This is an unfortunate necessity
    // that forces the underlying OS
    // windowing system to actually
    // show the updates we've made
    Toolkit.getDefaultToolkit().sync();
  }
}