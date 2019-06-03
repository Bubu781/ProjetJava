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
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Vue.Menu;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mathilde
 */

public class Login {
    
 private JButton bouton = new JButton("ENTRER");
 private JButton quitter= new JButton("Quitter");
    public Login(){
    JFrame f=new JFrame("LOGIN");  
    
    JPanel panel = new JPanel();
     final JLabel label = new JLabel();            
     label.setBounds(20,250, 200,50);
     final JLabel label2 = new JLabel();            
     label2.setBounds(20,280, 200,50);  
      
     final JPasswordField value = new JPasswordField();   
     value.setBounds(140,190,100,30);   
     JLabel l1=new JLabel("Serveur de la base:");    
        l1.setBounds(20,20, 130,30);    
        JLabel l2=new JLabel("Nom de la base:");    
        l2.setBounds(20,75, 130,30);
        JLabel l3=new JLabel("Login:");    
        l3.setBounds(20,135, 130,30);
        JLabel l4=new JLabel("Mot de passe:");    
        l4.setBounds(20,190, 130,30); 
          
        bouton.setBounds(100,230, 150,30);    
        final JTextField text = new JTextField();  
        text.setBounds(140,20, 100,30); 
        final JTextField text2 = new JTextField();  
        text2.setBounds(140,75, 100,30); 
        final JTextField text3 = new JTextField();  
        text3.setBounds(140,135, 100,30); 
        
                f.add(value); f.add(l1); f.add(l2);f.add(text2);f.add(l3);f.add(text3);f.add(l4);f.add(bouton);f.add(text);  
                f.setSize(830,730); 
                f.setBackground(Color.PINK);
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                f.setBackground(Color.PINK);
                //this.quitter.addActionListener(this);
                //this.bouton.addActionListener(this);
                f.setVisible(true);   
                
                
               
                
                  
   
               
}  


    

}