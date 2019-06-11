package Modele;

import BDD.Connexion;
import Vue.DisplayDetailBulletin;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailBulletin {
    private Ecole ecole;
    private int id;
    private DisplayDetailBulletin display;
    private String appreciation;
    private Enseignement enseignement;
    private Bulletin bulletin;
    private ArrayList<Evaluation> evals = new ArrayList<Evaluation>();

    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public DetailBulletin(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT appreciation FROM DetailBulletin WHERE id = '"+id+"'");
        this.appreciation = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param enseignement
     * @param ecole
     * @throws SQLException 
     */
    public DetailBulletin(Connexion connexion, Enseignement enseignement,Bulletin bulletin, Ecole ecole) throws SQLException{
         ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO DetailBulletin(enseignement, bulletin) VALUES("+enseignement.getId()+","+bulletin.getId()+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM DetailBulletin WHERE enseignement = '"+enseignement.getId()+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.enseignement= enseignement;
        this.ecole= ecole;
        this.bulletin = bulletin;
        this.reload();
    }
    
    /**
     * Remplissage du detail bulletin
     * @param connexion
     * @param enseignements
     * @param bulletins
     * @param evaluations
     * @throws SQLException 
     */
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
        this.display = new DisplayDetailBulletin(this);
    }
    
    /**
     * Modification 
     * @param appreciation 
     */
    public void modifier(String appreciation) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE DetailBulletin SET appreciation = '"+appreciation+"' WHERE id = '"+this.id+"'");
        this.appreciation = appreciation;
        this.reload();
    }
    
    /**
     * Suppression de detail bulletin
     */
    public void suppression() throws SQLException{
        for(Evaluation eval : this.evals){
            this.ecole.getConnexion().executeUpdate("DELETE FROM Evaluation WHERE id = '"+eval.getId()+"'");
        }
        this.evals.removeAll(this.evals);
    }
    public void reload(){
        this.display = new DisplayDetailBulletin(this);
        this.bulletin.reload();
    }
    
    /**
     * Getter d'appreciation
     * @return appreciation
     */
    public String getAppreciation(){
        return this.appreciation;
    }
    /**
     * Getter d'id
     * @return id
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Fonction affichage detail bulletin
     * @return affichage
     */
    public DisplayDetailBulletin getDisplay(){
        return this.display;
    }
    
    public Bulletin getBulletin(){
        return this.bulletin;
    }
    public Enseignement getEnseignement(){
        return this.enseignement;
    }
    public ArrayList<Evaluation> getEvaluations(){
        return this.evals;
    }
    
    /**
     * Donction d'ajout d'enseignement
     * @param enseignement 
     */
    public void ajoutEnseignement(Enseignement enseignement){
        this.enseignement= enseignement;
        this.reload();
    }
    
    /**
     * Fonction d'ajout d'evaluation
     * @param note
     * @param appreciation
     * @throws SQLException 
     */
    public void ajoutEvaluation(int note, String appreciation) throws SQLException{
        Evaluation evaluation= new Evaluation(appreciation, note, this.ecole, this);
        evals.add(evaluation);
    }
    
   
}
