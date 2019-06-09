/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Modele.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Menu extends JFrame implements  ActionListener {
    
    
    private JButton eleves= new JButton("Eleves");
    private JButton enseignants= new JButton("Enseignants");
    private JButton classes= new JButton("Classes");
    private JButton ajout_discipline= new JButton("Ajout discipline");
    private JButton ajout_trimestre= new JButton("Ajout trimestre");
    private JButton ajout_niveau= new JButton("Ajout niveau");
    private JButton ajout_annee= new JButton("Ajout Annee");
    private JButton quitter= new JButton("Quitter");
    private JButton retour = new JButton(new ImageIcon("r2.png"));
    
    private JButton ajoutTrimestre= new JButton("Ajouter le trimestre");
    private JButton ajoutDiscipline= new JButton("Ajouter la discipline");
    private JButton ajoutAnnee= new JButton("Ajouter l'année");
    private JButton ajoutNiveau= new JButton("Ajouter le niveau");
 
    private JLabel label = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    
    private JLabel titreAjout = new JLabel("Ajouter un trimestre");
    
    private JTextField numeroTrimestre = new JTextField();
    private JTextField debutTrimestre = new JTextField();
    private JTextField finTrimestre = new JTextField();
    private JTextField nomDiscipline = new JTextField();
    private JTextField anneeAnnee = new JTextField();
    private JTextField nomNiveau = new JTextField();
    
    private JComboBox anneeTrimestre;
    private JFrame f;

    private Ecole ecole;

    /**
     * permet l'affichage graphique du menu avec quatre boutons : classe, eleve, enseignant et quitter et une image de fond
     * @param ecole 
     */
    public Menu(Ecole ecole)
    {
        this.ecole = ecole;
        setTitle("Menu");
        
         
         
         //frame.setVisible(true); 
         //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //ImageIcon icone = new ImageIcon(imgUrl);
     
     //JLabel jlabel = new JLabel(icone, JLabel.CENTER);
     //jlabel.setSize(new Dimension(800, 600));

     //this.getContentPane().add(jlabel);
        
        this.eleves.setSize(2,2);
        this.eleves.addActionListener(this);
        this.enseignants.addActionListener(this);
        this.classes.addActionListener(this);
        this.ajout_trimestre.addActionListener(this);
        this.ajout_niveau.addActionListener(this);
        this.ajout_discipline.addActionListener(this);
        this.ajout_annee.addActionListener(this);
        this.quitter.addActionListener(this);
        
       // this.pan.setSize(500,500);
       // final JLabel label = new JLabel("",JLabel.CENTER);
        this.label.setText(this.ecole.getNom());
        this.label.setBorder(BorderFactory.createLineBorder(Color.PINK));
        this.label.setFont(new Font("Serif", Font.BOLD, 50));
        this.label.setForeground(Color.GRAY);
        Dimension d = label.getPreferredSize();
        // javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
        //label.setBorder(border);
       // this.label.setPreferredSize(new Dimension(100, 70));
        this.pan.add("South",this.eleves);
        this.pan.add("South",this.enseignants);
        this.pan.add("South",this.classes);
        this.pan.add("South",this.ajout_discipline);
        this.pan.add("South",this.ajout_trimestre);
        this.pan.add("South",this.ajout_niveau);
        this.pan.add("South",this.ajout_annee);
        this.pan.add("South",this.quitter);
        this.pan2.add("Center",this.label);
        
        
        
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(830,820));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add("Center",pan2);
        this.getContentPane().add("South",pan);
        this.getContentPane().add("South",pan3);
         this.add(new JLabel(new ImageIcon("test2.jpg"))); 
          //this.add(new JLabel(new ImageIcon("image.png"))); 
         //this.pack();
         //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(830, 730);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    /**
     * cette fonction permet de realiser des actions lorqu'on clique sur les boutons 
     * @param arg0 
     */
     @Override
    public void actionPerformed(ActionEvent arg0) {      
        if(arg0.getSource()==this.eleves)
        {
            
            this.ecole.setVisibleMenu(false);
            //this.ecole.getEnseignant().setVisible(false);
            //this.ecole.getClasse().setVisible(false);
            //this.ecole.getEleve().setVisible(true);
            this.ecole.setVisibleDisplayEleves(true);
            
        }
       else if(arg0.getSource()==this.enseignants)
        {
           this.ecole.setVisibleMenu(false);
           this.ecole.setVisibleDisplayEnseignants(true);
           //this.ecole.getClasse().setVisible(false);
           //this.ecole.getEleve().setVisible(false);
           
        }
        else if(arg0.getSource()==this.classes)
        { 
         this.ecole.setVisibleMenu(false);
         this.ecole.setVisibleDisplayClasses(true);
         //this.ecole.getEnseignant().setVisible(false);
         //this.ecole.getEleve().setVisible(false);
          
        }
        else if(arg0.getSource()==this.ajout_trimestre)
        {
           this.ecole.setVisibleMenu(false);
           ajouterTrimestre();
           
        }
        else if(arg0.getSource()==this.ajout_discipline)
        {
           this.ecole.setVisibleMenu(false);
           ajouterDiscipline();
           
        }
        else if(arg0.getSource()==this.ajout_annee)
        {
           this.ecole.setVisibleMenu(false);
           ajouterAnnee();
           
        }
        else if(arg0.getSource()==this.ajout_niveau)
        {
           this.ecole.setVisibleMenu(false);
           ajouterNiveau();
           
        }else if(arg0.getSource()==this.retour){
            f.setVisible(false);
            this.setVisible(true);
        }else if(arg0.getSource()==this.ajoutTrimestre){
            f.setVisible(false);
            Object objAnnee = this.anneeTrimestre.getSelectedItem();
            AnneeScolaire annee = null;
            for(AnneeScolaire a : this.ecole.getAnnees()){
                if(String.valueOf(a.getAnnee()).equals(objAnnee.toString())){
                    annee = a;
                    break;
                }
            }
            try {
                this.ecole.ajoutTrimestre(Integer.parseInt(this.numeroTrimestre.getText()), annee, this.debutTrimestre.getText(), this.finTrimestre.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
        }else if(arg0.getSource()==this.ajoutDiscipline){
            f.setVisible(false);
            try {
                this.ecole.ajoutDiscipline(this.nomDiscipline.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
        }else if(arg0.getSource()==this.ajoutAnnee){
            f.setVisible(false);
            try {
                this.ecole.ajoutAnnee(this.anneeAnnee.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
        }else if(arg0.getSource()==this.ajoutNiveau){
            f.setVisible(false);
            try {
                this.ecole.ajoutNiveau(this.nomNiveau.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
        }else if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
      
        
    } 
    private void ajouterTrimestre() {
        f = new JFrame("Ajouter");
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JLabel lnumero = new JLabel("Numéro :");
        JLabel lannee = new JLabel("Année :");
        JLabel ldebut = new JLabel("Début :");
        JLabel lfin = new JLabel("Fin :");
        this.quitter.addActionListener(this);
        this.ajoutTrimestre.addActionListener(this);
        this.retour.addActionListener(this);
        pan3.setLayout(new BorderLayout()); 

        String[] nomAnnees = new String[this.ecole.getAnnees().size()];
        for(int i= 0; i< this.ecole.getAnnees().size(); i++){
            nomAnnees[i] = String.valueOf(this.ecole.getAnnees().get(i).getAnnee());
        }
        this.anneeTrimestre = new JComboBox(nomAnnees);
        
        titreAjout.setText("Ajouter un trimestre");
        titreAjout.setBounds(10,5, 700,100); 
        titreAjout.setFont(new Font("Serif", Font.BOLD, 30)); 
        lnumero.setBounds(20,100, 130,30);      
        lannee.setBounds(20,150, 130,30);
        ldebut.setBounds(20,200, 130,30);
        lfin.setBounds(20,250, 130,30);
        ajoutTrimestre.setBounds(100,300, 150,30); 
        retour.setBounds(350,300, 400,60);  
        numeroTrimestre.setBounds(140,100, 100,30); 
        anneeTrimestre.setBounds(140,150, 100,30); 
        debutTrimestre.setBounds(140,200, 100,30); 
        finTrimestre.setBounds(140,250, 100,30); 
        
        f.add(titreAjout); 
        f.add(lnumero); 
        f.add(lannee);
        f.add(ldebut);
        f.add(lfin);
        f.add(numeroTrimestre);
        f.add(anneeTrimestre);
        f.add(debutTrimestre);
        f.add(finTrimestre);
        f.add(retour);
        f.add(ajoutTrimestre);
        
        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    private void ajouterDiscipline() {
        f = new JFrame("Ajouter");
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JLabel lnom = new JLabel("Nom :");
        this.quitter.addActionListener(this);
        this.ajoutDiscipline.addActionListener(this);
        this.retour.addActionListener(this);
        pan3.setLayout(new BorderLayout()); 
        
        titreAjout.setText("Ajouter une discipline");
        titreAjout.setBounds(10,5, 700,100); 
        titreAjout.setFont(new Font("Serif", Font.BOLD, 30)); 
        lnom.setBounds(20,100, 130,30);      
        ajoutDiscipline.setBounds(100,300, 150,30); 
        retour.setBounds(350,300, 400,60);  
        nomDiscipline.setBounds(140,100, 100,30); 
        
        f.add(titreAjout); 
        f.add(lnom);
        f.add(nomDiscipline);
        f.add(retour);
        f.add(ajoutDiscipline);
        
        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void ajouterAnnee() {
        f = new JFrame("Ajouter");
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JLabel lannee = new JLabel("Année :");
        this.quitter.addActionListener(this);
        this.ajoutAnnee.addActionListener(this);
        this.retour.addActionListener(this);
        pan3.setLayout(new BorderLayout()); 
        
        titreAjout.setText("Ajouter une année");
        titreAjout.setBounds(10,5, 700,100); 
        titreAjout.setFont(new Font("Serif", Font.BOLD, 30)); 
        lannee.setBounds(20,100, 130,30);      
        ajoutAnnee.setBounds(100,300, 150,30); 
        retour.setBounds(350,300, 400,60);  
        anneeAnnee.setBounds(140,100, 100,30); 
        
        f.add(titreAjout); 
        f.add(lannee);
        f.add(anneeAnnee);
        f.add(retour);
        f.add(ajoutAnnee);
        
        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void ajouterNiveau() {
        f = new JFrame("Ajouter");
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JLabel lnom = new JLabel("Nom :");
        this.quitter.addActionListener(this);
        this.ajoutNiveau.addActionListener(this);
        this.retour.addActionListener(this);
        pan3.setLayout(new BorderLayout()); 
        
        titreAjout.setText("Ajouter une discipline");
        titreAjout.setBounds(10,5, 700,100); 
        titreAjout.setFont(new Font("Serif", Font.BOLD, 30)); 
        lnom.setBounds(20,100, 130,30);      
        ajoutNiveau.setBounds(100,300, 150,30); 
        retour.setBounds(350,300, 400,60);  
        nomNiveau.setBounds(140,100, 100,30); 
        
        f.add(titreAjout); 
        f.add(lnom);
        f.add(nomNiveau);
        f.add(retour);
        f.add(ajoutNiveau);
        
        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
