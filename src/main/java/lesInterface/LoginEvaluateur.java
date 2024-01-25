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
import java.awt.Font;
import java.awt.Color;

public class LoginEvaluateur extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	static int id_evaluateur;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEvaluateur frame = new LoginEvaluateur();
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
	public LoginEvaluateur() {
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
				InterfaceProjet frame = new InterfaceProjet();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(273, 303, 115, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("nom d'utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(273, 128, 130, 34);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(499, 120, 165, 37);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("mot de passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(278, 192, 145, 34);
		contentPane.add(lblNewLabel_1);
		
		T2 = new JTextField();
		T2.setBounds(499, 192, 165, 37);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("conecte");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!T1.getText().isEmpty()&&!T2.getText().isEmpty()) {
					if(test(Integer.parseInt(T2.getText()),T1.getText()))
			
					{
						id_evaluateur=Integer.parseInt(T2.getText());
						PageEvaluateur1 frame = new PageEvaluateur1();
						frame.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_1,"ce compt n'exist pas");
						   
					}
				
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton_1 ,"Donnez les information d'utilisateur" );
					   }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(549, 303, 115, 34);
		contentPane.add(btnNewButton_1);
	}
	
	Connection con=ConnectionMySql .getConnection();
	private boolean test(Integer code,String nom) {
	       
        boolean rep = false;
        try {
        
            //Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			String sql = "SELECT * FROM evaluateur WHERE id = ? AND nom = ?";
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
            System.out.println("Une erreur s'est produite : " + ex.getMessage());
        } 
		return rep;
    }

}

