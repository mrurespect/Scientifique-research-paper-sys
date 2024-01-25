package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PageEvaluateur2 extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	
	
	 //private JButton downloadButton;
	LoginEvaluateur frame = new LoginEvaluateur();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageEvaluateur2 frame = new PageEvaluateur2();
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
	public PageEvaluateur2() {
		int eval=frame.id_evaluateur;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("le code de l'article");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(133, 129, 155, 28);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(328, 129, 313, 28);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("avis sur l'article");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(133, 235, 140, 28);
		contentPane.add(lblNewLabel_1);
		
		T2 = new JTextField();
		T2.setBounds(328, 235, 313, 31);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("remarque");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(133, 341, 89, 31);
		contentPane.add(lblNewLabel_2);
		
		JTextArea T3 = new JTextArea();
		T3.setBounds(328, 317, 313, 73);
		contentPane.add(T3);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageEvaluateur1 frame = new PageEvaluateur1();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 508, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("envoye");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!T1.getText().isEmpty()&&!T2.getText().isEmpty()&&!T3.getText().isEmpty())
				{
					enregistrerDonnees(Integer.parseInt(T1.getText()),eval,T2.getText(), T3.getText());
					
				}
				else
				{
					  JOptionPane.showMessageDialog(btnNewButton_1, "Entrez tous les champ !");
		              
				}
				       
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(811, 498, 120, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Telecharger");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnNewButton_2) {
		            // Ouvrez une boîte de dialogue pour sélectionner l'emplacement de téléchargement
		            JFileChooser fileChooser = new JFileChooser();
		            int userChoice = fileChooser.showSaveDialog(btnNewButton_2);

		            if (userChoice == JFileChooser.APPROVE_OPTION) {
		                // Obtenez le fichier sélectionné par l'utilisateur
		                java.io.File file = fileChooser.getSelectedFile();

		                // Téléchargez le fichier depuis la base de données
		                downloadData(Integer.parseInt(T1.getText()),file) ;  
		            }
		        }
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(790, 131, 120, 28);
		contentPane.add(btnNewButton_2);

	
	

	}
	    
	    
	Connection con=ConnectionMySql .getConnection();
	 private void enregistrerDonnees(Integer code,Integer codeEval,String avis, String remarque) {
		 int nbrRevision = 0;
	        
	        try {
	        	
	        	
				PreparedStatement statement1 = con.prepareStatement("select  nbrRevision from evaluation where id_article =?");
	            
				statement1.setInt(1, code);
				ResultSet rs=statement1.executeQuery();
				
				PreparedStatement statement2 = con.prepareStatement("update evaluation set avis=? ,remarque=? , nbrRevision=? where id_article =? and 	id_evaluateur =? ");
	            
				while(rs.next())
				{
					 nbrRevision=rs.getInt("nbrRevision");
					statement2.setInt(3, ++nbrRevision);	
				}
	        	
	            //Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
	            statement2.setInt(4, code);
	            statement2.setInt(5, codeEval);
	            statement2.setString(1, avis);
	            statement2.setString(2,remarque);
	            
	            int resultat = statement2.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "Données enregistrées avec succès !");
	                
	            }
	         
	            statement1.close();
	            statement2.close();
	            
	            
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données : " + ex.getMessage());
	        } 
	    }
	 
	 private void downloadData(Integer code,File file) {
		 FileOutputStream outputStream = null;
	        try {
	            
	        	PreparedStatement statement = con.prepareStatement("select  contenue from article where id_article =?");
	            
				statement.setInt(1, code);
				ResultSet rs=statement.executeQuery();
				
	        	
	        	
	        	
	            // Vérifiez si le résultat contient des données
	            if (rs.next()) {
	                // Récupérez le Blob à partir du résultat
	                Blob blob = rs.getBlob("contenue");

	                // Obtenez l'entrée de flux du Blob
	                InputStream inputStream = blob.getBinaryStream();

	                outputStream = new FileOutputStream(file);

	                // Lisez les données du flux d'entrée et écrivez-les dans le flux de sortie
	                byte[] buffer = new byte[1024];
	                int length;
	                while ((length = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, length);
	                }

	                // Fermez les flux
	                inputStream.close();
	                outputStream.close();

	                // Affichez un message de succès
	                JOptionPane.showMessageDialog(this, "Téléchargement terminé !");
	            } else {
	                // Affichez un message si aucune donnée n'est trouvée
	                JOptionPane.showMessageDialog(this, "Aucune donnée trouvée.");
	            }
	         
	        }catch (SQLException  e1) {
	            e1.printStackTrace();
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        } 
	    
}
	 
}

