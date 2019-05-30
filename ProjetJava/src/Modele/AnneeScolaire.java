package Modele;

public class AnneeScolaire {
      private int id;
      private int annee;
    
    public AnneeScolaire()
    {
        this.id=0;
        this.annee=0;
    }
    public AnneeScolaire(int id, int a)
    {
        this.id=id;
        this.annee=a;
       
    }
    
    public int getId(){
        return this.id;
    }
    public int getAnnee(){
        return this.annee;
    }
    
}
