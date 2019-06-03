package Modele;

import BDD.Connexion;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inscription {
    private Ecole ecole;
    private int id;
    private Classe classe;
    private Eleve eleve;
    private ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();
    
    public Inscription(int id, Ecole ecole){
        this.id = id;
        this.ecole = ecole;
    }
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
            
    public int getId(){
        return this.id;
    }
    public Classe getClasse(){
        return this.classe;
    }
    
    public Eleve getEleve(){
        return this.eleve;
    }
}
