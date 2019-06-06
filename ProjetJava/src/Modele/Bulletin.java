package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bulletin {
    private Ecole ecole;
    private int id;
    private String appreciation;
    private Trimestre trimestre; ///
    private Inscription inscription; //
    private ArrayList<DetailBulletin> details = new ArrayList<DetailBulletin>(); //
    
    public Bulletin(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT Appreciation FROM Bulletin WHERE id ='"+id+"'");
        this.appreciation = requetes.get(0);
    }
    
    public Bulletin(Connexion connexion, Ecole ecole, Classe classe) throws SQLException{
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Bulletin() VALUES("+")");
        requetes = connexion.remplirChampsRequete("SELECT MAX(Id) FROM Bulletin ");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.ecole= ecole;
        for(Enseignement enseignement : classe.getListeEnseignements()){
            this.details.add(new DetailBulletin(connexion, enseignement, ecole));
        }
    }
    public void remplirClasses(Connexion connexion, ArrayList<Trimestre> trimestres, ArrayList<Inscription> inscriptions, ArrayList<DetailBulletin> details) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT trimestre FROM Bulletin WHERE id='"+this.id+"'");
        for(Trimestre trimestre : trimestres){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == trimestre.getId()){
                this.trimestre = trimestre;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT inscription FROM Bulletin WHERE id='"+this.id+"'");
        for(Inscription inscription : inscriptions){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == inscription.getId()){
                this.inscription = inscription;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM DetailBulletin WHERE bulletin = '"+this.id+"'");
        for(String requete : requetes){
            for(DetailBulletin detail : details){
                if(Integer.parseInt(requete.substring(0,requete.length()-1)) == detail.getId()){
                    this.details.add(detail);
                }
            }
        }
    }
    
    public void modifier(String appreciation, Trimestre trimestre){
        this.appreciation = appreciation;
        this.trimestre = trimestre;
    }
    
    public void suppression(){
        for(DetailBulletin detail : this.details){
            detail.suppression();
        }
        this.details.removeAll(this.details);
    }
    
    public int getId(){
        return this.id;
    }
    public Trimestre getTrimestre(){
        return this.trimestre;
    }
    public Inscription getInscription(){
        return this.inscription;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
}
