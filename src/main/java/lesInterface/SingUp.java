package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SingUp extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;
	private JTextField T4;
	private JTextField T5;
	private JTextField T6;
	private JTextField A1;
	private JTextField A2;
	private JTextField A3;
	private JTextField A4;
	private JTextField A5;
	private JTextField P1;
	private JTextField P2;
	private JTextField P3;
	private JTextField P4;
	private JTextField P5;
	private JTextField I1;
	private JTextField I2;
	private JTextField I3;
	private JTextField I4;
	private JTextField I5;
	private JTextField D1;
	private JTextField D2;
	private JTextField D3;
	private JTextField D4;
	private JTextField D5;
	Connection con=ConnectionMySql .getConnection();
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp frame = new SingUp();
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
	public SingUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donner les information du correspondant  : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 35, 425, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 111, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		T1 = new JTextField();
		T1.setBounds(93, 103, 176, 27);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 160, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		T2 = new JTextField();
		T2.setBounds(93, 152, 176, 27);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(22, 210, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		T3 = new JTextField();
		T3.setBounds(93, 204, 176, 27);
		contentPane.add(T3);
		T3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adresse");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(362, 113, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		T4 = new JTextField();
		T4.setBounds(445, 103, 176, 27);
		contentPane.add(T4);
		T4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Domaine");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(362, 162, 73, 14);
		contentPane.add(lblNewLabel_5);
		
		T5 = new JTextField();
		T5.setBounds(445, 152, 176, 27);
		contentPane.add(T5);
		T5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Institution");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(362, 212, 73, 14);
		contentPane.add(lblNewLabel_6);
		
		T6 = new JTextField();
		T6.setBounds(445, 204, 176, 25);
		contentPane.add(T6);
		T6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Donner les information de group des auteur  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 263, 453, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nom");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(36, 307, 140, 25);
		contentPane.add(lblNewLabel_8);
		
		A1 = new JTextField();
		A1.setBounds(36, 350, 140, 20);
		contentPane.add(A1);
		A1.setColumns(10);
		
		A2 = new JTextField();
		A2.setBounds(36, 392, 140, 20);
		contentPane.add(A2);
		A2.setColumns(10);
		
		A3 = new JTextField();
		A3.setBounds(36, 435, 140, 20);
		contentPane.add(A3);
		A3.setColumns(10);
		
		A4 = new JTextField();
		A4.setBounds(36, 477, 140, 20);
		contentPane.add(A4);
		A4.setColumns(10);
		
		A5 = new JTextField();
		A5.setBounds(36, 519, 140, 20);
		contentPane.add(A5);
		A5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Prenom");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(223, 309, 137, 21);
		contentPane.add(lblNewLabel_9);
		
		P1 = new JTextField();
		P1.setBounds(223, 350, 140, 20);
		contentPane.add(P1);
		P1.setColumns(10);
		
		P2 = new JTextField();
		P2.setBounds(223, 392, 140, 20);
		contentPane.add(P2);
		P2.setColumns(10);
		
		P3 = new JTextField();
		P3.setBounds(223, 435, 140, 20);
		contentPane.add(P3);
		P3.setColumns(10);
		
		P4 = new JTextField();
		P4.setBounds(223, 477, 140, 20);
		contentPane.add(P4);
		P4.setColumns(10);
		
		P5 = new JTextField();
		P5.setBounds(223, 519, 140, 20);
		contentPane.add(P5);
		P5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Institution");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(415, 310, 140, 19);
		contentPane.add(lblNewLabel_10);
		
		I1 = new JTextField();
		I1.setBounds(415, 350, 140, 20);
		contentPane.add(I1);
		I1.setColumns(10);
		
		I2 = new JTextField();
		I2.setBounds(415, 392, 140, 20);
		contentPane.add(I2);
		I2.setColumns(10);
		
		I3 = new JTextField();
		I3.setBounds(415, 435, 140, 20);
		contentPane.add(I3);
		I3.setColumns(10);
		
		I4 = new JTextField();
		I4.setBounds(415, 477, 140, 20);
		contentPane.add(I4);
		I4.setColumns(10);
		
		I5 = new JTextField();
		I5.setBounds(415, 519, 140, 20);
		contentPane.add(I5);
		I5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Adresse");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(610, 312, 137, 20);
		contentPane.add(lblNewLabel_11);
		
		D1 = new JTextField();
		D1.setBounds(610, 350, 137, 20);
		contentPane.add(D1);
		D1.setColumns(10);
		
		D2 = new JTextField();
		D2.setBounds(610, 392, 137, 20);
		contentPane.add(D2);
		D2.setColumns(10);
		
		D3 = new JTextField();
		D3.setBounds(610, 435, 137, 20);
		contentPane.add(D3);
		D3.setColumns(10);
		
		D4 = new JTextField();
		D4.setBounds(610, 477, 137, 20);
		contentPane.add(D4);
		D4.setColumns(10);
		
		D5 = new JTextField();
		D5.setBounds(610, 519, 137, 20);
		contentPane.add(D5);
		D5.setColumns(10);
		
		JButton btnNewButton = new JButton("Valide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enregistrerCorrespondant(Integer.parseInt(T1.getText()),
						T2.getText(),T3.getText(), 
						T4.getText(),T5.getText(),T6.getText());
				
				
				if(!A1.getText().equals(""))
				{
					saveAuteur(A1.getText(),P1.getText(),I1.getText(),D1.getText(),Integer.parseInt(T1.getText()));
				}
				if(!A2.getText().equals(""))
				{
					saveAuteur(A2.getText(),P2.getText(),I2.getText(),D2.getText(),Integer.parseInt(T1.getText()));
					
				}if(!A3.getText().equals(""))
				{
					saveAuteur(A3.getText(),P3.getText(),I3.getText(),D3.getText(),Integer.parseInt(T1.getText()));
					}
				if(!A4.getText().equals(""))
				{
					saveAuteur(A4.getText(),P4.getText(),I4.getText(),D4.getText(),Integer.parseInt(T1.getText()));
				}
				if(!A5.getText().equals(""))
				{
					saveAuteur(A5.getText(),P5.getText(),I5.getText(),D5.getText(),Integer.parseInt(T1.getText()));
				}
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(830, 422, 108, 43);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceProjet frame = new InterfaceProjet();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(830, 498, 108, 43);
		contentPane.add(btnNewButton_1);
	}
	
	
	
	private void enregistrerCorrespondant(Integer code,String nom, String prenom, String adresse,
    		String domaine,String Institution) {
       
        
        try {
        	
            //Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            PreparedStatement statement = con.prepareStatement("INSERT INTO correspondant (id_Corr,nom, prenom, adresse, domaine, institution) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, code);
            statement.setString(2, nom);
            statement.setString(3, prenom);
            statement.setString(4, adresse);
            statement.setString(5, domaine);
            statement.setString(6, Institution);
            
            int resultat = statement.executeUpdate();
            if (resultat > 0) {
                JOptionPane.showMessageDialog(this, "Données enregistrées avec succès !");
                
            }
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données : " + ex.getMessage());
        }
    }
	
	
	private void saveAuteur(String nom,String prenom,
			String institution,String adresse,Integer id_corr) {
        
        
        try {
        	
        	
            PreparedStatement statement = con.prepareStatement("INSERT INTO listauteur (nom,prenom,institution,adresse,id_corr ) VALUES ( ?, ?, ?, ?, ?)");
           
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, institution);
            statement.setString(4,adresse);
            statement.setInt(5, id_corr);
            int resultat = statement.executeUpdate();
            
            statement.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données : " + ex.getMessage());
        } 
    }
	
}
