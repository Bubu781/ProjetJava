package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnneeScolaire {
      private Ecole ecole;
      private int id;
      private int annee;
    
    public AnneeScolaire(Connexion connexion, int id, Ecole ecole) throws SQLException
    {
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT annee FROM AnneeScolaire WHERE Id = '"+id+"'");
        this.id=id;
        this.annee=Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        this.ecole = ecole;
    }
    
    public int getId(){
        return this.id;
    }
    public int getAnnee(){
        return this.annee;
    }
    
}
