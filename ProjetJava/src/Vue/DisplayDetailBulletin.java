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
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adrienbuot
 */
public class DisplayDetailBulletin extends JPanel{
    DetailBulletin detail;
    JPanel cadreEnseignement = new JPanel();
    JLabel enseignement;
    JLabel appreciation;
    JPanel container = new JPanel();
    JPanel panel = new JPanel();
    
    public DisplayDetailBulletin(DetailBulletin detail){
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300,300));
        this.detail = detail;
        this.enseignement = new JLabel(detail.getEnseignement().getDiscipline().getNom()+" - "+ detail.getEnseignement().getEnseignant().getNom());
        this.appreciation = new JLabel(detail.getAppreciation());
        this.cadreEnseignement.add(this.enseignement);
        this.cadreEnseignement.add(this.appreciation);
        this.cadreEnseignement.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.container.setLayout(new GridLayout(1,this.detail.getEvaluations().size()));
        for(Evaluation evaluation : this.detail.getEvaluations()){
            this.container.add(evaluation.getDisplay());
        }
        this.panel.add(this.cadreEnseignement);
        this.panel.add(this.container);
        this.add(panel);
        this.container.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    }
}
