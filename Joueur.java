package livraison;

import java.util.ArrayList;
public class Joueur{
    private String nom;
    private Grille grille;
    public ArrayList<Navire> navires;
    public int nbNavires;
    public int coordTotal;
    /**
    *constructeur de la classe joueur
    *@param nom le nom du joueur
    *@param grille la grille du joueur
    *@param listeNavire liste des navires du joueur
    *@param nbCartouche le nombre de cartouche a la disposition du joueur
    */
    public Joueur(){}
    public Joueur(String nom, Grille grille){
        int coordTotal=0;
        this.navires=new ArrayList<Navire>();
        Navire navire1 = new Navire("Porte avion",5);
        //Navire navire2 = new Navire("Destructeur",4);
        //Navire navire3 = new Navire("Croiseur",2);
        //Navire navire4 = new Navire("Sous-Maarin",3);
        //Navire navire5 = new Navire("Croiseur",2);
        this.navires.add(navire1);
    		//this.navires.add(navire2);
    		//this.navires.add(navire3);
    		//this.navires.add(navire4);
    		//this.navires.add(navire5);
        this.nom = nom;
        this.grille = grille;
        this.nbNavires=navires.size();

        for(Navire n : navires)
          coordTotal=coordTotal+n.getLongueur();
        this.coordTotal = coordTotal;
    }

    public String getNom(){
        return nom;

    }

    public void setGrille(Grille g){
      this.grille=g;
    }
    public Grille getGrille(){
        return grille;

    }


    public Grille copierGrille(Grille grille) {
    Grille copie = new Grille(10);
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            copie.cases[i][j] = new Case(grille.cases[i][j].getX(), grille.cases[i][j].getY());
            copie.cases[i][j].b=grille.cases[i][j].b;
        }
    }
    return copie;
}

    public boolean placableCase(Navire n, char direction, boolean vertical, Grille grille){
      char c = '-';
      char z = '\u2654';
      int j=0;
      boolean a;
      boolean[] plc = new boolean[n.getLongueur()];

      if(grille.cases[n.getCaseDeDepart().getX()-1][n.getCaseDeDepart().getY()-1].toString().contains(String.valueOf(c)))
        if(vertical)
          switch(direction){
            case 'H':
              if(n.getCaseDeDepart().getX()-n.getLongueur()+1 > 0)
                for(int i=n.getCaseDeDepart().getX()-1; i>=n.getCaseDeDepart().getX()-n.getLongueur();i--)
                  if(grille.cases[i][n.getCaseDeDepart().getY()-1].toString().contains(String.valueOf(z))){
                    plc[j]=false;
                    j++;
                  }
                  else {plc[j]=true;j++;}

              break;
            case 'B':
              if(n.getCaseDeDepart().getX()+n.getLongueur()-1 <= 10)
                for(int i=n.getCaseDeDepart().getX()-1; i<n.getCaseDeDepart().getX()+n.getLongueur()-1;i++)
                  if(grille.cases[i][n.getCaseDeDepart().getY()-1].toString().contains(String.valueOf(z))){
                    plc[j]=false;
                    j++;
                    }
                  else {plc[j]=true;j++;}
              break;
            default:
              break;
            }
        else
          switch(direction){
            case 'G':
            if(n.getCaseDeDepart().getY()-n.getLongueur()+1 > 0)
              for(int i=n.getCaseDeDepart().getY()-1; i>=n.getCaseDeDepart().getY()-n.getLongueur();i--)
                if(grille.cases[n.getCaseDeDepart().getX()-1][i].toString().contains(String.valueOf(z))){
                  plc[j]=false;
                  j++;
                }
                else {plc[j]=true;j++;}
              break;
            case 'D':
              if(n.getCaseDeDepart().getY()+n.getLongueur()-1 < 10)
                for(int i=n.getCaseDeDepart().getY()-1; i<n.getCaseDeDepart().getY()+n.getLongueur()-1;i++)
                  if(grille.cases[n.getCaseDeDepart().getX()-1][i].toString().contains(String.valueOf(z))){
                    plc[j]=false;
                    j++;
                    }
                  else {plc[j]=true;j++;}
              break;
            default:
              a=false;
              break;
            }

            for(int s= 0 ;s<n.getLongueur();s++)
              if(plc[s]==false) return false;

            return true;


  }


    public void placerBateau(Navire n, boolean vertical, char direction){
      Case[] coordBateau=new Case[n.getLongueur()];
      int j=0;
      Grille g = copierGrille(this.grille);
      if(placableCase(n,direction,vertical,g)){
        System.out.println("bateau placable");
       if(vertical && direction=='H')
          for (int i=n.getCaseDeDepart().getX();i>n.getCaseDeDepart().getX()-n.getLongueur();i--){
              g.cases[i-1][n.getCaseDeDepart().getY() - 1].b = n;
              coordBateau[j]=g.cases[i-1][n.getCaseDeDepart().getY() - 1];
              j++;
            }

        if(vertical && direction=='B')
          for (int i=n.getCaseDeDepart().getX();i<=n.getCaseDeDepart().getX()+n.getLongueur()-1;i++){
              g.cases[i-1][n.getCaseDeDepart().getY()-1].b = n;
              coordBateau[j]=g.cases[i-1][n.getCaseDeDepart().getY() - 1];
              j++;}

        if(!vertical && direction=='G')
          for (int i=n.getCaseDeDepart().getY();i>n.getCaseDeDepart().getY()-n.getLongueur();i--){
              g.cases[n.getCaseDeDepart().getX() - 1][i-1].b = n;
              coordBateau[j]=g.cases[n.getCaseDeDepart().getX() - 1][i-1];
              j++;
            }

        if(!vertical && direction=='D')
          for (int i=n.getCaseDeDepart().getY();i<n.getCaseDeDepart().getY()+n.getLongueur();i++){
              g.cases[n.getCaseDeDepart().getX()-1][i-1].b = n;
              coordBateau[j]=g.cases[n.getCaseDeDepart().getX() - 1][i-1];
              j++;
              }

              this.grille = g;}
        else System.out.println("bateau non plaçable");
        n.setCoordBateau(coordBateau);

}

public void tirer(Grille g,Joueur joueur1,Obus ob, int x, int y) {
    // Récupération de la case visée
    Case caseVisee = new Case(x - 1, y - 1);

    // Récupération du navire sur la case visée (peut être null si la case n'est pas occupée par un navire)
    Navire bateauTouche = g.cases[x - 1][y - 1].b;

    // Si la case est occupée
    if (g.estToucher(x, y)) {
       System.out.println("La case " + caseVisee.toString2() + " a déjà été touchée par un obus.");
       return;
   }

   // Si la case est occupée
   if (g.estCaseOccupee(x, y)) {

       System.out.print("La case " + caseVisee.toString2() + " est occupée par un ");

       // Si la case est occupée par un navire
       if (bateauTouche != null) {
           System.out.print("Bateau qui sera touché maintenant.\n");

           // On marque la case comme touchée avec l'obus passé en argument
           g.cases[x - 1][y - 1].o = ob;
           joueur1.coordTotal--;
           // On recherche l'indice de la case touchée dans le tableau des coordonnées du navire touché
           int indice = -1;
           for (int i = 0; i < bateauTouche.getCoordBateau().length; i++) {
               if (bateauTouche.getCoordBateau()[i].getX() == caseVisee.getX()
                       && bateauTouche.getCoordBateau()[i].getY() == caseVisee.getY()) {
                   System.out.println("Case touchée : " + bateauTouche.getCoordBateau()[i].toString2());
                   indice = i;
                   break;
               }
           }

           // Si une case a été touchée on supprime du tableau des coordonnées
           if (indice != -1) {
               // On supprime la case touchée du tableau des coordonnées du navire touché
               bateauTouche.coordBateau = tabSansIndice(bateauTouche.coordBateau, indice);

               // Si le navire touché n'a plus de case non-touchée, il est coulé
               if (bateauTouche.getCoordBateau().length <= 0) {
                   System.out.println("Bateau coulé par le dernier coup dans la case : "+caseVisee.toString2());

               }
           }
       } else {
           // Si la case est occupée par un obstacle
           System.out.println("Obus.");
       }
   } else {
       // Si la case est vide, on marque la case comme touchée avec l'obus passé en argument
       System.out.println("La case " + caseVisee.toString2() + " est vide et sera touchée par un obus.");
       g.cases[x - 1][y - 1].o = ob;
   }


    // Affichage des cases touchées du navire touché (si il y en a un)
    if (bateauTouche != null) {
        System.out.println("Case du navire qui sont encore saine :");
        for (int i = 0; i < bateauTouche.getCoordBateau().length; i++) {
            System.out.println(bateauTouche.getCoordBateau()[i].toString2());
        }
    }
}
public Case[] tabSansIndice(Case[] cases, int i){

      Case[] casesT = new Case[cases.length-1];
      if (i<0 || i>=cases.length) {
        throw new IndexOutOfBoundsException("Indice invalide");
    }

    // Décaler les éléments suivants pour remplir l'emplacement vide
    for (int j = i; j <cases.length-1; j++) {
        cases[j] =  cases[j+1];
    }
    for(int j=0;j<cases.length-1;j++)
      casesT[j]=cases[j];
    // Mettre à jour la taille du tableau en supprimant le dernier élément

    return casesT;
}

    /**
    *@return le nombre de cartouches
    */
    public boolean partieTerminer(){
      if(this.nbNavires <= 0) return true;
        return false;
    }


    public void ajouterNavire(Navire navire){
    }

    public void retirerNavire(Navire navire){
    }

    public String toString(){
      return "\nNom joueur: "+this.nom+"\nNavires: {\n"+this.navires.toString()+"\n}";
    }

}
