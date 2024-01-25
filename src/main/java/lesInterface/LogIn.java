package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import projetJavaSwing.Classe.InterfaceSoumission;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;

	static Integer  id_corr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom utilisateur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(360, 200, 125, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Le mot de passe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(360, 273, 125, 25);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(508, 202, 167, 25);
		contentPane.add(T1);
		T1.setColumns(10);
		
		T2 = new JTextField();
		T2.setBounds(508, 275, 167, 25);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceProjet frame = new InterfaceProjet();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(360, 366, 125, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Connecter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!T2.getText().isEmpty()&&!T1.getText().isEmpty())
				{
					if(test(Integer.parseInt(T2.getText()),T1.getText())) {
						Soumission frame = new Soumission();
						frame.setVisible(true);
						id_corr=Integer.parseInt(T2.getText());
						
						}
					else {
						
						JOptionPane.showMessageDialog(btnNewButton_1,"ce compt n'exist pas" );
				   
					}
					
				}else {
					JOptionPane.showMessageDialog(btnNewButton_1,"s'il vous plais donner le nom et le mot de passe");
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(550, 366, 125, 41);
		contentPane.add(btnNewButton_1);
	}

	Connection con=ConnectionMySql .getConnection();
	 private boolean test(Integer code,String nom) {
	       
	        boolean rep = false;
	        try {
	        	
	            //Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
				String sql = "SELECT * FROM correspondant WHERE id_corr = ? AND nom = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
			    pstmt.setInt(1, code);
			      pstmt.setString(2, nom);

			      // Exécuter la requête SQL
			      ResultSet rs = pstmt.executeQuery();
				
			      if (rs.next()) {
			       rep=true;  
			      } else {
			    	  rep=false;
			          }
			      
			      rs.close();
			      pstmt.close();
			      
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(this, "Erreur  : " + ex.getMessage());
	           } 
			return rep;
	    }
}
