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
    
    
    public DisplayClasses(Ecole ecole){
        this.ecole = ecole;
    
     

        setTitle("Classes");
        //this.eleves.setSize(2,2);
        //this.eleves.addActionListener(this);
        //this.enseignants.addActionListener(this);
        //this.classes.addActionListener(this);
        this.quitter.addActionListener(this);
        
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.titre.setText("Fiche classes");
        
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
         
        this.container.setLayout(new GridLayout(this.ecole.getClasses().size()+1,2));
         this.container.add(new JLabel("Nom des classes"));
          
          this.container.add(new JLabel(""));
          
        for(Classe Classe : this.ecole.getClasses()){
            JLabel nom= new JLabel(Classe.getNom());
            this.rechercher.add(new JButton(new ImageIcon("loupe.png")));
            this.rechercher.get(this.rechercher.size()-1).addActionListener(this);
            this.container.add(nom);
            this.container.add(this.rechercher.get(this.rechercher.size()-1));
            
        }
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
