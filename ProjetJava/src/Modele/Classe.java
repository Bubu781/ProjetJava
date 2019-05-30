package Modele;

public class Classe {
    
    private String nom;
    private AnneeScolaire annee;
    private Ecole ecole;
    private Niveau niveau;
    
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
    public Ecole getEcole(){
        return this.ecole;
    }
    
    public Niveau getNiveau(){
        return this.niveau;
    }
    
    public String getNom(){
        return this.nom;
    }
}
