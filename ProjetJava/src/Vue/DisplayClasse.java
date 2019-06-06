/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.*;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Random;
import javafx.scene.layout.Border;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class DisplayClasse extends JFrame implements  ActionListener {
    
   // private JButton eleves= new JButton("Eleves");
    //private JButton enseignants= new JButton("Enseignants");
   // private JButton classes= new JButton("Classes");
    private JButton quitter= new JButton("Quitter");
    
    private JLabel titre = new JLabel("");
    private JLabel nom = new JLabel("");
    private JLabel prenom = new JLabel("");
    private JLabel ecole = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    private Classe classe;
    
    
    //private Enseignant enseignant;
    
   
    public DisplayClasse(Classe classe){
       
        
        //this.setVisible(true);
        
    
    
    
    


        setTitle("Classe");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.titre.setText("Fiche classe");
        
        
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
        
         this.classe = classe;
         JLabel titre = new JLabel("Classe "+this.classe.getNom() + ", Annee : "+this.classe.getAnneeScolaire().getAnnee());
        this.add(titre);
        //this.nom.setText("Nom: "+this.enseignant.getNom());
        //this.prenom.setText("Prénom: "+this.enseignant.getPrenom());
        this.titre.setFont(new Font("Serif", Font.BOLD, 50));
        this.prenom.setFont(new Font("Serif", Font.BOLD, 20));
        this.nom.setFont(new Font("Serif", Font.BOLD, 20));
        
        this.quitter.setSize(200,200);
        //this.label.setForeground(Color.GRAY);
        //Dimension d = label.getPreferredSize();
       
       // this.label.setPreferredSize(new Dimension(100, 70));
       pan.setPreferredSize(new Dimension(450,300));
       pan2.setPreferredSize(new Dimension(350,300));
       pan3.setPreferredSize(new Dimension(80,80));
        this.pan.add(this.titre,BorderLayout.NORTH);
        this.pan2.add(this.nom,BorderLayout.WEST);
        this.pan2.add(this.prenom,BorderLayout.EAST);
        this.pan3.add(this.quitter,BorderLayout.SOUTH);
        
        
        
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add("North",pan);
        this.getContentPane().add("Weast",pan2);
        this.getContentPane().add("South",pan3);
        
        
       // this.setVisible(true);
        
    }
    
    
     @Override
    public void actionPerformed(ActionEvent arg0) {      
       if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
      
        
    } 
   
}