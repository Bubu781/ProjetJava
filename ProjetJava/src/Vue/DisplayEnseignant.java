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
    private JButton modifier= new JButton(new ImageIcon("modifier.png")); 
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
    
   
     
     
     
	 private JLabel l=new JLabel("MODIFICATION DES INFORMATIONS:");
        private JLabel l1=new JLabel("Nom :");  
        private JLabel l2=new JLabel("Prénom :"); 
        private JLabel l3=new JLabel("Discipline enseignée:"); 
        private JLabel error = new JLabel("");
        private JTextField nomtext= new JTextField();
	private JTextField prenomtext = new JTextField();
        private JTextField discipline = new JTextField(); 
        
     
        private JFrame f=new JFrame("LOGIN");
        private JButton bouton = new JButton("ENTRER");
       // private JButton quitter= new JButton("Quitter");
        /*
        private JLabel label_titre=new JLabel("MODIFIDICATION DES DONNEES DE L'ENSEIGNANT:");
        private JLabel label_nomclass=new JLabel("Nom des classes :");  
        private JLabel label_niveau=new JLabel("Niveau des classes:"); 
        private JLabel label_discipline=new JLabel("Discipline(s) enseignée(s):"); 
        private JLabel error = new JLabel("");
        private JTextField nomclass = new JTextField();
        private JTextField niveau = new JTextField(); 
        private JTextField discipline = new JTextField(); */
    
    private Enseignant enseignant;
    
    
    public DisplayEnseignant(Enseignant enseignant){
        
    
     

        setTitle("Enseignant");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        this.modifier.addActionListener(this);
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
        //this.modifier.addActionListener(this);
        
       
        //this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
        
        
        //this.add(this.container);
        
      
       pan2.setPreferredSize(new Dimension(300,50));
       pan3.setPreferredSize(new Dimension(250,50));
        
        //this.pan2.add(this.nom,BorderLayout.WEST);
        //this.pan2.add(this.modifier,BorderLayout.EAST);
       // this.pan2.add(this.prenom,BorderLayout.EAST);
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
        else if(arg0.getSource()==this.retour){
           //this.ecole.setVisibleDisplayEnseignant(false);
           //this.ecole.setVisibleMenu(true);
       }
       else if(arg0.getSource()==this.modifier){
           //this.ecole.setVisibleDisplayEnseignant(false);
           //this.ecole.setVisibleMenu(true);
           this.dispose();
           modifier();
       }
       
       
       for(int i=0; i<this.supprimer.size();i++){
           if(arg0.getSource()==this.supprimer.get(i)){
               this.dispose();
               
                //this.ecole.getEnseignant(i).setVisible(true);
                //this.ecole.setVisibleDisplayEnseignant(false);
           }
       }
      
        
    } 
    
   

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
                for(Enseignement enseignement : enseignant.getEnseignement()){
                  
               this.nomtext.setText(enseignant.getNom()+"   ");
               this.prenomtext.setText(enseignant.getPrenom()+"   ");
               this.discipline.setText(enseignement.getDiscipline().getNom()+"   ");
               //this.discipline.setText(enseignement.getDiscipline().getNom()+"   ");
                }
                   
        
    
       
 
         
        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 30)); 
        l1.setBounds(20,100, 130,30);      
        l2.setBounds(20,150, 130,30);
           
        l3.setBounds(20,200, 130,30);
          
        bouton.setBounds(100,290, 150,30); 
        retour.setBounds(350,290, 400,60);  
        nomtext.setBounds(140,100, 100,30); 
        prenomtext.setBounds(140,150, 100,30); 
        discipline.setBounds(140,200, 100,30); 
        error.setBounds(50,350,400,30);
        error.setForeground(Color.red);
        error.setFont(new Font("Serif", Font.BOLD, 25));
                f.add(l); 
                f.add(l1); 
                f.add(l2);
                f.add(nomtext);
               // f.add(l3);
                f.add(prenomtext);
                //f.add(discipline);
                f.add(retour);
                f.add(bouton);
                
                f.add(this.error);
               
                  
             
        

       
        
		f.setSize(830,730); 
                f.setBackground(Color.PINK);
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                f.setVisible(true);
        
    }
    
   
   
}
