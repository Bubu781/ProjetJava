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
import static java.awt.Color.RED;
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
       private JTextField serveur_base= new JTextField();
	private JTextField nom_base = new JTextField();
        private JFrame f=new JFrame("LOGIN");
        private JButton bouton = new JButton("ENTRER");
        private JButton quitter= new JButton("QUITTER");
        private JLabel l=new JLabel("CONNECTEZ-VOUS A LA BDD:");
        private JLabel l1=new JLabel("Serveur de la base:");  
        private JLabel l2=new JLabel("Nom de la base:"); 
        private JLabel l3=new JLabel("Login:"); 
        private JLabel error = new JLabel("");
        private JTextField login = new JTextField(); 
        private JPasswordField password = new JPasswordField(); 

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
                this.nom_base.setText("school");
                this.login.setText("root");
      
       
     password.setBounds(140,250,100,30);  
         
        l.setBounds(10,5, 700,100); 
        l.setFont(new Font("Serif", Font.BOLD, 40)); 
        l1.setBounds(20,100, 130,30);      
        l2.setBounds(20,150, 130,30);
           
        l3.setBounds(20,200, 130,30);
        JLabel l4=new JLabel("Mot de passe:");    
        l4.setBounds(20,250, 130,30); 
          
        bouton.setBounds(20,320, 150,35); 
        quitter.setBounds(190,320, 150,35);  
        serveur_base.setBounds(140,100, 100,30); 
        nom_base.setBounds(140,150, 100,30); 
        login.setBounds(140,200, 100,30); 
        error.setBounds(50,350,400,30);
        error.setForeground(Color.red);
        error.setFont(new Font("Serif", Font.BOLD, 25));
        
                f.add(l);
                f.add(password); 
                f.add(l1); 
                f.add(l2);
                f.add(nom_base);
                f.add(l3);
                f.add(login);
                f.add(l4);
                f.add(bouton);
                f.add(quitter);
                f.add(serveur_base);
                f.add(this.error);
                
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
       else if(arg0.getSource()==this.bouton && !nom_base.getText().equals("")&& !login.getText().equals(""))
        { 
            try {
                f.dispose();
                Ecole ecole = new Ecole(new Connexion(nom_base.getText(),login.getText(),password.getText()));
                
            } catch (SQLException ex) {
                this.error.setText("Impossible de ce connecter à la BDD");
            } catch (ClassNotFoundException ex) {
                this.error.setText("Impossible de ce connecter à la BDD");
            }
            
        }
        
       else if(arg0.getSource()==this.bouton && nom_base.getText().equals("")&& login.getText().equals("")){
            this.error.setText("Veuillez remplir les données ");
       }
     }
    
}

