package Modele;

import BDD.Connexion;
import Vue.DisplayBulletin;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bulletin {
    /**
     * Attributs de bulletin
     *
     */
    private Ecole ecole;
    private int id;
    private DisplayBulletin display;
    private String appreciation;
    private Trimestre trimestre; ///
    private Inscription inscription; //
    private ArrayList<DetailBulletin> details = new ArrayList<DetailBulletin>(); //
    
    /**
     * constructeur surcharché de bulletin
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     * 
     */
    public Bulletin(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT Appreciation FROM Bulletin WHERE id ='"+id+"'");
        this.appreciation = requetes.get(0);
    }
    /**
     * constructeur surcharché de bulletin
     * @param connexion
     * @param ecole
     * @param classe
     * @throws SQLException 
     * 
     */
    public Bulletin(Connexion connexion, Ecole ecole, Classe classe, Inscription inscription) throws SQLException{
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Bulletin(appreciation, trimestre, inscription) VALUES('',1,"+inscription.getId()+")");
        requetes = connexion.remplirChampsRequete("SELECT MAX(Id) FROM Bulletin ");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.ecole= ecole;
        this.inscription = inscription;
        this.trimestre = ecole.getTrimestres().get(0);
        for(Enseignement enseignement : classe.getEnseignements()){
            this.details.add(new DetailBulletin(connexion, enseignement,this, ecole));
        }
        this.display = new DisplayBulletin(this);
    }
    
    /**
     * Fonction de remplissage des bulletins a partir de la BDD
     * @param connexion
     * @param trimestres
     * @param inscriptions
     * @param details
     * @throws SQLException 
     */
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
        this.display = new DisplayBulletin(this);
    }
    /**
     * Getter du detail bulletin
     * @return detailBulletin
     */
    public ArrayList<DetailBulletin> getDetails(){
        return this.details;
    }
    
    /**
     * Fonction modifier
     * @param appreciation
     * @param trimestre 
     */
    public void modifier( String appreciation, Trimestre trimestre) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE Bulletin SET appreciation='"+appreciation+"', trimestre = '"+trimestre.getId()+"' WHERE id = '"+this.id+"'");
        this.appreciation = appreciation;
        this.trimestre = trimestre;
        this.reload();
    }
    
    /**
     * Fonction de suppression de bulletin
     */
    public void suppression() throws SQLException{
        for(DetailBulletin detail : this.details){
            detail.suppression();
            this.ecole.getConnexion().executeUpdate("DELETE FROM DetailBulletin WHERE id='"+detail.getId()+"'");
        }
        this.details.removeAll(this.details);
    }
    public void reload(){
        this.display = new DisplayBulletin(this);
    }
    
    /**
     * Fonction d'ajout d'evalution
     * @param enseignement
     * @param note
     * @param appreciation
     * @throws SQLException 
     */
     public void ajouterEvaluation(Enseignement enseignement, int note, String appreciation) throws SQLException{
        for(DetailBulletin detail : this.details){
            if(enseignement==detail.getEnseignement()){
                detail.ajoutEvaluation(note, appreciation);
            }
        }
        this.reload();
        this.setVisible(true);
    }
     /**
      * Getter de l'id
      * @return id
      */
    public int getId(){
        return this.id;
    }
    /**
     * Getter de trimestre
     * @return trimestre
     */
    public Trimestre getTrimestre(){
        return this.trimestre;
    }
    /**
     * Getter d'inscription
     * @return inscription
     */
    public Inscription getInscription(){
        return this.inscription;
    }
    
    public Ecole getEcole(){
        return this.ecole;
    }
    
    /**
     * getter d'appreciation
     * @return appreciation
     */
    public String getAppreciation(){
        return this.appreciation;
    }
    
    /**
     * Fonction set visible pour graphisme
     * @param bool 
     */
    public void setVisible(boolean bool){
        this.display.setVisible(bool);
    }

    void ajouterDetail(Enseignement enseignement) throws SQLException {
        this.details.add(new DetailBulletin(this.ecole.getConnexion(),enseignement,this, this.ecole));
    }
}
