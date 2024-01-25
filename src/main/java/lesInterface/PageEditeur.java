package lesInterface;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class PageEditeur extends JFrame {

	private JPanel contentPane;
	private JTextArea A1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField id_article;
	LogInEditeur frame = new LogInEditeur();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageEditeur frame = new PageEditeur();
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
	public PageEditeur() {
		int id_ed=frame.id_editeue;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("afficher les article non evalue");
		btnNewButton.setBackground(new Color(205, 238, 17));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArticleNonEvalue(id_ed)	;
			
			}
		});
		btnNewButton.setBounds(10, 69, 336, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("evalue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!A1.getText().isEmpty())
				{
					EvaluationArticle frame = new EvaluationArticle();
					frame.setVisible(true);
				}
				else
				{
					  JOptionPane.showMessageDialog(btnNewButton_1, "Ou est les article a evaluer!!!!");
				        
				}
				
			}
		});
		btnNewButton_1.setBounds(766, 71, 168, 40);
		contentPane.add(btnNewButton_1);
		
		A1 = new JTextArea();
		A1.setBounds(433, 159, 262, 135);
		contentPane.add(A1);
		
		btnNewButton_2 = new JButton("retoure");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInEditeur frame = new LogInEditeur();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 527, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("donner les article au cours d'evaluation");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(205, 238, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArticleAuCoursEvaluation(id_ed);
			}
		});
		btnNewButton_3.setBounds(10, 120, 336, 40);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("decision");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!A1.getText().isEmpty())
				{
					DecisionEditeur frame = new DecisionEditeur();
					frame.setVisible(true);
				}
				else
				{
					  JOptionPane.showMessageDialog(btnNewButton_1, "Ou est les article  !!!!");
				        
				}
				
			}
				
				
			
		});
		btnNewButton_4.setBounds(766, 151, 168, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("donner les article a revise ");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBackground(new Color(205, 238, 17));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				articleRevise(id_ed);
			}
		});
		btnNewButton_5.setBounds(10, 192, 336, 40);
		contentPane.add(btnNewButton_5);
		
		
		id_article = new JTextField();
		id_article.setBounds(460, 406, 229, 40);
		contentPane.add(id_article);
		id_article.setColumns(10);
		
		lblNewLabel = new JLabel("Donner l'article que vous veuillez revisie parmis la list ci dessus");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 407, 416, 34);
		contentPane.add(lblNewLabel);
		
		btnRevision = new JButton("Revision");
		btnRevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!id_article.getText().isEmpty())
				{
					revision(Integer.parseInt(id_article.getText()));
				}
				else {
					   JOptionPane.showMessageDialog(btnRevision, "donnez l'article que veuillez revise");
				        
				}
				
			}
		});
		btnRevision.setBounds(766, 406, 168, 40);
		contentPane.add(btnRevision);
		
		btnNewButton_7 = new JButton("dooner les article accepte");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArticleAccepte(id_ed);	
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_7.setBounds(10, 268, 336, 40);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("Publier");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!publier.getText().isEmpty())
				{
					publication(id_ed,Integer.parseInt(publier.getText()));
				}
				else {
					   JOptionPane.showMessageDialog(btnRevision, "donnez l'article que veuillez publier");
				        
				}
					
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_8.setBounds(766, 476, 168, 40);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel_1 = new JLabel("Donner l'article que vous veuillez publier");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 465, 416, 30);
		contentPane.add(lblNewLabel_1);
		
		publier = new JTextField();
		publier.setBounds(460, 478, 229, 40);
		contentPane.add(publier);
		publier.setColumns(10);
	}
	Connection con=ConnectionMySql .getConnection();
	
	private JLabel lblNewLabel;
	private JButton btnRevision;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JTextField publier;
	
	private void ArticleNonEvalue(Integer code)
	{A1.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select distinct soumission.id_article from soumission , article where soumission.id_article=article.id_article"
						+ " and soumission.id_editeur =? and article.evalue=?");
				
				statement.setInt(1, code);
				statement.setString(2, "false");
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idEditeur=resultat.getInt("id_article");
				    String S=String.valueOf(idEditeur)+" ";
				    A1.append(S);
				}
				resultat.close();
	            statement.close();
	           
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        }
	}
	
	private void ArticleAuCoursEvaluation(Integer code)
	{A1.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select distinct soumission.id_article from soumission , article where soumission.id_article=article.id_article"
						+ " and soumission.id_editeur =? and  article.evalue=?");
				
				statement.setInt(1, code);
				statement.setString(2, "Au cours d'evaluation");
				
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idEditeur=resultat.getInt("id_article");
				    String S=String.valueOf(idEditeur)+" ";
				    A1.append(S);
				}
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        }
	}
	
	public void articleRevise(Integer code)
	{
		A1.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select distinct soumission.id_article from soumission , article where soumission.id_article=article.id_article"
						+ " and soumission.id_editeur =? and article.evalue=? ");
				//or soumission.decision_editeur=?
				statement.setInt(1, code);
				statement.setString(2, "revise");
				
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idarticle=resultat.getInt("id_article");
				    String S=String.valueOf(idarticle)+" ";
				    A1.append(S);
				}
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
	}
	
	private void revision(Integer code)
	{
		 try {
	        	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
				PreparedStatement statement =  con.prepareStatement("update evaluation set 	dateRevision=? where id_article =?");
				
				String date=String.valueOf(LocalDate.now()); 
		           
				statement.setString(1, date);
				statement.setInt(2, code);
				int resultat = statement.executeUpdate();
				 if (resultat > 0) {
		                JOptionPane.showMessageDialog(this, "la date de revision est enregistre avec succès !");
		                
		            }
				
	            statement.close();
	            con.close();
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/*private void ArticleDejaEvalue(Integer code)
	{A1.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select distinct soumission.id_article from soumission , article ,evaluation where soumission.id_article=article.id_article"
						+ " and article.id_article=evaluation.id_article"
						+ " and soumission.id_editeur =? and  article.evalue=? and nbrRevision >1");
				
				statement.setInt(1, code);
				statement.setString(2, "revise");
				
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idEditeur=resultat.getInt("id_article");
				    String S=String.valueOf(idEditeur)+" ";
				    A1.append(S);
				}
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        }
	}*/
	
	private void ArticleAccepte(Integer code)
	{A1.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select distinct soumission.id_article from soumission , article ,evaluation where soumission.id_article=article.id_article"
						+ " and article.id_article=evaluation.id_article"
						+ " and soumission.id_editeur =? and  decision_editeur=? and evalue=?");
				
				statement.setInt(1, code);
				statement.setString(2, "acceptés");
				statement.setString(3,"evalue");
				
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idEditeur=resultat.getInt("id_article");
				    String S=String.valueOf(idEditeur)+" ";
				    A1.append(S);
				}
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        }
	}
	
	private void publication(Integer code,Integer id_article)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select id_revue from revue where id_editeur=?");
				
				statement.setInt(1, code);
			
				ResultSet resultat = statement.executeQuery();
				int revue = 0;
				while (resultat.next()) {
				    revue=resultat.getInt("id_revue");
				    
				}
				
				
				
				PreparedStatement statement1 =  con.prepareStatement("update article set id_revue=? where id_article =?");
				statement1.setInt(1, revue);
				statement1.setInt(2, id_article);
				int resultat1 =statement1.executeUpdate();
				if(resultat1>0)
				{
					  JOptionPane.showMessageDialog(this, "La publication est effectuer avec succee ");
				        
				}
				
				
				PreparedStatement statement2 =  con.prepareStatement("update article set evalue =? where id_article=?");
				statement2.setString(1, "publier");
				statement2.setInt(2, id_article);
				int resultat2 =statement2.executeUpdate();
				if(resultat2>0)
				{
					  JOptionPane.showMessageDialog(this, "La publication est effectuer avec succee ");
				        
				}
				
				
				statement1.close();
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        }
	}
}

