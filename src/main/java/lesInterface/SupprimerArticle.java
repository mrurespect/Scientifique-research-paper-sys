package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class SupprimerArticle extends JFrame {

	private JPanel contentPane;
	private JTextField T1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerArticle frame = new SupprimerArticle();
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
	public SupprimerArticle() {
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
		btnNewButton.setBounds(59, 493, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Donner le code de l'article que veuillez supprimer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(344, 62, 335, 30);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(689, 62, 197, 27);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerSoumission(Integer.parseInt(T1.getText()));
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(536, 151, 207, 41);
		contentPane.add(btnNewButton_1);
	}
	
	Connection con=ConnectionMySql .getConnection();
	private void supprimerSoumission(Integer code)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("DELETE FROM article  WHERE id_article not in (select id_article from soumission ) and  id_article=?");
				
				statement.setInt(1, code);
				
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "l'article est supprimer avec succès !");
	                
	            }
	            
	            PreparedStatement statement1 =  con.prepareStatement("select id_article from soumission where id_article=?");
				
				statement1.setInt(1, code);
				
				ResultSet resultat1 = statement1.executeQuery();
	            if (resultat1.next()) {
	                JOptionPane.showMessageDialog(this, "l'article ne peut plus etre supprime car il est deja soumet!");
	                
	            }
	            
	            statement1.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "Erreur " + ex.getMessage());
	        }
	}

}
