package Modele;

import BDD.Connexion;
import Vue.DisplayEvaluation;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Evaluation {
    /**
     * attributs prives de la classe Evaluation
     */
    private Ecole ecole;
    private int id;
    private int note;
    private DisplayEvaluation display;
    private String appreciation;
    private DetailBulletin detail;
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public Evaluation(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT note FROM Evaluation WHERE id ='"+id+"'");
        this.note = Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        requetes = connexion.remplirChampsRequete("SELECT appreciation FROM Evaluation WHERE id ='"+id+"'");
        this.appreciation = requetes.get(0).substring(0,requetes.get(0).length()-1);
        this.display = new DisplayEvaluation(this);
    }
    
    /**
     * Constructeur surchargé
     * @param appreciation
     * @param note
     * @param ecole
     * @throws SQLException 
     */
    public Evaluation( String appreciation,int note,Ecole ecole, DetailBulletin detail) throws SQLException{
        ArrayList<String> requetes;
        ecole.getConnexion().executeUpdate("INSERT INTO Evaluation(Appreciation, Note, detail_bulletin) VALUES('"+appreciation+"',"+note+","+detail.getId()+");");
        requetes = ecole.getConnexion().remplirChampsRequete("SELECT MAX(Id) FROM Evaluation WHERE Appreciation = '"+appreciation+"' AND Note = '"+note+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.ecole=ecole;
        this.appreciation=appreciation;
        this.note=note;
        this.detail = detail;
        this.reload();
    }
    
    /**
     * Remplissage d'une évaluation dans la bdd
     * @param connexion
     * @param details
     * @throws SQLException 
     */
    public void remplirClasses(Connexion connexion, ArrayList<DetailBulletin> details) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT detail_bulletin FROM Evaluation WHERE Id = '"+this.id+"'");
        for(DetailBulletin detail : details){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == detail.getId()){
                this.detail = detail;
            }
        }
    }
    
    /**
     * Modifier la valeur de la note et le string de l'appréciation
     * @param note
     * @param appreciation 
     */
    public void modifier(int note, String appreciation) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE Evaluation SET note ='"+note+"', appreciation ='"+appreciation+"' WHERE id = '"+this.id+"'");
        this.note = note;
        this.appreciation = appreciation;
        this.reload();
    }
    
    public void reload(){
        this.display = new DisplayEvaluation(this);
        this.detail.reload();
    }
    /**
     * Affichage de l'évaluation
     * @return 
     */
    public DisplayEvaluation getDisplay(){
        return this.display;
    }
    /**
     * getter de la note
     * @return la note
     */
    public int getNote(){
        return this.note;
    }
    /**
     * getter de l'appréciation
     * @return l'appréciation
     */
    public String getAppreciation(){
        return this.appreciation;
    }
    
    /**
     * getter de l'id
     * @return l'id
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * getter de detail
     * @return 
     */
    public DetailBulletin getDetailBulletin(){
        return this.detail;
    }
}
