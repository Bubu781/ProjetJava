package Modele;

import BDD.Connexion;
import Vue.Menu;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ecole {
    private Connexion connexion;
    private int id;
    private String nom;
    private Menu display;
    private ArrayList<Eleve> eleves;
    private ArrayList<Enseignant> enseignants;
    private ArrayList<Classe> classes;
    private ArrayList<Discipline> disciplines;
    private ArrayList<Niveau> niveaux;
    private ArrayList<AnneeScolaire> annees;
    private ArrayList<Trimestre> trimestres;
    public Ecole(Connexion connexion) throws SQLException{
        this.connexion = connexion;
        ArrayList<String> requetes;
        ArrayList<AnneeScolaire> annees = new ArrayList<AnneeScolaire>();
        ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();
        ArrayList<Classe> classes = new ArrayList<Classe>();
        ArrayList<DetailBulletin> details = new ArrayList<DetailBulletin>();
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        ArrayList<Eleve> eleves = new ArrayList<Eleve>();
        ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>();
        ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
        ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();
        ArrayList<Niveau> niveaux = new ArrayList<Niveau>();
        ArrayList<Trimestre> trimestres = new ArrayList<Trimestre>();
        requetes = connexion.remplirChampsRequete("SELECT Id FROM AnneeScolaire");
        for(String requete : requetes){
            annees.add(new AnneeScolaire(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Bulletin");
        for(String requete : requetes){
            bulletins.add(new Bulletin(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Classe");
        for(String requete : requetes){
            classes.add(new Classe(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM DetailBulletin");
        for(String requete : requetes){
            details.add(new DetailBulletin(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Discipline");
        for(String requete : requetes){
            disciplines.add(new Discipline(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT personne FROM Eleve");
        for(String requete : requetes){
            eleves.add(new Eleve(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT personne FROM Enseignant");
        for(String requete : requetes){
            enseignants.add(new Enseignant(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Enseignement");
        for(String requete : requetes){
            enseignements.add(new Enseignement(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Evaluation");
        for(String requete : requetes){
            evaluations.add(new Evaluation(connexion, Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Inscription");
        for(String requete : requetes){
            inscriptions.add(new Inscription(Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Niveau");
        for(String requete : requetes){
            niveaux.add(new Niveau(connexion,Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        requetes = connexion.remplirChampsRequete("SELECT Id FROM Trimestre");
        for(String requete : requetes){
            trimestres.add(new Trimestre(connexion,Integer.parseInt(requete.substring(0,requete.length()-1)), this));
        }
        for(Bulletin bulletin : bulletins){
            bulletin.remplirClasses(connexion, trimestres, inscriptions, details);
        }
        for(Classe classe : classes){
            classe.remplirClasses(connexion, annees, niveaux, inscriptions, enseignements);
        }
        for(DetailBulletin detail : details){
            detail.remplirClasses(connexion, enseignements, bulletins, evaluations);
        }
        for(Eleve eleve : eleves){
            eleve.remplirClasses(connexion, inscriptions);
        }
        for(Enseignant enseignant : enseignants){
            enseignant.remplirClasses(connexion, enseignements);
        }
        for(Enseignement enseignement : enseignements){
            enseignement.remplirClasses(connexion, classes, disciplines, enseignants);
        }
        for(Evaluation evaluation : evaluations){
            evaluation.remplirClasses(connexion, details);
        }
        for(Inscription inscription : inscriptions){
            inscription.remplirClasses(connexion, classes, eleves, bulletins);
        }
        for(Trimestre trimestre : trimestres){
            trimestre.remplirClasses(connexion, annees);
        }
        this.eleves = eleves;
        this.classes = classes;
        this.enseignants = enseignants;
        this.disciplines = disciplines;
        this.niveaux = niveaux;
        this.annees = annees;
        this.trimestres = trimestres;
        this.display = new Menu(this);
    }
    public void ajoutEleve(String nom, String prenom, Classe classe) throws SQLException{
        Eleve eleve = new Eleve(this.connexion,nom, prenom, this);
        this.eleves.add(eleve);
        this.classes.add(classe);
        Inscription inscription = new Inscription(this.connexion, this, classe, eleve);
        eleve.remplirClasses(inscription);
        classe.ajoutInscription(inscription);
    }
    
    public void ajoutEnseignant(String nom, String prenom) throws SQLException{
        Enseignant enseignant= new Enseignant(this.connexion, nom, prenom, this);
        this.enseignants.add(enseignant);
    }
    
    public void ajoutEnseignement(Enseignant enseignant, Classe classe, Discipline discipline) throws SQLException{
        Enseignement enseignement= new Enseignement(this.connexion, enseignant, classe,  discipline,this);
        classe.ajoutEnseignement(enseignement);
    }
    
    public void ajouterNiveau(String nom) throws SQLException{
        Niveau niveau= new Niveau(this.connexion, nom, this);
        this.niveaux.add(niveau);
    }
            
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
