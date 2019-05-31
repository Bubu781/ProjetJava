/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import BDD.*;
import java.sql.SQLException;
import Modele.*;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author iGamer
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("school","root","root");
        initConnexion(connexion);
        for(String values : connexion.tables){
            ArrayList<String> x = connexion.remplirChampsRequete("Select * FROM " + values);
            for(String val : x){
                System.out.println(val);
            }
        }
        Ecole ecole = new Ecole(); 
    }
    public static void initConnexion(Connexion connexion){
        connexion.ajouterTable("AnneeScolaire");
        connexion.ajouterTable("Bulletin");
        connexion.ajouterTable("Classe");
        connexion.ajouterTable("DetailBulletin");
        connexion.ajouterTable("Discipline");
        connexion.ajouterTable("Ecole");
        connexion.ajouterTable("Eleve");
        connexion.ajouterTable("Enseignant");
        connexion.ajouterTable("Enseignement");
        connexion.ajouterTable("Evaluation");
        connexion.ajouterTable("Inscription");
        connexion.ajouterTable("Niveau");
        connexion.ajouterTable("Personne");
        connexion.ajouterTable("Trimestre");
    }
}
