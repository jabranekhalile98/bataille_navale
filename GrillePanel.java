package livraison;import livraison.Navire;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
 
 
public class GrillePanel extends JPanel{
 
  JButton buttonED;
  JButton buttonDE;
  JButton buttonC;
  Grille grille;
  public GrillePanel(Grille grille){
    super();
    this.grille= grille;
    JPanel panneauHaut= new JPanel();
    JPanel panneauBas = new JPanel();
 
    setPreferredSize(new Dimension(900, 500));
 
    panneauHaut.setLayout(new GridLayout(grille.getTaille(),grille.getTaille()));
    panneauBas.setLayout(new GridLayout(1,3));
    
    
    JPanel p ;
    for (int i = 0; i < grille.getTaille(); i++) {
        p = new JPanel(new GridLayout(1, grille.getTaille()));
            for (int j = 0; j < grille.getTaille(); j++) {
                Case c = grille.getCase(i, j);
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                 cell.setBackground(Color.GRAY);
                p.add(cell);
            }
    panneauHaut.add(p);
        }
    
    
    buttonDE= new JButton("Commencer le jeu");
 
    panneauBas.add(buttonDE);
 
 
 
  }
//   public void actionPerformed(ActionEvent e){
//     JButton source = (JButton) e.getSource();
//     double valeur;
//     double res;
//     String s="-";
//     if(source==this.buttonED){
//       valeur = Double.parseDouble(montantAConvertir.getText());
//       res = valeur*1.1;
//       this.resultat.setText(""+res);
//     }
//     if(source==this.buttonDE){
//       valeur = Double.parseDouble(montantAConvertir.getText());
//       res = valeur/1.1;
//       this.resultat.setText(""+res);
//     }
//     if(source==this.buttonC){
//       this.resultat.setText(s);
//       this.montantAConvertir.setText(s);
//     }
//   }

  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 50; // définir la taille de chaque cellule de la grille

        // Dessiner la grille
        for (int i = 0; i < grille.getTaille(); i++) {
            for (int j = 0; j < grille.getTaille(); j++) {
                int x = j * cellSize;
                int y = i * cellSize;
                g.drawRect(x, y, cellSize, cellSize);
                g.drawString(grille.getCase(i, j).toString(), x + cellSize / 2, y + cellSize / 2);
            }
        }
    }
 
}
