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
    public Eleve(Connexion connexion, int id, Ecole ecole) throws SQLException{
        super(connexion, id, ecole);
    }
    
    public Eleve (Connexion connexion, String nom, String prenom, Ecole ecole) throws SQLException{
        super(connexion, nom, prenom, ecole);
        connexion.executeUpdate("INSERT INTO Eleve(personne) VALUES("+this.id+");");
        
        
        
    }
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
    public void setVisible(boolean bool){
        this.display.setVisible(bool);
    }
    public void remplirClasses(Inscription inscription){
        this.inscription = inscription;
    }
    public void suppression(){
        this.inscription.suppression();
        this.inscription = null;
    }
    public Inscription getInscription(){
        return this.inscription;
    }
}
