package Modele;

public class Trimestre {
    
    private int id;
    private AnneeScolaire annee;
    
    
    public Trimestre(){
        this.id=0;
        this.annee= null;
    }
    
    public Trimestre(AnneeScolaire a){
        
        this.annee=a;
    }
    
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
     public int getId(){
        return this.id;
    }
    
}
