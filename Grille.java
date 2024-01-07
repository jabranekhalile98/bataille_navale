package livraison;
public class Grille{
    private int taille;
    public Case[][] cases;

    public Grille(int taille){
        this.taille = taille;
        this.cases = new Case[taille][taille];

        for(int i = 0; i < taille;i++){
            for(int j = 0 ; j < taille; j++){
                this.cases[i][j] = new Case(i,j);
            }
        }

    }

    public Case[][] getCases(){
      return this.cases;
    }
    //getter
    public int getTaille(){
      return taille;
    }

    public Case getCase(int x , int y){
        return cases[x][y];
    }

    public void afficherPlateau(){

// Ligne de bordure supérieure
      System.out.print("  \u250c");
      for (int c = 0; c < taille-1; c++) {
          System.out.print(c+1);
          System.out.print("\u2500\u2500\u252c");
      }
      System.out.println("10\u2500\u252c");

      // Lignes de jeu
      for (int l = 0; l < taille; l++) {
          System.out.print((char) ('A' + l) + " \u2502");
          for (int c = 0; c < taille; c++) {
                  System.out.print(this.cases[l][c].toString()+" \u2502");
          }
          // Ligne de séparation
          if (l < taille - 1) {
              System.out.println();
              System.out.print("  \u251c");
              for (int c = 0; c < taille - 1; c++) {
                  System.out.print("\u2500\u2500\u2500\u253c");
              }
              System.out.println("\u2500\u2500\u2500\u2524");
          }
      }

      // Ligne de bordure inférieure
      System.out.print("\n  \u2514");
      for (int c = 0; c < taille - 1; c++) {
          System.out.print("\u2500\u2500\u2500\u2534");
      }
      System.out.println("\u2500\u2500\u2500\u2518\n");
        /*    System.out.print("    ");
      for (int i = 0; i < taille; i++) {
          System.out.print((char) ('A' + i) + " ");
      }
      System.out.println();
      for (int i = 0; i < taille; i++) {
        System.out.printf("%2d |", i + 1);
          for (int j = 0; j < taille; j++) {
               System.out.print(this.cases[i][j].toString());
             }
             System.out.println();
          }*/

      }

      public boolean estCaseOccupee(int x, int y){
          return (this.cases[x-1][y-1].o!=null)||(this.cases[x-1][y-1].b!=null);
      }

      public boolean estCaseOccupeeParB(int x, int y){
          return this.cases[x-1][y-1].b!=null;
      }
      public boolean dejaTirer(int x,int y){
          return (this.cases[x-1][y-1].o!=null);
      }
      public boolean estToucher(int x,int y){
        return (this.cases[x-1][y-1].b!=null) && (this.cases[x-1][y-1].o!=null);
      }



}
