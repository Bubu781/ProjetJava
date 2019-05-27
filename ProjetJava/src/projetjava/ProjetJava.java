/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import BDD.*;
import Vue.Menu;
/**
 *
 * @author iGamer
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu m=new Menu();
        LectureBDD l = new LectureBDD();
        l.initFromFile();
        System.out.println("heyyy");
    }
    
}
