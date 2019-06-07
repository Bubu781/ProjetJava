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
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.layout.Border;
import javax.swing.*;


/**
 *
 * @author Mathilde
 */
public class DisplayClasses extends JFrame implements  ActionListener{
     // private JButton eleves= new JButton("Eleves");
    //private JButton enseignants= new JButton("Enseignants");
   // private JButton classes= new JButton("Classes");
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton menu= new JButton("Menu");
    private ArrayList<JButton> rechercher= new ArrayList <JButton>();
    private ArrayList<JButton> supprimer= new ArrayList <JButton>();
   private JButton ajouter= new JButton(new ImageIcon("ajouter.png"));
    private ArrayList<JPanel> classes = new ArrayList<JPanel>();
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
    
    
    private JLabel l=new JLabel("AJOUT D'UNE CLASSE:");
        private JLabel l1=new JLabel("Classe :");  
        private JLabel l2=new JLabel("Niveau :"); 
        private JLabel l3=new JLabel("Annee:");
        private JLabel error = new JLabel("");
        private JTextField nomclasse= new JTextField();
        private JTextField niveau= new JTextField();
        private JTextField annee = new JTextField(); 
        
     
        private JFrame f=new JFrame("LOGIN");
        private JButton bouton = new JButton("ENTRER");
    public DisplayClasses(Ecole ecole){
        this.ecole = ecole;
    
     

        setTitle("Classes");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        this.ajouter.addActionListener(this);
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.titre.setText("Fiche classes");
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
         pan.setPreferredSize(new Dimension(450,300));
       this.pan.add(this.titre,BorderLayout.NORTH);
         
        this.container.setLayout(new GridLayout(this.ecole.getClasses().size()+2,5));
         this.container.add(new JLabel("Classes"));
          this.container.add(new JLabel("Niveau"));
          this.container.add(new JLabel("Annee"));
          this.container.add(new JLabel(""));
          this.container.add(new JLabel(""));
       
        for(Classe classe : this.ecole.getClasses()){
            JLabel nom= new JLabel(classe.getNom());
            JLabel niveau= new JLabel(classe.getNiveau().getNom());
            JLabel annee= new JLabel(String.valueOf(classe.getAnneeScolaire().getAnnee()));
            this.rechercher.add(new JButton(new ImageIcon("loupe.png")));
            this.rechercher.get(this.rechercher.size()-1).addActionListener(this);
            this.supprimer.add(new JButton(new ImageIcon("supprimer.png")));
            this.supprimer.get(this.supprimer.size()-1).addActionListener(this);
            this.container.add(nom);
            this.container.add(niveau);
            this.container.add(annee);
            this.container.add(this.rechercher.get(this.rechercher.size()-1));
            this.container.add(this.supprimer.get(this.supprimer.size()-1));
            
        }
        this.container.add(new JLabel(""));
        this.container.add(new JLabel(""));
        this.container.add(this.ajouter);
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
      
       pan2.setPreferredSize(new Dimension(350,300));
       pan3.setPreferredSize(new Dimension(250,50));
        
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
    
     private void ajouter()
    {
        setTitle("AJOUTER"); 
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
               
                   
        
    
       
 
         
        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 30)); 
        l1.setBounds(20,100, 130,30);      
        l2.setBounds(20,150, 130,30);
           
        l3.setBounds(20,200, 130,30);
          
        bouton.setBounds(100,350, 150,30); 
        retour.setBounds(350,350, 400,60);  
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
        
    
    }
     @Override
    public void actionPerformed(ActionEvent arg0) {      
       if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
       
       else if(arg0.getSource()==this.menu)
        {
            //action a faire quand on clique sur le bouton4
            //System.exit(0);
        }
       else if(arg0.getSource()==this.ajouter)
        {
            //action a faire quand on clique sur le bouton4
            //System.exit(0);
            this.dispose();
            ajouter();
        }
       else if(arg0.getSource()==this.retour){
           this.ecole.setVisibleDisplayClasses(false);
           this.ecole.setVisibleMenu(true);
       }
       for(int i=0; i<this.rechercher.size();i++){
           if(arg0.getSource()==this.rechercher.get(i)){
                this.ecole.getClasse(i).setVisible(true);
                this.ecole.setVisibleDisplayClasses(false);
           }
       }
      
        
    } 
   
}
