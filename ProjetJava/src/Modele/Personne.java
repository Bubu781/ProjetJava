package Modele;

public class Personne {
    
    protected int id;
    protected String nom;
    protected String prenom;
    
    public Personne(){
     
    this.id=1;
    this.nom="Leonard";
    this.prenom="Leonie";
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
   
    public String getPrenom(){
        return this.prenom;
    }
    
}
