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
        Connexion connexion = new Connexion("school","root","");
        Ecole ecole = new Ecole(connexion); 
    }
}
