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
        
         this.enseignant = enseignant;
         JLabel titre = new JLabel("Nom "+this.enseignant.getNom() + ", Prenom : "+this.enseignant.getPrenom());
         
        this.add(titre);
        
         this.container.setLayout(new GridLayout(this.enseignant.getEnseignement().size()+1,4));
         this.container.add(new JLabel("Nom Classe"));
         this.container.add(new JLabel("Niveau "));
         this.container.add(new JLabel("Discipline "));
         this.container.add(new JLabel(""));
          
        for(Enseignement enseignement : enseignant.getEnseignement()){
            JLabel nom_classe= new JLabel(enseignement.getClasse().getNom()+"   ");
            JLabel niveau= new JLabel( enseignement.getClasse().getNiveau().getNom()+"   ");
            JLabel discipline= new JLabel( enseignement.getDiscipline().getNom()+"   ");
            this.supprimer.add(new JButton(new ImageIcon("loupe.jpg")));
            this.supprimer.get(this.supprimer.size()-1).addActionListener(this);
            this.container.add(nom_classe);
            this.container.add(niveau);
            this.container.add(discipline);
            this.container.add(this.supprimer.get(this.supprimer.size()-1));
            
        }
        this.add(this.container);
         
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
