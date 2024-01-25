package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SuivreSoumission extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	JTextArea A1;
	private File contenue;
	DecisionEditeur frame1 = new DecisionEditeur();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuivreSoumission frame = new SuivreSoumission();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SuivreSoumission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Soumission frame = new Soumission();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(24, 523, 98, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Donnez le code de Soumission");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(293, 210, 208, 27);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(511, 210, 208, 27);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Decision de l'editeur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int soum_supp=frame1.soum_supp;
				if(!T1.getText().isEmpty())
				{
					
					if(Integer.parseInt(T1.getText())==soum_supp)
					{
						JOptionPane.showMessageDialog(btnNewButton_1 , "la soumission est supprimer ");
				        
					}
					else
					{
						recuperDecision(Integer.parseInt(T1.getText()));
					}
						
				
				}
				
				else
				{
					JOptionPane.showMessageDialog(btnNewButton_1 , "entre le code de soumission ");
			           
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(293, 263, 208, 43);
		contentPane.add(btnNewButton_1);
		
		 A1 = new JTextArea();
		A1.setBounds(511, 263, 208, 43);
		contentPane.add(A1);
		
		JFrame fenetre = new JFrame("Insertion de fichier");
		JButton btnNewButton_2 = new JButton("Modifier le Contenue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!T1.getText().isEmpty()&&!A1.getText().isEmpty())
				{
					
					if (maConditionEstRemplie()) {
						JFileChooser fileChooser = new JFileChooser();
		                int resultat = fileChooser.showOpenDialog(fenetre);
		                if (resultat == JFileChooser.APPROVE_OPTION) {
		                    contenue = fileChooser.getSelectedFile();
		                }
		                    FileInputStream Contenue = null;
		    				try {
		    					Contenue = new FileInputStream(contenue);
		    				} catch (FileNotFoundException e1) {
		    					// TODO Auto-generated catch block
		    					e1.printStackTrace();
		    					System.out.print("contenue");
		    				}
		    				
		    				ModifierLeContenue(Integer.parseInt(T1.getText()),Contenue);
					
				}
					else
					{
						if(A1.getText().equalsIgnoreCase("cette article est au cours d'evaluation"))
						{
							JOptionPane.showMessageDialog(btnNewButton_1 , A1.getText());
					        
						}
						
						else {
							JOptionPane.showMessageDialog(btnNewButton_1 , "l'article est "+A1.getText());
					         
						}
						  
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton_1 , "entrez tous les champ");
			        
				}
					
				
				
				
				/*if (maConditionEstRemplie()) {
					JFileChooser fileChooser = new JFileChooser();
	                int resultat = fileChooser.showOpenDialog(fenetre);
	                if (resultat == JFileChooser.APPROVE_OPTION) {
	                    contenue = fileChooser.getSelectedFile();
	                }
	                    FileInputStream Contenue = null;
	    				try {
	    					Contenue = new FileInputStream(contenue);
	    				} catch (FileNotFoundException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    					System.out.print("contenue");
	    				}
	    				
	    				ModifierLeContenue(Integer.parseInt(T1.getText()),Contenue);
				
			}
				else
				{
					if(A1.getText().equalsIgnoreCase("cette article est au cours d'evaluation"))
					{
						JOptionPane.showMessageDialog(btnNewButton_1 , A1.getText());
				        
					}
					
					else {
						JOptionPane.showMessageDialog(btnNewButton_1 , "l'article est "+A1.getText());
				         
					}
					  
				}*/
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(391, 374, 208, 43);
		contentPane.add(btnNewButton_2);
	}
	Connection con=ConnectionMySql .getConnection();
	private void recuperDecision(Integer code) {
		 A1.setText("");  
		
       try {
       	
			PreparedStatement statement =  con.prepareStatement("select decision_editeur from soumission where id_soum=?");
			
			statement.setInt(1, code);
			
			ResultSet resultat = statement.executeQuery();
			
			while (resultat.next()) {
			   String decision=resultat.getString("decision_editeur");
			   A1.setText(decision);
			  
			}
			resultat.close();
           statement.close();
           
       
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
       } 
		
   }
	
	private boolean maConditionEstRemplie() {
		if(A1.getText().equalsIgnoreCase("révision mineure")||
				A1.getText().equalsIgnoreCase("révision majeure"))
		{
			return true;
		}
		else 
			return false;
    }
	
	private void ModifierLeContenue(Integer id,InputStream contenue)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("update article join soumission on article.id_article=soumission.id_article set contenue = ?,evalue=? where id_soum =?");
				statement.setInt(3,id);
				statement.setString(2, "revise");
				statement.setBinaryStream(1, contenue);
			
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "le mise a jours de l'article est effectue avec succès !");
	                
	            }
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
	}
	
}
