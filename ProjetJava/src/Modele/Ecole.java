package Modele;

import Vue.Menu;

public class Ecole {
    
    private int id;
    private String nom;
    private Menu display;
    public Ecole(){
        this.id=1;
        this.nom="ECE";
        display = new Menu(this);
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
