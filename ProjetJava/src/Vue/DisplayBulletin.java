/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
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
    JButton menu = new JButton("Menu");
    JButton retour = new JButton("<-");
    JPanel cadreTrimestre = new JPanel();
    JLabel trimestre;
    JPanel container = new JPanel();
    JPanel panel = new JPanel();
    public DisplayBulletin(Bulletin bulletin){
        this.setTitle("Bulletin");
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
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(830,730));
        this.setVisible(true);
    }
}
