import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stats extends JPanel implements MouseListener {
  private Zoo zoo;
  private JLabel title;
  private JButton clear;
  private JLabel typeT;
  private JLabel typeF;
  private JLabel speedT;
  private JLabel speedF;
  private JLabel healthT;
  private JLabel healthF;


  public Stats(Zoo zoo) {
    this.zoo = zoo;
    title = new JLabel("Fish Stats");
    clear = new JButton("Clear Stats"); //button listener!!
    JPanel titleP = new JPanel(new FlowLayout());
    titleP.add(title);
    titleP.add(clear);

    typeT = new JLabel("Type of Fish: ");
    typeF = new JLabel("-----");
    JPanel typeP = new JPanel(new FlowLayout());
    typeP.add(typeT);
    typeP.add(typeF);

    speedT = new JLabel("Speed: ");
    speedF = new JLabel("-----");
    JPanel speedP = new JPanel(new FlowLayout());
    speedP.add(speedT);
    speedP.add(speedF);

    healthT = new JLabel("Health: ");
    healthF = new JLabel("-----");
    JPanel healthP = new JPanel(new FlowLayout());
    healthP.add(healthT);
    healthP.add(healthF);

    clear.addActionListener(new StatsActionListener(clear, typeF, speedF, healthF));
    //JPanel main = new JPanel();
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.add(titleP);
    this.add(typeP);
    this.add(speedP);
    this.add(healthP);


  }


  public void mouseClicked(MouseEvent e) {
    Animal click = null;
    try {
      click = zoo.checkClicked(e.getX(), e.getY());
    } catch (AnimalException ae){}
    if(click == null)
      return;
    if (click.getType() == 2)
      typeF.setText("Small Fish");
    if (click.getType() == 3)
      typeF.setText("Medium Fish");
    if (click.getType() == 4)
      typeF.setText("Shark");
    speedF.setText("" + click.getSpeed());
    healthF.setText("" + click.getHealth());

    
  }

  public void mouseEntered(MouseEvent e)  {}

  public void mouseExited(MouseEvent e)   {}

  public void mousePressed(MouseEvent e)  {}

  public void mouseReleased(MouseEvent e) {}
}
