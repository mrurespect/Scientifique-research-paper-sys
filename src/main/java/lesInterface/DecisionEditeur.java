package lesInterface;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class DecisionEditeur extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextArea avis;
	ButtonGroup Bg;
	String selectedText ;
	
	static int soum_supp;
//private JTextArea motCle
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecisionEditeur frame = new DecisionEditeur();
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
	public DecisionEditeur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageEditeur frame = new PageEditeur();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(36, 496, 115, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("code article");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 44, 109, 22);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(137, 34, 224, 34);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JRadioButton ch1 = new JRadioButton("acceptés");
		ch1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ch1.setBounds(179, 181, 142, 23);
		contentPane.add(ch1);
		
		JRadioButton ch2 = new JRadioButton("révision mineure");
		ch2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ch2.setBounds(179, 220, 154, 23);
		contentPane.add(ch2);
		
		JRadioButton ch3 = new JRadioButton("révision majeure");
		ch3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ch3.setBounds(179, 255, 142, 23);
		contentPane.add(ch3);
		
		JRadioButton ch4 = new JRadioButton("refuse");
		ch4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ch4.setBounds(179, 291, 109, 23);
		contentPane.add(ch4);
		
		JLabel lblNewLabel_1 = new JLabel("donner votre decision sur l'article");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(137, 107, 224, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("les avis des evaluateur sur l'article");
		btnNewButton_1.setBackground(new Color(128, 128, 64));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!T1.getText().isEmpty())
				{
					AvisEvaluateur(Integer.parseInt(T1.getText()));
				}
				else {
					JOptionPane.showMessageDialog(	btnNewButton_1, " Dennez le code d'article ");
	                
				}
			}
		});
		btnNewButton_1.setBounds(681, 106, 268, 37);
		contentPane.add(btnNewButton_1);
		
		 avis = new JTextArea();
		avis.setBounds(681, 181, 268, 159);
		contentPane.add(avis);
		
		Bg=new ButtonGroup();
		 Bg.add(ch1);
		 Bg.add(ch2);
		 Bg.add(ch3);
		 Bg.add(ch4);
		 
		
		 //System.out.print(selectedText);
		JButton btnNewButton_2 = new JButton("valide");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> buttons = Bg.getElements();
				 while (buttons.hasMoreElements()) {
				     AbstractButton button = buttons.nextElement();
				     if (button.isSelected()) {
				         selectedText = button.getText();
				         
				         break;
				     }
				 }
				 if(selectedText.equalsIgnoreCase("refuse"))
				 {
					 ajouterDecision(Integer.parseInt(T1.getText()),selectedText);
					 supprimerArticle(Integer.parseInt(T1.getText()));
				 }
				 else
				 {
					 ajouterDecision(Integer.parseInt(T1.getText()),selectedText);
						ChangerEvaluer(Integer.parseInt(T1.getText()));
				 }
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(797, 492, 115, 34);
		contentPane.add(btnNewButton_2);
	
		 
		 
		 
		 
	}
	
	 
	
	private void AvisEvaluateur(Integer code) {
	       
		avis.setText("");
        try {
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
			PreparedStatement statement =  con.prepareStatement("select distinct id_evaluateur , avis,nbrRevision from evaluation where id_article=?");
			
			statement.setInt(1, code);
			
			ResultSet resultat = statement.executeQuery();
			
			while (resultat.next()) {
			    int id_evaluateur=resultat.getInt("id_evaluateur");
			    int nbrRevision=resultat.getInt("nbrRevision");
			    String aviseval = resultat.getString("avis");
			    
			     String avisEval=" Evaluateur "+id_evaluateur+" : "+aviseval+"("+nbrRevision+")"+"\n";
			     avis.append(avisEval);
			}
			resultat.close();
            statement.close();
            con.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	private void ajouterDecision(Integer code,String decision) {
	       
		
        try {
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
			PreparedStatement statement =  con.prepareStatement("update soumission set decision_editeur=? where id_article =?");
			
			statement.setInt(2, code);
			statement.setString(1, decision);
			
		
			int resultat = statement.executeUpdate();
            if (resultat > 0) {
                JOptionPane.showMessageDialog(this, "la decision est enregistrées avec succès !");
                
            }
			
            statement.close();
            con.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	public void ChangerEvaluer(Integer code){
	
		try {
	        	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
				PreparedStatement statement =  con.prepareStatement("update article set evalue=? where id_article =?");
				
				statement.setInt(2, code);
				statement.setString(1, "evalue");
				
				
			
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, " le mise a jours effectue avec succès !");
	                
	            }
				
	            statement.close();
	            con.close();
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	private void supprimerArticle(Integer code) {
	       
		
        try {
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
			PreparedStatement statement =  con.prepareStatement(" select id_soum  FROM soumission where id_article =?");
			statement.setInt(1, code);
			ResultSet resultat = statement.executeQuery();
			
			while (resultat.next()) {
			    soum_supp=resultat.getInt("id_soum");
			}
			
			
			PreparedStatement statement1 =  con.prepareStatement(" DELETE FROM soumission where id_article =?");
			statement1.setInt(1, code);
			int resultat1 = statement1.executeUpdate();
			PreparedStatement statement2 =  con.prepareStatement(" DELETE FROM evaluation where id_article =?");
			statement2.setInt(1, code);
			int resultat2 = statement2.executeUpdate();
			PreparedStatement statement3 =  con.prepareStatement(" DELETE FROM article where id_article =?");
			statement3.setInt(1, code);
			int resultat3 = statement3.executeUpdate();
           if (resultat3 > 0) {
                JOptionPane.showMessageDialog(this, "l'article est supprimer !");
                
            }
			
            statement1.close();
            statement2.close();
            statement3.close();
            con.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "recuperation des donnees sup articl: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}

