/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import static java.awt.Color.BLUE;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adrienbuot
 */


public class DisplayBulletin extends JFrame implements ActionListener{
   
    /**
     * attributs de la classe : boutons, Jpanel
     */
    Bulletin bulletin;

    JPanel cadreTrimestre = new JPanel();
    JLabel trimestre;
    JPanel container = new JPanel();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    private JLabel titre = new JLabel("");
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton ajoutBulletin= new JButton("Ajouter une evaluation");
    private JButton menu= new JButton("Menu");
    private JButton ajoutEvaluation = new JButton("Ajouter");
    
    private JLabel titreAjout = new JLabel("Ajouter une appréciation");
    private JLabel lenseignement = new JLabel("Enseignement : ");
    private JLabel lnote = new JLabel("Note : ");
    private JLabel lappreciation = new JLabel("Appreciation :");
    
    private JComboBox enseignement;
    private JTextField note = new JTextField();
    private JTextField appreciation = new JTextField();
    
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    
    private JFrame f = new JFrame("AJOUTER");
    
    /**
     * affichage d'un bulletin et toutes les informations qui vont avec : note, appreciation, trimestre
     * @param bulletin 
     */
    public DisplayBulletin(Bulletin bulletin){
        this.setTitle("Bulletin");
        this.titre.setText("Bulletin eleve");

        this.quitter.addActionListener(this);
        this.retour.addActionListener(this);
        this.menu.addActionListener(this);
        this.ajoutBulletin.addActionListener(this);

        this.titre.setFont(new Font("Serif", Font.BOLD, 50));
        pan.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        pan3.setLayout(new BorderLayout());
        pan.setPreferredSize(new Dimension(450,300));
        this.pan.add(this.titre,BorderLayout.NORTH);
        this.titre.setForeground(Color.blue);

        this.add(this.titre,BorderLayout.NORTH);
        this.titre.setFont(new Font("Serif", Font.BOLD, 50));
        this.quitter.setSize(200,200);
        this.bulletin = bulletin;
        this.trimestre = new JLabel("Trimestre du "+this.bulletin.getTrimestre().getDebut() + " au " + this.bulletin.getTrimestre().getFin());
        this.trimestre.setFont(new Font("Serif", Font.BOLD, 20)); 
        this.add(this.cadreTrimestre);
        this.cadreTrimestre.add(this.trimestre);
        this.cadreTrimestre.setBounds(140,350, 300,30);
        this.cadreTrimestre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.container.setSize(200, 330);
        this.container.setLayout(new GridLayout(1,this.bulletin.getDetails().size()+2));
        for(DetailBulletin detail : this.bulletin.getDetails()){
            this.container.add(detail.getDisplay());
        }
        pan2.setPreferredSize(new Dimension(350,300));
        this.add(this.container, BorderLayout.CENTER);
        this.quitter.setSize(200,200);
         pan3.setLayout(new BorderLayout());

       pan3.setPreferredSize(new Dimension(250,80));
   
        

        this.pan3.add(this.retour,BorderLayout.WEST);
        this.pan3.add(this.menu,BorderLayout.CENTER);
        this.pan3.add(this.quitter,BorderLayout.EAST);
        this.pan3.add(this.ajoutBulletin, BorderLayout.NORTH);
        
        
        
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add("North",pan);
        this.getContentPane().add("Weast",pan2);
        this.getContentPane().add("South",pan3);
        //pan.setLayout(new BorderLayout());
        //pan.setPreferredSize(new Dimension(450,300));
       
         
        
        
        
       
    
        this.pan3.add(this.retour,BorderLayout.WEST);
        this.pan3.add(this.menu,BorderLayout.CENTER);
        this.pan3.add(this.quitter,BorderLayout.EAST);
        this.quitter.addActionListener(this);
        
        this.getContentPane().add("Center",panel);
        this.getContentPane().add("South",panel2);
        this.getContentPane().add("East",panel2);
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
    }
    
      public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==this.quitter)
        {
          System.exit(0);
            
        }
        
        else if(arg0.getSource()==this.ajoutBulletin){
            this.setVisible(false);
            this.ajouter();
        }
        else if(arg0.getSource()==this.menu){
           
         this.bulletin.setVisible(false);
         this.bulletin.getEcole().setVisibleMenu(true);
         
       }
        else if(arg0.getSource()==this.retour){
          this.bulletin.setVisible(false);
          this.bulletin.getInscription().getEleve().setVisible(true);
       }else if(arg0.getSource()==this.ajoutEvaluation){
           f.setVisible(false);
           Object objEnseignement = this.enseignement.getSelectedItem();
           DetailBulletin detail = null;
           for(DetailBulletin d : this.bulletin.getDetails()){
               if(objEnseignement.toString().equals(d.getEnseignement().getDiscipline().getNom() + " - " + d.getEnseignement().getEnseignant().getNom())){
                   detail = d;
                   break;
               }
           }
            try {
                this.bulletin.ajouterEvaluation(detail.getEnseignement(), Integer.parseInt(this.note.getText()), this.appreciation.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DisplayBulletin.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      
     }
      private void ajouter() {
        setTitle("AJOUT"); 
        setSize(830,730); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.quitter.addActionListener(this);
        this.ajoutEvaluation.addActionListener(this);
        this.retour.addActionListener(this);
        pan3.setLayout(new BorderLayout()); 

        String[] nomEnseignements = new String[this.bulletin.getDetails().size()];
        for(int i= 0; i< this.bulletin.getDetails().size(); i++){
            nomEnseignements[i] = this.bulletin.getDetails().get(i).getEnseignement().getDiscipline().getNom() + " - " + this.bulletin.getDetails().get(i).getEnseignement().getEnseignant().getNom();
        }
        this.enseignement = new JComboBox(nomEnseignements);

        titreAjout.setBounds(10,5, 700,100); 
        titreAjout.setFont(new Font("Serif", Font.BOLD, 30)); 
        lenseignement.setBounds(20,100, 130,30);      
        lnote.setBounds(20,150, 130,30);
        lappreciation.setBounds(20,200, 130,30);
        ajoutEvaluation.setBounds(100,290, 150,30); 
        retour.setBounds(350,290, 400,60);  
        enseignement.setBounds(140,100, 100,30); 
        note.setBounds(140,150, 100,30); 
        appreciation.setBounds(140,200, 100,30); 
        
        f.add(titreAjout); 
        f.add(lenseignement); 
        f.add(lnote);
        f.add(lappreciation);
        f.add(enseignement);
        f.add(note);
        f.add(appreciation);
        f.add(retour);
        f.add(ajoutEvaluation);
        
        f.setSize(830,730); 
        f.setBackground(Color.PINK);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
