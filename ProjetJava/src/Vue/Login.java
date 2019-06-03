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

/**
 *
 * @author Mathilde
 */

public class Login {
    public Login(){
    JFrame f=new JFrame("LOGIN");    
     final JLabel label = new JLabel();            
     label.setBounds(20,150, 200,50);  
     final JPasswordField value = new JPasswordField();   
     value.setBounds(100,75,100,30);   
     JLabel l1=new JLabel("Login:");    
        l1.setBounds(20,20, 80,30);    
        JLabel l2=new JLabel("Mot de passe:");    
        l2.setBounds(20,75, 80,30);    
        JButton b = new JButton("S'identifier");  
        b.setBounds(100,120, 150,30);    
        final JTextField text = new JTextField();  
        text.setBounds(100,20, 100,30);    
                f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);  
                f.setSize(830,730);    
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                //f.setBackground(Color.PINK);
                f.setVisible(true);     
                b.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    f.dispose();
                //Menu menu=new Menu();       
                }  
             });   
}  
    

}