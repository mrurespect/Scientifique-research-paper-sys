package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PageEvaluateur1 extends JFrame {

	private JPanel contentPane;
	JTextArea AE,AR;
	LoginEvaluateur frame = new LoginEvaluateur();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageEvaluateur1 frame = new PageEvaluateur1();
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
	public PageEvaluateur1() {
		int eval=frame.id_evaluateur;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEvaluateur frame = new LoginEvaluateur();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(43, 497, 115, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("donner les article a evalue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					ArticleEvaluee(eval);
					//System.out.print(eval1);
				}
				catch(Exception e1)
				{
					System.out.print(e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(23, 63, 164, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("donner les article a reviser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					ArticleRevisee(eval);
				}
				catch(Exception e1)
				{
					System.out.print(e1.getMessage());
				}
				
				
			}
		});
		btnNewButton_2.setBounds(23, 197, 164, 51);
		contentPane.add(btnNewButton_2);
		
		AE = new JTextArea();
		AE.setBounds(285, 63, 285, 46);
		contentPane.add(AE);
		
		AR = new JTextArea();
		AR.setBounds(285, 197, 285, 51);
		contentPane.add(AR);
		
		JButton btnNewButton_3 = new JButton("Evalue");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!AE.getText().isEmpty())
				{
					PageEvaluateur2 frame = new PageEvaluateur2();
					frame.setVisible(true);
				}
				else
				{
					  JOptionPane.showMessageDialog(btnNewButton_3, "Ou est les article a evaluer!!!!");
				        
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(640, 62, 164, 47);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Revision");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(!AR.getText().isEmpty())
				{
					PageEvaluateur2 frame = new PageEvaluateur2();
					frame.setVisible(true);
				}
				else
				{
					  JOptionPane.showMessageDialog(btnNewButton_4, "Ou est les article a revise!!!!");
				        
				}
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(640, 201, 164, 47);
		contentPane.add(btnNewButton_4);
	}
	
	private void ArticleEvaluee(Integer code)
	{
		AE.setText("");
		 try {
	        	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
				PreparedStatement statement =  con.prepareStatement("select distinct E.id_article from evaluation E,article A,soumission S"
						+ " where  E.id_article =A.id_article  and "
						+ " A.id_article=S.id_article and E.id_evaluateur =? and A.evalue=? and S.decision_editeur=? ");
				
				statement.setInt(1, code);
				statement.setString(2, "Au cours d'evaluation");
				statement.setString(3,"cette article est au cours d'evaluation");
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int id_article=resultat.getInt("E.id_article");
				    String S=String.valueOf(id_article)+" ";
				    AE.append(S);
				}
				
				resultat.close();
	            statement.close();
	            con.close();
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void ArticleRevisee(Integer code)
	{
		AR.setText("");
		 try {
	        	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
				PreparedStatement statement =  con.prepareStatement("select distinct E.id_article from evaluation E,article A,soumission S"
						+ " where  E.id_article =A.id_article  and "
						+ " A.id_article=S.id_article and E.id_evaluateur =? and A.evalue=?   ");
				//and E.dateRevision IS NOT NULL
				statement.setInt(1, code);
				statement.setString(2, "revise");
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int id_article=resultat.getInt("E.id_article");
				    String S=String.valueOf(id_article)+" ";
				    AR.append(S);
				}
				
				resultat.close();
	            statement.close();
	            con.close();
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

