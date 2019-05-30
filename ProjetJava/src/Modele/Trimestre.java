package Modele;

public class Trimestre {
    
    private AnneeScolaire annee;
    
    public Trimestre(){
        this.annee= null;
    }
    
    public Trimestre(AnneeScolaire a){
        
        this.annee=a;
    }
    
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
}
