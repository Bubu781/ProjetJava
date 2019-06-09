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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private JButton menu= new JButton("Menu");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();
    
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
        this.container.setLayout(new GridLayout(1,this.bulletin.getDetails().size()+2));
        for(DetailBulletin detail : this.bulletin.getDetails()){
            this.container.add(detail.getDisplay());
        }
        pan2.setPreferredSize(new Dimension(350,300));
        this.add(this.container, BorderLayout.CENTER);
        this.quitter.setSize(200,200);
         pan3.setLayout(new BorderLayout());

       pan3.setPreferredSize(new Dimension(250,50));
       

      
     
       pan3.setPreferredSize(new Dimension(250,50));
        

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
        else if(arg0.getSource()==this.menu){
           
          
       }
        else if(arg0.getSource()==this.retour){
           
          
       }
      
     }
}
