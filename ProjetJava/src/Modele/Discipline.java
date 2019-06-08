package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Discipline {
    private Ecole ecole;
    private int id;
    private String nom;
    
    public Discipline(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Discipline WHERE id ='"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    public void modifier(String nom){
        this.nom = nom;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
