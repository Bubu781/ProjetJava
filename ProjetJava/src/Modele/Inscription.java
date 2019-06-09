package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inscription {
    /**
     * Attributs prives de la classe Inscription
     */
    private Ecole ecole;
    private int id;
    private Classe classe;
    private Eleve eleve;
    private ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();
    
    /**
     * Constructeur surchargé
     * @param id
     * @param ecole 
     */
    public Inscription(int id, Ecole ecole){
        this.id = id;
        this.ecole = ecole;
    }
    /**
     * Constructeur surchargé
     * @param connexion
     * @param ecole
     * @param classe
     * @param eleve
     * @throws SQLException 
     */
    public Inscription(Connexion connexion, Ecole ecole, Classe classe, Eleve eleve) throws SQLException{
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Inscription(classe, eleve) VALUES("+classe.getId()+","+eleve.getId()+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Inscription WHERE classe = '"+classe.getId()+"' AND eleve = '"+eleve.getId()+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));
        this.ecole=ecole;
        this.classe=classe;
        this.eleve=eleve;
        
        //Creation d'un bulletin lors de l'inscription d'un eleve et son ajout dans l'arrayList bulletins
        Bulletin bulletin = new Bulletin(connexion,this.ecole,classe);
        this.bulletins.add(bulletin);
    }
    
    /**
     * 
     * @param connexion
     * @param classes
     * @param eleves
     * @param bulletins
     * @throws SQLException 
     */
    public void remplirClasses(Connexion connexion, ArrayList<Classe> classes, ArrayList<Eleve> eleves,ArrayList<Bulletin> bulletins) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT classe FROM Inscription WHERE Id = '"+this.id+"'");
        for(Classe classe : classes){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == classe.getId()){
                this.classe = classe;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT eleve FROM Inscription WHERE Id = '"+this.id+"'");
        for(Eleve eleve : eleves){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == eleve.getId()){
                this.eleve = eleve;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Bulletin WHERE inscription = '"+this.id+"'");
        for(String requete : requetes){
            for(Bulletin bulletin : bulletins){
                if(Integer.parseInt(requete.substring(0,requete.length()-1)) == bulletin.getId()){
                    this.bulletins.add(bulletin);
                }
            }
        }
    }
    /**
     * Suppression d'un bulletin
     */
    public void suppression() throws SQLException{
        for(Bulletin bulletin : this.bulletins){
            bulletin.suppression();
            this.ecole.getConnexion().executeUpdate("DELETE FROM Bulletin WHERE id='"+bulletin.getId()+"'");
        }
        this.bulletins.removeAll(this.bulletins);
    }
   
    /**
     * getter de l'id
     * @return l'id
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * getter du bulletin
     * @return le bulletin
     */
    public Bulletin getBulletin(){
        return this.bulletins.get(0);
    }
    /**
     * getter de la classe
     * @return la classe
     */
    public Classe getClasse(){
        return this.classe;
    }
    
    /**
     * getter eleve
     * @return l'eleve
     */
    public Eleve getEleve(){
        return this.eleve;
    }
    
}
