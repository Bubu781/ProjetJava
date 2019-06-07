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
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.layout.Border;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class DisplayEnseignant extends JFrame implements  ActionListener {
    
   // private JButton eleves= new JButton("Eleves");
    //private JButton enseignants= new JButton("Enseignants");
   // private JButton classes= new JButton("Classes");
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton modifier= new JButton("Modifier les informations de l'enseignant"); 
    private JButton menu= new JButton("Menu");
    private JPanel container = new JPanel();
    
    private JLabel titre = new JLabel("");
    private JLabel nom = new JLabel("");
    private JLabel prenom = new JLabel("");
    private JLabel ecole = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    private ArrayList<JButton> supprimer= new ArrayList <JButton>();
    
    private Enseignant enseignant;
    
    
    public DisplayEnseignant(Enseignant enseignant){
        
    
     

        setTitle("Enseignant");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.titre.setText("Fiche enseignant");
        
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
        
         
       this.titre.setFont(new Font("Serif", Font.BOLD, 50));  
       pan.setPreferredSize(new Dimension(450,300));
       this.pan.add(this.titre,BorderLayout.NORTH);
       
         this.enseignant = enseignant;
        
          JLabel info = new JLabel("Nom : " + this.enseignant.getNom() + "  Prénom : "+this.enseignant.getPrenom());
          
        this.pan.add(info);
        this.getContentPane().add("North",pan);
        
        //this.container.setPreferredSize(new Dimension(450,300));
         this.container.setLayout(new GridLayout(this.enseignant.getEnseignement().size()+1,4));
         this.container.add(new JLabel("Nom Classe"));
         this.container.add(new JLabel("Niveau "));
         this.container.add(new JLabel("Discipline "));
         this.container.add(new JLabel(""));
          for(Enseignement enseignement : enseignant.getEnseignement()){
            JLabel nom_classe= new JLabel(enseignement.getClasse().getNom()+"   ");
            JLabel niveau= new JLabel( enseignement.getClasse().getNiveau().getNom()+"   ");
            JLabel discipline= new JLabel( enseignement.getDiscipline().getNom()+"   ");
            this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
            this.supprimer.get(this.supprimer.size()-1).addActionListener(this);
            this.container.add(nom_classe);
            this.container.add(niveau);
            this.container.add(discipline);
            this.container.add(this.supprimer.get(this.supprimer.size()-1));
            
        }
        this.add(this.container);
        this.modifier.addActionListener(this);
        
       
        //this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
        
        
        //this.add(this.container);
        
      
       pan2.setPreferredSize(new Dimension(300,50));
       pan3.setPreferredSize(new Dimension(250,50));
        
        //this.pan2.add(this.nom,BorderLayout.WEST);
        this.pan2.add(this.modifier,BorderLayout.EAST);
       // this.pan2.add(this.prenom,BorderLayout.EAST);
        this.pan3.add(this.retour,BorderLayout.WEST);
        this.pan3.add(this.menu,BorderLayout.CENTER);
        this.pan3.add(this.quitter,BorderLayout.EAST);
        
        
        
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().add("Weast",pan2);
        this.getContentPane().add("South",pan3);
        
        
    }
    
    
     @Override
    public void actionPerformed(ActionEvent arg0) {      
       if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
       else if(arg0.getSource()==this.menu){
           
           //this.ecole.setVisibleMenu(true);
       }
        else if(arg0.getSource()==this.retour){
           //this.ecole.setVisibleDisplayEnseignant(false);
           //this.ecole.setVisibleMenu(true);
       }
      
        
    } 
   
}
