package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Enseignement {
    /**
     * attributs de la classe en privé
     */
    private Ecole ecole;
    private int id;
    private Classe classe;
    private Discipline discipline;
    private Enseignant enseignant;
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param id
     * @param ecole 
     */
    public Enseignement(Connexion connexion, int id, Ecole ecole){
        this.ecole = ecole;
        this.id = id;
    }
    
    /**
     * Constructeur surchargé
     * @param connexion
     * @param enseignant
     * @param classe
     * @param discipline
     * @param ecole
     * @throws SQLException 
     */
    public Enseignement(Connexion connexion, Enseignant enseignant, Classe classe, Discipline discipline, Ecole ecole ) throws SQLException{
        
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Enseignement(classe,discipline, enseignant) VALUES("+classe.getId()+","+discipline.getId()+","+enseignant.getId()+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Enseignement WHERE classe = '"+classe.getId()+"' AND discipline = '"+discipline.getId()+"'AND enseignant = '"+enseignant.getId()+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));        
        this.enseignant=enseignant;
        this.enseignant.ajoutEnseignement(this);
        this.classe=classe;
        this.discipline=discipline;
    }
    /**
     * Remplissage d'un enseignement dans la bdd
     * @param connexion
     * @param classes
     * @param disciplines
     * @param enseignants
     * @throws SQLException 
     */
    public void remplirClasses(Connexion connexion, ArrayList<Classe> classes, ArrayList<Discipline> disciplines, ArrayList<Enseignant> enseignants) throws SQLException{
        ArrayList<String> requetes;
        requetes = connexion.remplirChampsRequete("SELECT classe FROM Enseignement WHERE Id = '"+this.id+"'");
        for(Classe classe : classes){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == classe.getId()){
                this.classe = classe;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT discipline FROM Enseignement WHERE Id = '"+this.id+"'");
        for(Discipline discipline : disciplines){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == discipline.getId()){
                this.discipline = discipline;
            }
        }
        requetes = connexion.remplirChampsRequete("SELECT enseignant FROM Enseignement WHERE Id = '"+this.id+"'");
        for(Enseignant enseignant : enseignants){
            if(Integer.parseInt(requetes.get(0).substring(0,requetes.get(0).length()-1)) == enseignant.getId()){
                this.enseignant = enseignant;
            }
        }
    }
    /**
     * getter de l'id
     * @return l'identifiant, l'attribut nomme id dans les attributs de la classe
     */
    public int getId(){
        return this.id;
    }
    /**
     * getter de la discipline 
     * @return l'attribut nomme discipline dans les attributs de la classe
     */
    public Discipline getDiscipline(){
        return this.discipline;
    }
    /**
     * getter de la classe
     * @return l'attribut nomme classe dans les attributs de la classe
     */
    public Classe getClasse(){
        return this.classe;
    }
    /**
     * getter de l'enseignant
     * @return l'enseignant
     */
    public Enseignant getEnseignant(){
        return this.enseignant;
    }
    
}
