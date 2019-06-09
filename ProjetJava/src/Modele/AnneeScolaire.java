package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnneeScolaire {
    
    /**
     * attributs d'annee scolaire
     */
      private Ecole ecole;
      private int id;
      private int annee;
    
      /**
       * constructeur surchargé d'annee scolaire
       * @param connexion
       * @param id
       * @param ecole
       * @throws SQLException 
       */
    public AnneeScolaire(Connexion connexion, int id, Ecole ecole) throws SQLException
    {
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT annee FROM AnneeScolaire WHERE Id = '"+id+"'");
        this.id=id;
        this.annee=Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        this.ecole = ecole;
    }
    
    /**
     * 
     * @param annee 
     * fonction de modification d'année
     */
    public void modifier(Connexion connexion, int annee) throws SQLException{
        connexion.executeUpdate("UPDATE AnneeScolaire SET annee ='"+annee+"' WHERE id='"+this.id+"'");
        this.annee = annee;
    }
    
    /**
     * getter de l'id d'annee scolaire
     * @return id
     */
    public int getId(){
        return this.id;
    }
    /**
     * getter de l'annee
     * @return annee
     */
    public int getAnnee(){
        return this.annee;
    }
    
}
