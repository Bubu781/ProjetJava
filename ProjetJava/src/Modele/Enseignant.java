package Modele;

import BDD.Connexion;
import Vue.DisplayEnseignant;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Enseignant extends Personne {
    private ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>();
    private DisplayEnseignant display;
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
       
    public Enseignant(Connexion connexion, int id, Ecole ecole) throws SQLException{
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
    public Enseignant(Connexion connexion, String nom, String prenom, Ecole ecole) throws SQLException {
        super(connexion, nom, prenom,ecole);
        connexion.executeUpdate("INSERT INTO Enseignant(personne) VALUES("+this.id+");");
    }
    
    /**
     *  Remplissage d'un enseignant dans la bdd
     * @param connexion
     * @param enseignements
     * @throws SQLException 
     */
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
        this.display=new DisplayEnseignant(this);
    }
    /**
     * Ajout d'un enseignant dans une ecole
     * @param enseignement
     * @throws SQLException 
     */
    public void ajoutEnseignement(Enseignement enseignement ) throws SQLException{
        this.enseignements.add(enseignement);
    }
    /**
     * Suppression d'un enseignant dans une ecole
     */
    public void suppression() throws SQLException{
        for(Enseignement enseignement : this.enseignements){
            this.ecole.getConnexion().executeUpdate("DELETE FROM Enseignement WHERE id = '"+enseignement.getId()+"'");
        }
        this.enseignements.removeAll(this.enseignements);
    }
    
    public void supprimerEnseignement(Enseignement enseignement){
        this.enseignements.remove(enseignement);
        this.reload();
    }
    @Override
    public void reload(){
        this.display = new DisplayEnseignant(this);
        this.ecole.reloadEnseignants();
    }
   
    /**
     * Affichage d'un enseignant 
     * @param bool 
     */
    public void setVisible(boolean bool){
        this.display.setVisible(bool);
    }
    /**
     * 
     * @return l'arrayList nommé enseignements dans les attributs de la cette classe
     */
    public ArrayList<Enseignement> getEnseignement(){
        return this.enseignements;
    }
}
