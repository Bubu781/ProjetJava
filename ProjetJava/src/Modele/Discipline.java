package Modele;

public class Discipline {
    
    private int id;
    private String nom;
    
    public Discipline(){
        this.id=0;
        this.nom="";
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
