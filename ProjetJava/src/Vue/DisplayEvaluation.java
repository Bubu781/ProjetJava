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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adrienbuot
 */
public class DisplayEvaluation extends JPanel{
    Evaluation evaluation;
    JPanel cadreAppreciation = new JPanel();
    JPanel cadreNote = new JPanel();
    JPanel container = new JPanel();
    JLabel appreciation;
    JLabel note;
    
    public DisplayEvaluation(Evaluation evaluation){
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200,200));
        this.evaluation = evaluation;
        this.appreciation = new JLabel(this.evaluation.getAppreciation());
        this.note = new JLabel(String.valueOf(this.evaluation.getNote()));
        this.cadreAppreciation.add(this.appreciation);
        this.cadreNote.add(this.note);
        this.cadreAppreciation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.cadreNote.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.container.add(this.cadreAppreciation);
        this.container.add(this.cadreNote);
        this.add(this.container);
    }
}
