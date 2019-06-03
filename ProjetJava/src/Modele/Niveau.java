package Modele;

import BDD.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class Niveau {
    private Ecole ecole;
    private int id;
    private String nom;

    public Niveau(Connexion connexion, int id, Ecole ecole) throws SQLException {
        ArrayList<String> requetes;
        this.id = id;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Niveau WHERE id='"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
