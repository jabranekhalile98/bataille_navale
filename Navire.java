package livraison;
public class Navire{
    private String nom;
    private int longueur;
    private Case caseDeDepart;
    private boolean[] toucher;
    public Case[] coordBateau;



    public Navire(String nom,int longueur){
      this.nom=nom;
      this.longueur=longueur;

    }

    public Case[] getCoordBateau(){
      return this.coordBateau;
    }
    

    public void setCoordBateau(Case[] coord){
      this.coordBateau=new Case[this.longueur];
      for(int i=0; i<this.longueur;i++)
        this.coordBateau[i]=coord[i];
    }
    public String getNom(){
      return this.nom;
    }
    public void setCaseDeDepart(int x,int y){
      this.caseDeDepart = new Case(x,y);
    }

    public Case getCaseDeDepart(){
      return this.caseDeDepart;
    }
    public int getLongueur(){
      return this.longueur;
    }
    public boolean estTouche(Case caseToucher){return true;}
    public boolean estCoule(){return true;}


      public String toString(){
        return "Nom :"+nom + "\nLongueur: "+this.longueur+"\nPosition: "+this.caseDeDepart.toString2();
      }
    /*public Navire(Case caseDebut, int longeur, Orientation orientation){
        this.caseDebut = caseDebut;
        this.longeur = longeur;
        this.orientation = orientation;
        this.toucher = false;
    }*/

// getter et setter:
  /*  public getCaseDebut(){
        return this.caseDebut;
    }*/


  /*   public int getLongeur(){
        return longeur;

    }*/

  /*   public Orientation getOrientation(){
        return orientation;

    }*/

//###############################
// la méthode Esttoucher() permet de vérifier si le navire est touché ou pas
  /*   public boolean getToucher(){
        return this.toucher;

    }*/

}
