package Modele;

import BDD.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne {
    /**
     * attributs en protected de la classe Personne car cette classe a deux classes filles : Eleve et Enseignement 
     * Ses classes filles doivent accéder aux attributs de la classe mère Personne donc les attributs sont en protected
     */
    protected Ecole ecole;
    protected int id;
    protected String nom;
    protected String prenom;
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public Personne(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Personne WHERE Id = '"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
        requetes = connexion.remplirChampsRequete("SELECT prenom FROM Personne WHERE Id = '"+id+"'");
        this.prenom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param nom
     * @param prenom
     * @param ecole
     * @throws SQLException 
     */
    public Personne(Connexion connexion,String nom, String prenom, Ecole ecole) throws SQLException{
         ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Personne(Nom, Prenom) VALUES("+nom+","+prenom+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Personne WHERE Nom = '"+nom+"' AND Prenom = '"+prenom+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.nom=nom;
        this.prenom=prenom;
        this.ecole = ecole;
    }
    
    /**
     * modifier le nom et prenom d'une personne
     * @param nom
     * @param prenom 
     */
    public void modifier(String nom, String prenom) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE Personne SET nom ='"+nom+"', prenom = '"+prenom+"' WHERE id = '"+this.id+"'");
        this.nom = nom;
        this.prenom = prenom;
        this.reload();
    }
    public void reload(){
        
    }
    /**
     * getter de l'id
     * @return l'id
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * getter du nom
     * @return le nom
     */
    public String getNom(){
        return this.nom;
    }
   
    /**
     * getter du prenom
     * @return prenom
     */
    public String getPrenom(){
        return this.prenom;
    }
    
    /**
     * getter de l'ecole
     * @return ecole
     */
    public Ecole getEcole(){
        return this.ecole;
    }
    
}
