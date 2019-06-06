package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Classe {
    private int id;
    private String nom;
    private AnneeScolaire annee; //
    private Ecole ecole; //
    private Niveau niveau; //
    private ArrayList<Inscription> inscriptions = new ArrayList<Inscription>(); //
    private ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>(); //
    
    public Classe(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        requetes = connexion.remplirChampsRequete("SELECT nom FROM Classe WHERE id = '"+id+"'");
        this.nom = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    
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
    }
    
    public void modifier(String nom, AnneeScolaire annee, Niveau niveau){
        this.nom = nom;
        this.annee = annee;
        this.niveau = niveau;
    }
    
    public void ajoutInscription(Inscription inscription){
        this.inscriptions.add(inscription);
    }
    
    public void ajoutEnseignement(Enseignement enseignement){
        this.enseignements.add(enseignement);
    }
            
    public void suppression(){
        for(Inscription inscription : this.inscriptions){
            inscription.suppression();
        }
        this.inscriptions.removeAll(this.inscriptions);
        this.enseignements.removeAll(this.enseignements);
    }
    
    public int getId(){
        return this.id;
    }
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
    public Ecole getEcole(){
        return this.ecole;
    }
    
    public Niveau getNiveau(){
        return this.niveau;
    }
    
    public String getNom(){
        return this.nom;
    }
}
