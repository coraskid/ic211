import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ExamplePanel extends JPanel{
    private JLabel timeRemainingLabel;
    private CatButton catButton;
    private ArrayList<Ball> balls;

    

    public ExamplePanel(ArrayList<Ball> b, Random rand){
        balls = b;
        this.setLayout(new FlowLayout());
        catButton = new CatButton(balls, rand);
        catButton.addActionListener(catButton);
        this.add(catButton);

    }
    
}
