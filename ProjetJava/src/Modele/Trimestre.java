package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Trimestre {
    private Ecole ecole;
    private int id;
    private int numero;
    private AnneeScolaire annee;
    private String debut;
    private String fin;
    
    
    public Trimestre(Connexion connexion, int id, Ecole ecole) throws SQLException{
        ArrayList<String> requetes;
        this.id = id;
        this.ecole = ecole;
        requetes = connexion.remplirChampsRequete("SELECT numero FROM Trimestre WHERE id='"+id+"'");
        this.numero = Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1));
        requetes = connexion.remplirChampsRequete("SELECT debut FROM Trimestre WHERE id='"+id+"'");
        this.debut = requetes.get(0).substring(0,requetes.get(0).length()-1);
        requetes = connexion.remplirChampsRequete("SELECT fin FROM Trimestre WHERE id='"+id+"'");
        this.fin = requetes.get(0).substring(0,requetes.get(0).length()-1);
    }
    public void remplirClasses(Connexion connexion, ArrayList<AnneeScolaire> annees) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT annee_scolaire FROM Trimestre WHERE Id = '"+this.id+"'");
        for(AnneeScolaire annee : annees){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == annee.getId()){
                this.annee = annee;
                break;
            }
        }
    }
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
     public int getId(){
        return this.id;
    }
    public int getNumero(){
        return this.numero;
    }
    public String getDebut(){
        return this.debut;
    }
    public String getFin(){
        return this.fin;
    }
    
}
