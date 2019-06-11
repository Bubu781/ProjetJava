package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Discipline {
    private Ecole ecole;
    private int id;
    private String nom;
    
    /**
     * consctructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public Discipline(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Discipline WHERE id ='"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    public Discipline(Connexion connexion, String nom, Ecole ecole) throws SQLException {
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Discipline(nom) VALUES('"+nom+"');");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Discipline WHERE nom = '"+nom+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        this.nom = nom;
        this.ecole = ecole;
        this.ecole.reloadClasses();
    }
    
    /**
     * Modification
     * @param nom 
     */
    public void modifier(String nom) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE Discipline SET nom = '"+nom+"' WHERE Id = '"+this.id+"'");
        this.nom = nom;
    }
    
    /**
     * getter id
     * @return id
     */
    public int getId(){
        return this.id;
    }
    /**
     * Getter de nom
     * @return nom 
     */
    public String getNom(){
        return this.nom;
    }
}
