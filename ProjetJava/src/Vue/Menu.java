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
import java.util.Random;
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
    private JButton quitter= new JButton("Quitter");
 
    private JLabel label = new JLabel("");
    private JPanel pan2= new JPanel();
    private JPanel pan= new JPanel();
    private JPanel pan3= new JPanel();

    private Ecole ecole;

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
         this.ecole.getClasse().setVisible(true);
         //this.ecole.getEnseignant().setVisible(false);
         //this.ecole.getEleve().setVisible(false);
          
        }
       else if(arg0.getSource()==this.quitter)
        {
            //action a faire quand on clique sur le bouton4
            System.exit(0);
        }
      
        
    } 
   
    
}
