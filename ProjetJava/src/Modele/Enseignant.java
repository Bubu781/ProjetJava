package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Enseignant extends Personne {
    private ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>();
    public Enseignant(Connexion connexion, int id, Ecole ecole) throws SQLException{
        super(connexion, id, ecole);
    }
    public void remplirClasses(Connexion connexion, ArrayList<Enseignement> enseignements) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT id FROM Enseignement WHERE enseignant ='"+id+"'");
        for(String values : requetes){
            for(Enseignement enseignement : enseignements){
                if(Integer.parseInt(values.substring(0,values.length()-1)) == enseignement.getId()){
                    this.enseignements.add(enseignement);
                }
            }
        }
    }
}
