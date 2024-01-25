package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;

public class ModifierSoumission extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;
	private File contenue;
	FileInputStream Contenue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierSoumission frame = new ModifierSoumission();
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
	public ModifierSoumission() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(33, 521, 114, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Donner le code de soumission  que vous voullez modifier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(126, 59, 386, 29);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(543, 59, 222, 26);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier le contenue");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 129, 275, 37);
		contentPane.add(lblNewLabel_1);
		
		JFrame fenetre = new JFrame("Insertion de fichier");
		
		JButton btnNewButton_1 = new JButton("Selectionner Contenue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					JFileChooser fileChooser = new JFileChooser();
	                int resultat = fileChooser.showOpenDialog(fenetre);
	                if (resultat == JFileChooser.APPROVE_OPTION) {
	                    contenue = fileChooser.getSelectedFile();
	                    T2.setText(contenue.getName());
	                }
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(btnNewButton_1, "selectionner  le contenue"+ e2.getMessage());
				    
				}
				
			}   
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(10, 199, 275, 29);
		contentPane.add(btnNewButton_1);
		
		T2 = new JTextField();
		T2.setBounds(10, 239, 275, 34);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Donnez la taille de nouveau article ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 284, 275, 26);
		contentPane.add(lblNewLabel_2);
		
		T3 = new JTextField();
		T3.setBounds(10, 321, 275, 36);
		contentPane.add(T3);
		T3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Modifier Contenue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Contenue = new FileInputStream(contenue);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton_2, "selectionner  le contenue"+ e1.getMessage());
				     
				} catch (IOException e2) {
				    // Gérer l'erreur si une erreur de lecture ou d'écriture se produit
					JOptionPane.showMessageDialog(btnNewButton_2, "selectionner  le contenue"+ e2.getMessage());
				     
				} catch (Exception e3) {
				    // Gérer les autres erreurs inattendues
					JOptionPane.showMessageDialog(btnNewButton_2, "selectionner  le contenue"+ e3.getMessage());
				     
				}
				
				
				if(!T1.getText().isEmpty()&&!T2.getText().isEmpty()&&!T3.getText().isEmpty())
				{
					modifierSoumission(Integer.parseInt(T1.getText()),Contenue,Integer.parseInt(T3.getText()));
					
				}
				
				else 
				{
					JOptionPane.showMessageDialog(btnNewButton_2, " donnez les information necessaire pour modifier le contenue");
				       
				}
		
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(10, 433, 275, 57);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Modifier la list des auteur");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(577, 129, 320, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Donnez la nouvelle liste des auteurs");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(577, 199, 305, 23);
		contentPane.add(lblNewLabel_4);
		
		JTextArea A1 = new JTextArea();
		A1.setBounds(577, 258, 305, 99);
		contentPane.add(A1);
		
		JButton btnNewButton_3 = new JButton("Modifier list des auteur");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!T1.getText().isEmpty()&&!A1.getText().isEmpty())
				{
					modifierAuteur(Integer.parseInt(T1.getText()),A1.getText())	;
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton_3, " donnez la list des auteur");
			           
				}
			}
		});
		btnNewButton_3.setBackground(new Color(0, 255, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(577, 435, 283, 57);
		contentPane.add(btnNewButton_3);
	}
	Connection con=ConnectionMySql .getConnection();
	private void modifierSoumission(Integer code,InputStream contenue,Integer taille)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("UPDATE article JOIN soumission ON article.id_article=soumission.id_article SET article.contenue = ?, article.taille = ?  WHERE soumission.id_soum = ?");
				statement.setBinaryStream(1, contenue);
				statement.setInt(2, taille);
				statement.setInt(3, code);
				
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "la soumission est modifier avec succès !");
	                
	            }
	            statement.close();
	           
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
		 
		 
	}
	
	private void modifierAuteur(Integer code,String listAuteur)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("UPDATE article JOIN soumission ON article.id_article=soumission.id_article SET article.listAuteur = ? WHERE soumission.id_soum = ?");
				
				statement.setString(1, listAuteur);
				statement.setInt(2, code);
				
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "la soumission est modifier avec succès !");
	                
	            }
	            statement.close();
	           
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
		 
		 
	}
	
	
	
}
