package Modele;

import BDD.Connexion;
import Vue.DisplayEleve;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Eleve extends Personne {
    private Inscription inscription;
    private DisplayEleve display;
    //private DisplayEleves displayEleves;
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public Eleve(Connexion connexion, int id, Ecole ecole) throws SQLException{
        super(connexion, id, ecole);
    }
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param nom
     * @param prenom
     * @param ecole
     * @throws SQLException 
     */
    public Eleve (Connexion connexion, String nom, String prenom, Ecole ecole) throws SQLException{
        super(connexion, nom, prenom, ecole);
        connexion.executeUpdate("INSERT INTO Eleve(personne) VALUES("+this.id+");");
        
        this.display=new DisplayEleve(this);
        
    }
    
    /**
     * Remplissage d'un eleve dans la bdd
     * @param connexion
     * @param inscriptions
     * @throws SQLException 
     */
    public void remplirClasses(Connexion connexion, ArrayList<Inscription> inscriptions) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Inscription WHERE eleve ='"+this.id+"'");
        for(Inscription inscription : inscriptions){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == inscription.getId()){
                this.inscription = inscription;
                break;
            }
        }
         this.display=new DisplayEleve(this);
         
    }
    /**
     * Affichage d'un eleve
     * @param bool 
     */
    public void setVisible(boolean bool){
        this.display.setVisible(bool);
    }
    /**
     * Ajout d'une inscription dans bdd
     * @param inscription 
     */
    public void remplirClasses(Inscription inscription){
        this.inscription = inscription;
    }
    
    /**
     * Suppression d'un eleve dans une ecole
     */
    public void suppression() throws SQLException{
        this.inscription.suppression();
        this.ecole.getConnexion().executeUpdate("DELETE FROM Inscription WHERE id='"+this.inscription.getId()+"'");
        this.inscription = null;
    }
    @Override
    public void reload(){
        this.display = new DisplayEleve(this);
    }
    
    /**
     * getter inscription
     * @return inscription
     */
    public Inscription getInscription(){
        return this.inscription;
    }
}
