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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mathilde
 */
public class Connex extends JFrame implements  ActionListener{
       private JTextField serveur_base;
	private JTextField nom_base;
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
		setContentPane(buildContentPane());
                this.setVisible(true);
	}

	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.PINK);
                
                JLabel label = new JLabel("Veuillez saisir le serveur de la base :");
                panel.add(label);
 
		serveur_base = new JTextField(20);
                this.serveur_base.setHorizontalAlignment (JTextField.CENTER);
		serveur_base.setPreferredSize(new Dimension(30,60));
               
		panel.add(serveur_base);
                
                JLabel label2 = new JLabel("Veuillez saisir le nom de la base :");
                panel.add(label2);
 
		nom_base = new JTextField(20);
                this.nom_base.setHorizontalAlignment (JTextField.CENTER);
 
		panel.add(nom_base);
               
		panel.add(bouton);
                panel.add("South",this.quitter);
                
                 this.quitter.addActionListener(this);
                  this.bouton.addActionListener(this);
 
		
 
		return panel;
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
           this.dispose();
            Login log=new Login();
        }
     }
    
}

