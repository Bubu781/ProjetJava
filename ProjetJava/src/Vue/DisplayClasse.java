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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class DisplayClasse extends JFrame implements  ActionListener {
   
    /**
     * attributs de la classe 
     */
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton modifier= new JButton(new ImageIcon("modifier.png"));
    private JButton ajouter= new JButton(new ImageIcon("ajouter.png")); 
    private JButton ajoutEnseignement = new JButton("Envoyer");
    private JButton menu= new JButton("Menu");
    private JPanel container = new JPanel();
    private JPanel container2 = new JPanel();
    private JLabel titre = new JLabel("");
    private JLabel nom = new JLabel("");
    private JLabel prenom = new JLabel("");
    private JLabel ecole = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    private JComboBox discipline;
    private JComboBox enseignant;
    private ArrayList<JButton> supprimer= new ArrayList <JButton>();
    
   
     
     
     
	 private JLabel l=new JLabel("MODIFICATION DES INFORMATIONS:");
        private JLabel l1=new JLabel("Nom :");  
        private JLabel l2=new JLabel("Niveau :"); 
        private JLabel l3=new JLabel("Annee:"); 
        private JLabel dis=new JLabel("Discipline :"); 
        private JLabel ens=new JLabel("Enseignant :"); 
        private JLabel error = new JLabel("");
        private JTextField nomclasse= new JTextField();
	private JTextField niveau = new JTextField();
        private JTextField annee = new JTextField(); 
        
     
        private JFrame f=new JFrame("LOGIN");
        private JButton bouton = new JButton("ENTRER");
    
    private Classe classe;
    
    /**
     * Permet l'affichage graphique d'une classe en particulier avec toutes les informations liee a une classe : nom, niveau, discpiline
     * ajout de bouton pour modifier les informations d'une classe
     * @param classe 
     */
    public DisplayClasse(Classe classe){
        
    
     

        setTitle("Classe");
        
        this.quitter.addActionListener(this);
        this.modifier.addActionListener(this);
        this.ajouter.addActionListener(this);
        /**
         * titre en haut de la page graphique
         */
        this.titre.setText("Fiche classe");
        
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
        
         /**
          * taille du titre
          */
       this.titre.setFont(new Font("Serif", Font.BOLD, 50)); 
       pan.setPreferredSize(new Dimension(450,300));
       /**
        * on ajoute le titre au panel nomme pan
        */
       this.pan.add(this.titre,BorderLayout.NORTH);
       
         this.classe = classe;
        
          JLabel info = new JLabel("Nom : " + this.classe.getNom() + "  Niveau : "+classe.getNiveau().getNom() + "Annee : "+String.valueOf(classe.getAnneeScolaire().getAnnee()));
          
        this.pan.add(info);

        /**
         * on cree un container pour afficher les infos d'une classe : nom classe, niveau et discipline
         */
        this.getContentPane().add("North",pan);
         this.container.setLayout(new GridLayout(this.classe.getEnseignements().size()+2,4));
         this.container.add(new JLabel("Nom Classe"));
         this.container.add(new JLabel("Niveau "));
         this.container.add(new JLabel("Discipline "));
         this.container.add(new JLabel(""));
          for(Enseignement enseignement : this.classe.getEnseignements()){
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
          
         this.container.add(new JLabel(""));
         this.container.add(new JLabel(""));
         this.container.add(this.ajouter);
         this.container.add(new JLabel(""));
          this.add(this.container);
          
         /**
          * on affiche le nom et prenom des eleves dans la classe
          */
         this.container2.setLayout(new GridLayout(this.classe.getInscriptions().size()+1,2));
         this.container2.add(new JLabel("Nom"));
          this.container2.add(new JLabel("Prenom"));
          
        for(Inscription inscription : this.classe.getInscriptions()){
            JLabel nom= new JLabel(inscription.getEleve().getNom()+"   ");
            JLabel prenom= new JLabel(inscription.getEleve().getPrenom());
            this.container2.add(nom);
            this.container2.add(prenom);

            
            
        }
          
          
          
        this.add(this.container2);
        //this.modifier.addActionListener(this);
        
       
        //this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
        
        
        //this.add(this.container);
        
      
       pan2.setPreferredSize(new Dimension(300,50));
       pan3.setPreferredSize(new Dimension(250,50));
        
       /**
        * on ajoute les boutons au panel
        */
        this.pan2.add(this.modifier,BorderLayout.CENTER);
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
     /**
      * cette fonction permet de realiser des actions lorqu'on clique sur les boutons 
      */
    public void actionPerformed(ActionEvent arg0) {      
       if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
       else if(arg0.getSource()==this.menu){
           this.setVisible(false);
           this.classe.getEcole().setVisibleMenu(true);
       }
       
        else if(arg0.getSource()==this.retour){
           this.setVisible(false);
           this.classe.setVisible(true);
       }
       else if(arg0.getSource()==this.modifier){
           //this.ecole.setVisibleDisplayEnseignant(false);
           //this.ecole.setVisibleMenu(true);
           this.dispose();
           modifier();
       }else if(arg0.getSource()==this.ajouter){
            this.setVisible(false);
            this.ajouter();
       }else if(arg0.getSource()==this.ajoutEnseignement){
           f.setVisible(false);
           Discipline discipline = this.classe.getEcole().getDisciplines().get(0);
           Enseignant enseignant = this.classe.getEcole().getEnseignants().get(0);
           Object objDiscipline = this.discipline.getSelectedItem();
           Object objEnseignant = this.enseignant.getSelectedItem();
           for(Discipline d : this.classe.getEcole().getDisciplines()){
               if(d.getNom().equals(objDiscipline.toString())){
                   discipline = d;
                   break;
               }
           }
           for(Enseignant e : this.classe.getEcole().getEnseignants()){
               if(e.getNom().equals(objEnseignant.toString())){
                   enseignant = e;
                   break;
               }
           }
           try {
               this.classe.getEcole().ajoutEnseignement(enseignant, this.classe, discipline);
           } catch (SQLException ex) {
               Logger.getLogger(DisplayClasse.class.getName()).log(Level.SEVERE, null, ex);
           }
           this.classe.reload();
       }
       
       
       for(int i=0; i<this.supprimer.size();i++){
           if(arg0.getSource()==this.supprimer.get(i)){
               this.dispose();
                //this.ecole.getEnseignant(i).setVisible(true);
                //this.ecole.setVisibleDisplayEnseignant(false);
           }
       }
      
        
    } 
    
   
/**
 * affichage graphique d'une page pour modifier les infos d'une classe : nom de la classe, niveau et annee scolaire
 */
    private void modifier() {
        setTitle("MODIFICICATION"); 
		setSize(830,730); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                 
                 this.quitter.addActionListener(this);
                  this.bouton.addActionListener(this);
                  this.retour.addActionListener(this);
		JPanel panel2 = new JPanel();
                final JLabel label2 = new JLabel();            
                label2.setBounds(20,250, 200,50);
                pan3.setLayout(new BorderLayout()); 
              
                  
               this.nomclasse.setText(classe.getNom());
               this.niveau.setText(classe.getNiveau().getNom());
               this.annee.setText(String.valueOf(classe.getAnneeScolaire().getAnnee()));
               //this.discipline.setText(enseignement.getDiscipline().getNom()+"   ");
                
                   
        
    
       
 
         
        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 30)); 
        l1.setBounds(20,100, 130,30);      
        l2.setBounds(20,150, 130,30);
           
        l3.setBounds(20,200, 130,30);
          
        bouton.setBounds(100,290, 150,30); 
        retour.setBounds(350,290, 400,60);  
        nomclasse.setBounds(140,100, 100,30); 
        niveau.setBounds(140,150, 100,30); 
        annee.setBounds(140,200, 100,30); 
        error.setBounds(50,350,400,30);
        error.setForeground(Color.red);
        error.setFont(new Font("Serif", Font.BOLD, 25));
                f.add(l); 
                f.add(l1); 
                f.add(l2);
                f.add(nomclasse);
                f.add(l3);
                f.add(niveau);
                f.add(annee);
                f.add(retour);
                f.add(bouton);
                
                f.add(this.error);
               
                  
             
        

       
        
		f.setSize(830,730); 
                f.setBackground(Color.PINK);
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private void ajouter() {
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.quitter.addActionListener(this);
        this.ajoutEnseignement.addActionListener(this);
        this.retour.addActionListener(this);
        JPanel panel2 = new JPanel();
        final JLabel label2 = new JLabel();            
        label2.setBounds(20,250, 200,50);
        pan3.setLayout(new BorderLayout()); 

        String[] nomDisciplines = new String[this.classe.getEcole().getDisciplines().size()];
        String[] nomEnseignants = new String[this.classe.getEcole().getEnseignants().size()];
        for(int i= 0; i< this.classe.getEcole().getDisciplines().size(); i++){
            nomDisciplines[i] = this.classe.getEcole().getDisciplines().get(i).getNom();
        }
        for(int i= 0; i< this.classe.getEcole().getEnseignants().size(); i++){
            nomEnseignants[i] = this.classe.getEcole().getEnseignants().get(i).getNom();
        }
        this.discipline = new JComboBox(nomDisciplines);
        this.enseignant = new JComboBox(nomEnseignants);

        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 30)); 
        dis.setBounds(20,100, 130,30);      
        ens.setBounds(20,150, 130,30);
        ajoutEnseignement.setBounds(100,290, 150,30); 
        retour.setBounds(350,290, 400,60);  
        discipline.setBounds(140,100, 100,30); 
        enseignant.setBounds(140,150, 100,30); 
        error.setBounds(50,350,400,30);
        error.setForeground(Color.red);
        error.setFont(new Font("Serif", Font.BOLD, 25));
        f.add(l); 
        f.add(l1); 
        f.add(l2);
        f.add(discipline);
        f.add(enseignant);
        f.add(retour);
        f.add(ajoutEnseignement);

        f.add(this.error);







        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
   
   
}
   
