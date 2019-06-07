/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
public class DisplayBulletin extends JFrame{
    Bulletin bulletin;

    JPanel cadreTrimestre = new JPanel();
    JLabel trimestre;
    JPanel container = new JPanel();
    JPanel panel = new JPanel();
     private JPanel pan3= new JPanel();
    private JLabel titre = new JLabel("");
    private JButton quitter= new JButton("Quitter");
    private JButton retour= new JButton(new ImageIcon("r2.png")); 
    private JButton menu= new JButton("Menu");
    public DisplayBulletin(Bulletin bulletin){
        this.setTitle("Bulletin");
        this.titre.setText("Bulletin eleve");
        //pan.setLayout(new BorderLayout());
        //pan.setPreferredSize(new Dimension(450,300));
        this.add(this.titre,BorderLayout.NORTH);
        this.titre.setFont(new Font("Serif", Font.BOLD, 50)); 
        
        this.bulletin = bulletin;
        this.trimestre = new JLabel(this.bulletin.getTrimestre().getDebut() + " - " + this.bulletin.getTrimestre().getFin());
        this.cadreTrimestre.add(this.trimestre);
        this.cadreTrimestre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.container.setLayout(new GridLayout(1,this.bulletin.getDetails().size()));
        for(DetailBulletin detail : this.bulletin.getDetails()){
            this.container.add(detail.getDisplay());
        }
        panel.add(this.cadreTrimestre);
        panel.add(this.container);
        this.getContentPane().add("North",panel);
        this.quitter.setSize(200,200);
         pan3.setLayout(new BorderLayout());

       pan3.setPreferredSize(new Dimension(250,50));

    
        this.pan3.add(this.retour,BorderLayout.WEST);
        this.pan3.add(this.menu,BorderLayout.CENTER);
        this.pan3.add(this.quitter,BorderLayout.EAST);
        this.setLayout(new FlowLayout());
         this.setSize(new Dimension(830,730));
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
    }
}
