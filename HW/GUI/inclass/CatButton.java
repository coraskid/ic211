import javax.swing.JButton;


import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class CatButton extends JButton implements ActionListener{
    private ArrayList<Ball> balls;
    private Random  rand;

    public CatButton (ArrayList<Ball> b, Random random){
        super("Add a Cat");
        rand = random;
        balls = b;
    }

    public void actionPerformed(ActionEvent e){
        Cat newCat = new Cat (300,300,rand);
        balls.add(newCat);
    }






}




