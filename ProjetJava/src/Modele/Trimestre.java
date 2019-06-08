package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Trimestre {
    /**
     * attributs prives de la classe Trimestre
     */
    private Ecole ecole;
    private int id;
    private int numero;
    private AnneeScolaire annee;
    private String debut;
    private String fin;
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole
     * @throws SQLException 
     */
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
    /**
     * Remplissage d'un trimestre dans la BDD
     * @param connexion
     * @param annees
     * @throws SQLException 
     */
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
    
    /**
     * modifie les dates de debuts et fin de l'année, l'année scolaire et le numero
     * @param debut
     * @param fin
     * @param annee
     * @param numero 
     */
    public void modifier(String debut, String fin, AnneeScolaire annee, int numero){
        this.debut = debut;
        this.fin = fin;
        this.annee = annee;
        this.numero = numero;
    }
    
    /**
     * getter de l'annee scolaire
     * @return l'annee scolaire
     */
    public AnneeScolaire getAnneeScolaire(){
        return this.annee;
    }
    
    /**
     * getter de l'id
     * @return id
     */
     public int getId(){
        return this.id;
    }
     
     /**
      * getter du numero
      * @return numero
      */
    public int getNumero(){
        return this.numero;
    }
    /**
     * getter des dates de debut de l'annee
     * @return debut
     */
    public String getDebut(){
        return this.debut;
    }
    
    /**
     * getter des dates de fin de l'annee
     * @return 
     */
    public String getFin(){
        return this.fin;
    }
    
}
