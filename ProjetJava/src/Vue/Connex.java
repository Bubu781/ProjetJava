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
import BDD.Connexion;
import Modele.Ecole;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mathilde
 */
public class Connex extends JFrame implements  ActionListener{
       private JTextField serveur_base;
	private JTextField nom_base;
        private JFrame f=new JFrame("LOGIN");
 private JButton bouton = new JButton("ENTRER");
 private JButton quitter= new JButton("Quitter");
	//...
public Connex(){
                 super();
            
		build();
}
private void build(){
               
		setTitle("CONNEXION"); 
		setSize(830,730); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel panel2 = new JPanel();
                final JLabel label2 = new JLabel();            
     label2.setBounds(20,250, 200,50);
       
      
     final JPasswordField value = new JPasswordField();   
     value.setBounds(140,250,100,30);  
     JLabel l=new JLabel("CONNECTEZ-VOUS A LA BDD:");    
        l.setBounds(10,20, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 40));
     JLabel l1=new JLabel("Serveur de la base:");    
        l1.setBounds(20,100, 130,30);    
        JLabel l2=new JLabel("Nom de la base:");    
        l2.setBounds(20,150, 130,30);
        JLabel l3=new JLabel("Login:");    
        l3.setBounds(20,200, 130,30);
        JLabel l4=new JLabel("Mot de passe:");    
        l4.setBounds(20,250, 130,30); 
          
        bouton.setBounds(100,290, 150,30); 
        quitter.setBounds(350,290, 400,30); 
        final JTextField text = new JTextField();  
        text.setBounds(140,100, 100,30); 
        final JTextField text2 = new JTextField();  
        text2.setBounds(140,150, 100,30); 
        final JTextField text3 = new JTextField();  
        text3.setBounds(140,200, 100,30); 
                f.add(l);
                f.add(value); 
                f.add(l1); 
                f.add(l2);
                f.add(text2);
                f.add(l3);
                f.add(text3);
                f.add(l4);
                f.add(bouton);
                f.add(quitter);
                f.add(text);
                
                 this.quitter.addActionListener(this);
                  this.bouton.addActionListener(this);
 
		f.setSize(830,730); 
                f.setBackground(Color.PINK);
                f.setLayout(null); 
                f.setLocationRelativeTo(null);
                f.setVisible(true);
	}

	
 
	public JTextField getServeurBase(){
		return serveur_base;
	}
 
	public JTextField getNomBase(){
		return nom_base;
	}

   
     @Override
     public void actionPerformed(ActionEvent arg0) {      
        if(arg0.getSource()==this.quitter)
        {
          System.exit(0);
            
        }
       else if(arg0.getSource()==this.bouton)
        {
            f.dispose();
            try {
                Ecole ecole = new Ecole(new Connexion("school","root",""));
            } catch (SQLException ex) {
                Logger.getLogger(Connex.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
    
}

