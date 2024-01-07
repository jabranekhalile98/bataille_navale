package livraison;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Fenetre extends JFrame {

  public Fenetre(Grille grille) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ma grille");
        setResizable(false);
        setLocationRelativeTo(null);


        pack();
        setVisible(true);
  }

  
  
}
