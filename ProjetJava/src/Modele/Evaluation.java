package Modele;

import BDD.Connexion;
import Vue.DisplayEvaluation;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Evaluation {
    private Ecole ecole;
    private int id;
    private int note;
    private DisplayEvaluation display;
    private String appreciation;
    private DetailBulletin detail;
    
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
    
    public void remplirClasses(Connexion connexion, ArrayList<DetailBulletin> details) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT detail_bulletin FROM Evaluation WHERE Id = '"+this.id+"'");
        for(DetailBulletin detail : details){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == detail.getId()){
                this.detail = detail;
            }
        }
    }
    
    public void modifier(int note, String appreciation){
        this.note = note;
        this.appreciation = appreciation;
    }
    
    public DisplayEvaluation getDisplay(){
        return this.display;
    }
    public int getNote(){
        return this.note;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
    public int getId(){
        return this.id;
    }
    
    public DetailBulletin getDetailBulletin(){
        return this.detail;
    }
}
