package lesInterface;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class EvaluationArticle extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextArea TailleArticle;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	LogInEditeur frame = new LogInEditeur();
	
	
	/**
	 * Launch the application.
	 */
	static int id_article;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluationArticle frame = new EvaluationArticle();
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
	public EvaluationArticle() {
		
		int editeur=frame.id_editeue;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageEditeur frame = new PageEditeur();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 498, 117, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("donner l'id de l'article");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(217, 36, 204, 34);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(474, 36, 204, 34);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("la taille de l'article");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!T1.getText().isEmpty())
				{
					TailleArticle(Integer.parseInt(T1.getText()));
					
				}
				else
				{
					   JOptionPane.showMessageDialog(btnNewButton_1, " Dennez le code d'article" );
				}
				
			}
		});
		btnNewButton_1.setBounds(225, 139, 196, 34);
		contentPane.add(btnNewButton_1);
		
		 TailleArticle = new JTextArea();
		TailleArticle.setBounds(474, 137, 204, 34);
		contentPane.add(TailleArticle);
		
		btnNewButton_2 = new JButton("choisi 3 evaluateur");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(testTaill(Integer.parseInt(T1.getText())))
				{
					TroisEvaluateur frame = new TroisEvaluateur();
					frame.setVisible(true);
					id_article=Integer.parseInt(T1.getText());
				}
				else
				{
				    JOptionPane.showMessageDialog(btnNewButton_2, " la taille de l'article est superieur a 4000 donc doit etre evaluer par quatre evaluteur");
			        
				}
				
			}
		});
		btnNewButton_2.setBounds(225, 246, 204, 53);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("choisi 4 evaluateur");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(0, 255, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!testTaill(Integer.parseInt(T1.getText())))
				{
					QuatreEvaluateur frame = new QuatreEvaluateur();
					frame.setVisible(true);
					id_article=Integer.parseInt(T1.getText());
				}else
				{
				    JOptionPane.showMessageDialog(btnNewButton_3, " la taille de l'article est inferieur a 4000 donc doit etre evaluer par trois evaluteur");
			        
				}
				
			}
		});
		btnNewButton_3.setBounds(474, 246, 204, 53);
		contentPane.add(btnNewButton_3);
	}
	Connection con=ConnectionMySql .getConnection();
	private void TailleArticle(Integer code)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select taille from article where id_article =?");
				
				statement.setInt(1, code);
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int taille=resultat.getInt("taille");
				    String S=String.valueOf(taille)+" ";
				    TailleArticle.append(S);
				}
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
	}
	
	private boolean testTaill(Integer code)
	{boolean rep = false;
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select taille from article where id_article =?");
				
				statement.setInt(1, code);
				ResultSet resultat = statement.executeQuery();
				int taille = 0;
				while (resultat.next()) {
				    taille=resultat.getInt("taille");  
				}
				if(taille<4000)
				{
					rep= true;
				}
				else {
					rep= false;
				}
				
				resultat.close();
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
		 
		 return rep;
	}

}
