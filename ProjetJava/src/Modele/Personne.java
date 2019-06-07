package Modele;

import BDD.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne {
    protected Ecole ecole;
    protected int id;
    protected String nom;
    protected String prenom;
    
    public Personne(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Personne WHERE Id = '"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
        requetes = connexion.remplirChampsRequete("SELECT prenom FROM Personne WHERE Id = '"+id+"'");
        this.prenom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    public Personne(Connexion connexion,String nom, String prenom, Ecole ecole) throws SQLException{
         ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Personne(Nom, Prenom) VALUES("+nom+","+prenom+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Personne WHERE Nom = '"+nom+"' AND Prenom = '"+prenom+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.nom=nom;
        this.prenom=prenom;
        this.ecole = ecole;
    }
    
    public void modifier(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
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
    
    public Ecole getEcole(){
        return this.ecole;
    }
    
}
