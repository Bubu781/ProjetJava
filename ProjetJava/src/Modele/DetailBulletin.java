package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailBulletin {
    private Ecole ecole;
    private int id;
    private String appreciation;
    private Enseignement enseignement;
    private Bulletin bulletin;
    private ArrayList<Evaluation> evals = new ArrayList<Evaluation>();

    
    public DetailBulletin(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT appreciation FROM DetailBulletin WHERE id = '"+id+"'");
        this.appreciation = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    public void remplirClasses(Connexion connexion, ArrayList<Enseignement> enseignements, ArrayList<Bulletin> bulletins, ArrayList<Evaluation> evaluations) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT enseignement FROM DetailBulletin WHERE Id = '"+this.id+"'");
        for(Enseignement enseignement : enseignements){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == enseignement.getId()){
                this.enseignement = enseignement;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT bulletin FROM DetailBulletin WHERE Id = '"+this.id+"'");
        for(Bulletin bulletin : bulletins){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == bulletin.getId()){
                this.bulletin = bulletin;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Evaluation WHERE detail_bulletin = '"+this.id+"'");
        for(String requete : requetes){
            for(Evaluation evaluation : evaluations){
                if(Integer.parseInt(requete.substring(0,requete.length()-1)) == evaluation.getId()){
                    this.evals.add(evaluation);
                }
            }
        }
    }
    
    public void modifier(String appreciation){
        this.appreciation = appreciation;
    }
    
    public void suppression(){
        this.evals.removeAll(this.evals);
    }
   
    public String getAppreciation(){
        return this.appreciation;
    }
    public int getId(){
        return this.id;
    }
    
    public Bulletin getBulletin(){
        return this.bulletin;
    }
    
    public void ajoutEnseignement(Enseignement enseignement){
        this.enseignement= enseignement;
    }
}
