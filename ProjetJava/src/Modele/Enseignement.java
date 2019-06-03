package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Enseignement {
    private Ecole ecole;
    private int id;
    private Classe classe;
    private Discipline discipline;
    private Enseignant enseignant;
    
    public Enseignement(Connexion connexion, int id, Ecole ecole){
        this.ecole = ecole;
        this.id = id;
    }
    
    public Enseignement(Connexion connexion, Enseignant enseignant, Classe classe, Discipline discipline, Ecole ecole ) throws SQLException{
        
        ArrayList<String> requetes;
        connexion.executeUpdate("INSERT INTO Enseignement(classe,discipline, enseignant) VALUES("+classe.getId()+","+discipline.getId()+","+enseignant.getId()+");");
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Enseignement WHERE classe = '"+classe+"' AND discipline = '"+discipline+"'AND enseignant = '"+enseignant+"'");
        this.id = Integer.parseInt(requetes.get(0).substring(0, requetes.get(0).length()-1));        
        this.enseignant=enseignant;
        this.classe=classe;
        this.discipline=discipline;
    }
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
    public int getId(){
        return this.id;
    }
    
    public Discipline getDiscipline(){
        return this.discipline;
    }
    public Classe getClasse(){
        return this.classe;
    }
    public Enseignant getEnseignant(){
        return this.enseignant;
    }
    
}
