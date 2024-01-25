package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class LogInEditeur extends JFrame {

	private JPanel contentPane;
	private JTextField T2;
	private JTextField T1;
	static int id_editeue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInEditeur frame = new LogInEditeur();
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
	public LogInEditeur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donner le Mot de passe ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(214, 177, 211, 20);
		contentPane.add(lblNewLabel);
		
		T2 = new JTextField();
		T2.setBounds(450, 177, 175, 31);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Donner le nom d'utilisateur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(214, 85, 211, 31);
		contentPane.add(lblNewLabel_1);
		
		T1 = new JTextField();
		T1.setBounds(450, 85, 175, 31);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceProjet frame = new InterfaceProjet();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(214, 300, 113, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("conecter");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				if(!T1.getText().isEmpty()&&!T2.getText().isEmpty()) {
					if(test(Integer.parseInt(T2.getText()),T1.getText()))
			
					{
						id_editeue=Integer.parseInt(T2.getText());
						PageEditeur frame = new PageEditeur();
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
		btnNewButton_1.setBounds(512, 300, 113, 31);
		contentPane.add(btnNewButton_1);
	}
	Connection con=ConnectionMySql .getConnection();
	private boolean test(Integer code,String nom) {
	       
        boolean rep = false;
        try {
        	
        	
			//Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			String sql = "SELECT * FROM editeur WHERE id_editeur = ? AND nom_ed = ?";
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
