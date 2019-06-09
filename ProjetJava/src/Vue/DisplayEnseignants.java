/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Mathilde
 */
import Modele.*;
import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.*;
import java.io.File;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.*;

/**
 *
 * @author Mathilde
 */
public class DisplayEnseignants extends JFrame implements  ActionListener{
     // private JButton eleves= new JButton("Eleves");
    //private JButton enseignants= new JButton("Enseignants");
   // private JButton classes= new JButton("Classes");
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton retour2= new JButton(new ImageIcon("r2.png")); 
    private JButton menu= new JButton("Menu");
    private ArrayList<JButton> rechercher= new ArrayList <JButton>();
    private ArrayList<JButton> supprimer= new ArrayList <JButton>();
    private ArrayList<JPanel> enseignants = new ArrayList<JPanel>();
    private JButton ajouter= new JButton(new ImageIcon("ajouter.png"));
    private JLabel titre = new JLabel("");
    private JPanel container = new JPanel();
    private JLabel nom = new JLabel("");
    private JLabel prenom = new JLabel("");
    private JLabel nomEcole = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    private Ecole ecole;
    private ArrayList<JPanel> ArrayList;
    
    
     private JLabel l=new JLabel("AJOUT D'UN ENSEIGNANT:");
        private JLabel l1=new JLabel("Nom :");  
        private JLabel l2=new JLabel("Prenom :"); 
        private JLabel error = new JLabel("");
        private JTextField nomtext= new JTextField();
        private JTextField prenomtext= new JTextField();
        
     
        private JFrame f=new JFrame("LOGIN");
        private JButton bouton = new JButton("ENTRER");
        
        /**
         * permet l'affichage d'une page graphique qui liste tous les enseignants de l'ecole avec un bouton permet d'accéder à plus d'infos sur l'enseignant et un autre pour supprimer l'enseignant
         * un bouton pour ajouter un enseignement est egalement present, et des boutons permettant de quitter et retourner au menu sont ajoutées
         * @param ecole 
         */
    public DisplayEnseignants(Ecole ecole){
        this.ecole = ecole;
    
     

        setTitle("Enseignant");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        this.ajouter.addActionListener(this);
        this.retour.addActionListener(this);
        this.menu.addActionListener(this);
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.titre.setText("Fiche enseignants");
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
       pan3.setLayout(new BorderLayout()); 
         
        this.container.setLayout(new GridLayout(this.ecole.getEnseignants().size()+3,4));
         this.container.add(new JLabel("Nom"));
          this.container.add(new JLabel("Prenom"));
          this.container.add(new JLabel(""));
          this.container.add(new JLabel(""));
        for(Enseignant enseignant : this.ecole.getEnseignants()){
            JLabel nom= new JLabel(enseignant.getNom()+"   ");
            JLabel prenom= new JLabel( enseignant.getPrenom());
            this.rechercher.add(new JButton(new ImageIcon("loupe.png")));
            this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
            this.rechercher.get(this.rechercher.size()-1).addActionListener(this);
            this.supprimer.get(this.rechercher.size()-1).addActionListener(this);
            this.container.add(nom);
            this.container.add(prenom);
            this.container.add(this.rechercher.get(this.rechercher.size()-1));
            this.container.add(this.supprimer.get(this.rechercher.size()-1));
            
        }
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.container.add(this.ajouter);
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.add(this.container);
         
        //this.nom.setText("Nom: "+this.enseignant.getNom());
        //this.prenom.setText("Prénom: "+this.enseignant.getPrenom());
        this.titre.setFont(new Font("Serif", Font.BOLD, 50));
        this.prenom.setFont(new Font("Serif", Font.BOLD, 25));
        this.nom.setFont(new Font("Serif", Font.BOLD, 25));
        
        this.quitter.setSize(200,200);
        //this.label.setForeground(Color.GRAY);
        //Dimension d = label.getPreferredSize();
       
       // this.label.setPreferredSize(new Dimension(100, 70));
       pan.setPreferredSize(new Dimension(450,300));
       pan2.setPreferredSize(new Dimension(350,300));
       pan3.setPreferredSize(new Dimension(250,50));
        this.pan.add(this.titre,BorderLayout.NORTH);
        this.pan2.add(this.nom,BorderLayout.WEST);
        this.pan2.add(this.prenom,BorderLayout.EAST);
        this.pan3.add(this.retour,BorderLayout.WEST);
        this.pan3.add(this.menu,BorderLayout.CENTER);
        this.pan3.add(this.quitter,BorderLayout.EAST);
        
        
        
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add("North",pan);
        this.getContentPane().add("Weast",pan2);
        this.getContentPane().add("South",pan3);
        
        
    }
    
    /**
     * cette fonction permet de realiser des actions lorqu'on clique sur les boutons 
     * @param arg0 
     */
     @Override
    public void actionPerformed(ActionEvent arg0) {      
       if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
       
       else if(arg0.getSource()==this.menu)
        {
           this.ecole.setVisibleDisplayEleves(false);
           this.ecole.setVisibleMenu(true);
        }
       else if(arg0.getSource()==this.ajouter)
        {
            this.dispose();
            ajouter();
            //action a faire quand on clique sur le bouton4
            //System.exit(0);
        }
       else if(arg0.getSource()==this.retour){
           this.ecole.setVisibleDisplayEnseignants(false);
           this.ecole.setVisibleMenu(true);
       }
       else if(arg0.getSource()==this.retour2){
           f.setVisible(false);
           this.ecole.setVisibleDisplayEnseignants(true);
       }else if(arg0.getSource()==this.bouton){
           f.setVisible(false);
           try {
               this.ecole.ajoutEnseignant(this.nomtext.getText(), this.prenomtext.getText());
           } catch (SQLException ex) {
               Logger.getLogger(DisplayEnseignants.class.getName()).log(Level.SEVERE, null, ex);
           }
           this.ecole.setVisibleDisplayEnseignants(true);
       }
       
       for(int i=0; i<this.rechercher.size();i++){
           if(arg0.getSource()==this.rechercher.get(i)){
                this.ecole.getEnseignant(i).setVisible(true);
                this.ecole.setVisibleDisplayEnseignants(false);
           }
       }
       for(int i=0; i<this.supprimer.size();i++){
           if(arg0.getSource()==this.supprimer.get(i)){
               this.setVisible(false);
               try {
                   this.ecole.supprimerEnseignant(this.ecole.getEnseignants().get(i));
               } catch (SQLException ex) {
                   Logger.getLogger(DisplayEnseignants.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
      
        
    } 
    
    /**
     * fonction qui permet d'afficher une page graphique pour saisir toutes les donnes l'enseignant à ajouter
     */
     private void ajouter()
    {
        setTitle("AJOUTER"); 
		setSize(830,730); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                 
                 this.quitter.addActionListener(this);
                  this.bouton.addActionListener(this);
                  this.retour2.addActionListener(this);
		JPanel panel2 = new JPanel();
                final JLabel label2 = new JLabel();            
                label2.setBounds(20,250, 200,50);
                pan3.setLayout(new BorderLayout()); 
               
                   
        
    
       
 
         
        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 30)); 
        l1.setBounds(20,100, 130,30);      
        l2.setBounds(20,150, 130,30);
          
        bouton.setBounds(100,350, 150,30); 
        retour2.setBounds(350,350, 400,60);  
        nomtext.setBounds(140,100, 100,30);
        prenomtext.setBounds(140,150, 100,30);
        error.setBounds(50,350,400,30);
        error.setForeground(Color.red);
        error.setFont(new Font("Serif", Font.BOLD, 25));
                f.add(l); 
                f.add(l1); 
                f.add(l2);
                f.add(nomtext);
                f.add(prenomtext);
                f.add(retour2);
                f.add(bouton);
                
                f.add(this.error);
               
                  
             
        

       
        
		f.setSize(830,730); 
                f.setBackground(Color.PINK);
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    }
   
}

