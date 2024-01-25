package lesInterface;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class QuatreEvaluateur extends JFrame {

	private JPanel contentPane;
	private JTextField Te1;
	private JTextField Te2;
	private JTextField Te3;
	private JTextField Te4;
	JTextArea idEval;
	EvaluationArticle frame = new EvaluationArticle();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuatreEvaluateur frame = new QuatreEvaluateur();
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
	public QuatreEvaluateur() {
		
		int id_article=frame.id_article;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("afficher list des evaluateur ");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idEvaluateur(id_article);
			}
		});
		btnNewButton.setBounds(164, 97, 243, 30);
		contentPane.add(btnNewButton);
		
		 idEval = new JTextArea();
		idEval.setBounds(448, 97, 258, 30);
		contentPane.add(idEval);
		
		JLabel lblNewLabel_1 = new JLabel("eval 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(321, 163, 86, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("eval 2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(321, 228, 59, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("eval 3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(321, 289, 59, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("eval 4");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(321, 349, 59, 27);
		contentPane.add(lblNewLabel_4);
		
		Te1 = new JTextField();
		Te1.setBounds(466, 163, 115, 30);
		contentPane.add(Te1);
		Te1.setColumns(10);
		
		Te2 = new JTextField();
		Te2.setBounds(466, 218, 115, 30);
		contentPane.add(Te2);
		Te2.setColumns(10);
		
		Te3 = new JTextField();
		Te3.setBounds(466, 279, 115, 30);
		contentPane.add(Te3);
		Te3.setColumns(10);
		
		Te4 = new JTextField();
		Te4.setBounds(466, 349, 115, 32);
		contentPane.add(Te4);
		Te4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EvaluationArticle frame = new EvaluationArticle();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(189, 497, 115, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("affecte");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(!idEval.getText().isEmpty()&&!Te1.getText().isEmpty()&&!Te2.getText().isEmpty()&&!Te3.getText().isEmpty())
				{
					ajouteEvaluation(id_article,Integer.parseInt(Te1.getText()));

					ajouteEvaluation(id_article,Integer.parseInt(Te2.getText()));

					ajouteEvaluation(id_article,Integer.parseInt(Te3.getText()));
					
					ajouteEvaluation(id_article,Integer.parseInt(Te4.getText()));
					
					updateEvalue(id_article);
					  JOptionPane.showMessageDialog(btnNewButton_2, "l'article est afecter aus evaluateur ");
				        
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton_2, "Entrez tous les champ ");
				      
				}
					
			}
		});
		btnNewButton_2.setBounds(803, 351, 115, 30);
		contentPane.add(btnNewButton_2);
	}
	Connection con=ConnectionMySql .getConnection();
	private void idEvaluateur(Integer code)
	{
		idEval.setText("");
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("select id from evaluateur where institution not in(select institution from listauteur "
						
						+ " where  id_corr=(select id_Corr from article where id_article =?))"
						+ " and domaine =(select domaine from correspondant C1,article A1 where C1.id_Corr=A1.id_Corr and A1.id_article =?)");
				
				statement.setInt(1, code);
				statement.setInt(2, code);
				ResultSet resultat = statement.executeQuery();
				
				while (resultat.next()) {
				    int idevaluateur=resultat.getInt("id");
				    String S=String.valueOf(idevaluateur)+" ";
				    idEval.append(S);
				}
				
				resultat.close();
	            statement.close();
	           
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
	}
	
private void ajouteEvaluation(Integer id_article,Integer id_evaluateur) {
       
        
        try {
        	
        	
		PreparedStatement statement =  con.prepareStatement("INSERT INTO evaluation (id_article ,id_evaluateur,	dateEvaluation,nbrRevision) VALUES (?,?, ?, ?)");
			String date=String.valueOf(LocalDate.now());   
            statement.setInt(1, id_article);
            statement.setInt(2, id_evaluateur);
            statement.setString(3, date);
            statement.setInt(4, 0);
          
            int resultat = statement.executeUpdate();
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données : " + ex.getMessage());
        } 
    }

private void updateEvalue(Integer code) {
    
    
    try {
    	
    	PreparedStatement statement =  con.prepareStatement("UPDATE article SET evalue = ? where id_article=?");
           
        statement.setString(1, "Au cours d'evaluation");
        statement.setInt(2,code);
      
        int resultat = statement.executeUpdate();
        statement.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erreur update : " + ex.getMessage());
    } 
}
}

