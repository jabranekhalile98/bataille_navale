package livraison;

public class Case{
    private int x;
    private int y;
    Navire b ;
    Obus o;


    public Case(int x , int y){
        this.x = x;
        this.y = y;
    }
// getter et setter
     public int getX(){
        return this.x;
    }
     public int getY(){
        return this.y;
    }

    public void setX(int x){
      this.x=x;
    }

    public void setY(int y){
      this.y=y;
    }

    public String toString() {
      if (this.o==null && this.b==null)
          return " -";
      else if (this.b==null)
          return " O";
      else if (this.o==null)
          return " \u2654";
      else return " X";

    }
    public String toString2() {
      return "("+(this.x+1)+","+(this.y+1)+")";

    }
    public boolean caseToucher(){
      return this.o!=null && this.b!=null;
    }
     public boolean estCaseOccupee(){
          return (this.o!=null)||(this.b!=null);
      }

      public boolean estCaseOccupeeParB(){
          return this.b!=null;
      }
      public boolean dejaTirer(int x,int y){
          return (this.o!=null);
      }
      public boolean estToucher(int x,int y){
        return (this.b!=null) && (this.o!=null);
      }


}
