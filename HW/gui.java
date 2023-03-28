import javax.swing.*;

public class gui {

  public static void main(String[] args) {
    
    JFrame[] f = new JFrame[5];
    for(int i = 0; i < 5; i++){
      f[i] = new JFrame();
      f[i].setTitle("IC211 GUI Ex0");
      f[i].setSize(300, 400);
      f[i].setLocation(100, 100);
      f[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f[i].setVisible(true);
    }
  }
}
