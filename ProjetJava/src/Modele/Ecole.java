package Modele;

public class Ecole {
    
    private int id;
    private String nom;
    
    public Ecole(){
        this.id=1;
        this.nom="ECE";
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
