package Modele;

import BDD.Connexion;
import Vue.DisplayClasse;
import Vue.DisplayClasses;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Classe {
    private DisplayClasse display;
    private int id;
    private String nom;
    private AnneeScolaire annee; //
    private Ecole ecole; //
    private Niveau niveau; //
    private ArrayList<Inscription> inscriptions = new ArrayList<Inscription>(); //
    private ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>(); //
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
    public Classe(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Classe WHERE id = '"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
    public Classe(Connexion connexion, String nom, Niveau niveau, AnneeScolaire annee, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Classe(nom, ecole, niveau, annee_scolaire) VALUES('"+nom+"',1,"+String.valueOf(niveau.getId())+","+String.valueOf(annee.getId())+")");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Classe WHERE nom='"+nom+"' AND niveau ='"+String.valueOf(niveau.getId())+"' AND annee_scolaire = '"+String.valueOf(annee.getId())+"'");
        this.id = parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        this.ecole = ecole;
        this.nom = nom;
        this.niveau = niveau;
        this.annee = annee;
        this.reload();
    }
    
    /**
     * Fonction de remplissage des classes d'apres la BDD
     * @param connexion
     * @param annees
     * @param niveaux
     * @param inscriptions
     * @param enseignements
     * @throws SQLException 
     */
    public void remplirClasses(Connexion connexion, ArrayList<AnneeScolaire> annees, ArrayList<Niveau> niveaux, ArrayList<Inscription> inscriptions, ArrayList<Enseignement> enseignements) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT annee_scolaire FROM Classe WHERE id='"+this.id+"'");
        for(AnneeScolaire annee : annees){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == annee.getId()){
                this.annee = annee;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT niveau FROM Classe WHERE id='"+this.id+"'");
        for(Niveau niveau : niveaux){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == niveau.getId()){
                this.niveau = niveau;
                break;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Inscription WHERE classe='"+this.id+"'");
        for(String requete : requetes){
            for(Inscription inscription : inscriptions){
                if(Integer.parseInt(requete.substring(0,requete.length()-1)) == inscription.getId()){
                    this.inscriptions.add(inscription);
                }
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Enseignement WHERE classe='"+this.id+"'");
        for(String requete : requetes){
            for(Enseignement enseignement : enseignements){
                if(Integer.parseInt(requete.substring(0,requete.length()-1)) == enseignement.getId()){
                    this.enseignements.add(enseignement);
                }
            }
        }
        this.display=new DisplayClasse(this);
    }
    
    /**
     * Fonction de modification d'une classe
     * @param nom
     * @param annee
     * @param niveau 
     */
    public void modifier(String nom, AnneeScolaire annee, Niveau niveau) throws SQLException{
        this.ecole.getConnexion().executeUpdate("UPDATE Classe SET nom = '"+nom+"', annee = '"+annee.getId()+"', niveau = '"+niveau.getId()+"' WHERE id = '"+this.id+"'");
        this.nom = nom;
        this.annee = annee;
        this.niveau = niveau;
        this.reload();
    }
    
    /**
     * Fonction d'ajout d'un eleve a une classe ( en ajoutant l'inscription)
     * @param inscription 
     */
    public void ajoutInscription(Inscription inscription){
        this.inscriptions.add(inscription);
    }
    
    /**
     * Fonction d'ajout d'un enseignant a une classe
     * @param enseignement 
     */
    public void ajoutEnseignement(Enseignement enseignement){
        this.enseignements.add(enseignement);
    }
    
    /**
     * Fonction de suppression d'une classe
     */
    public void suppression() throws SQLException{
        for(Inscription inscription : this.inscriptions){
            inscription.suppression();
            this.ecole.getConnexion().executeUpdate("DELETE FROM Inscription WHERE id='"+inscription.getId()+"'");
        }
        for(Enseignement enseignement : this.enseignements){
            this.ecole.getConnexion().executeUpdate("DELETE FROM Enseignement WHERE id = '"+enseignement.getId()+"'");
        }
        this.inscriptions.removeAll(this.inscriptions);
        this.enseignements.removeAll(this.enseignements);
    }
    
    public void reload(){
        this.display = new DisplayClasse(this);
        this.ecole.reloadClasses();
    }
    /**
     * Geter de id
     * @return id
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Geter d'annee scolaire
     * @return annee scolaire
     */
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
    /**
     * Getter d'une ecole
     * @return 
     */
    public Ecole getEcole(){
        return this.ecole;
    }
    /**
     * getter du niveau de la classe
     * @return niveau
     */
    public Niveau getNiveau(){
        return this.niveau;
    }
    
    /**
     * getter du nom de la classe
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Getter d'enseignement
     * @return enseignements
     */
    public ArrayList<Enseignement> getEnseignements(){
        return this.enseignements;
    }
    
    /**
     * getter des inscriptions
     * @return inscriptions
     */
    public ArrayList<Inscription> getInscriptions(){
        return this.inscriptions;
    }
            
    public void setVisible(boolean bool){
        this.display.setVisible(bool);
    }
}
