package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TroisEvaluateur extends JFrame {

	private JPanel contentPane;
	private JTextField Te1;
	private JTextField Te2;
	private JTextField Te3;
	private JTextArea idEval;
	/**
	 * Launch the application.
	 */
	EvaluationArticle frame = new EvaluationArticle();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TroisEvaluateur frame = new TroisEvaluateur();
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
	public TroisEvaluateur() {
		
		
		int id_article=frame.id_article;
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
				EvaluationArticle frame = new EvaluationArticle();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(27, 527, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("afficher la liste des evaluateur");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idEvaluateur(id_article);
			}
		});
		btnNewButton_1.setBounds(254, 77, 241, 36);
		contentPane.add(btnNewButton_1);
		
		 idEval = new JTextArea();
		idEval.setBounds(542, 78, 195, 35);
		contentPane.add(idEval);
		
		JLabel lblNewLabel_1 = new JLabel("eval1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(396, 152, 71, 25);
		contentPane.add(lblNewLabel_1);
		
		Te1 = new JTextField();
		Te1.setBounds(542, 152, 195, 36);
		contentPane.add(Te1);
		Te1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("eval2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(396, 221, 59, 25);
		contentPane.add(lblNewLabel_2);
		
		Te2 = new JTextField();
		Te2.setBounds(542, 210, 195, 36);
		contentPane.add(Te2);
		Te2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("eval3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(396, 282, 46, 29);
		contentPane.add(lblNewLabel_3);
		
		Te3 = new JTextField();
		Te3.setBounds(542, 282, 195, 36);
		contentPane.add(Te3);
		Te3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("affecter");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!idEval.getText().isEmpty()&&!Te1.getText().isEmpty()&&!Te2.getText().isEmpty()&&!Te3.getText().isEmpty())
				{
					ajouteEvaluation(id_article,Integer.parseInt(Te1.getText()));

					ajouteEvaluation(id_article,Integer.parseInt(Te2.getText()));

					ajouteEvaluation(id_article,Integer.parseInt(Te3.getText()));
					
					updateEvalue(id_article);
					
					  JOptionPane.showMessageDialog(btnNewButton_2, "l'article est afecter aus evaluateur ");
				        
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton_2, "Entrez tous les champ ");
				      
				}
				
				
				
			}
		});
		btnNewButton_2.setBounds(850, 282, 102, 36);
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

