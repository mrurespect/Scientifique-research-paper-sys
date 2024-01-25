package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AjouterSoumission extends JFrame {

	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;
	private JTextField T4;
	private JTextField T6;
	private JTextField T7;
	private JTextField S1;
	private JTextField S2;
	JTextArea MotCle;
	private File resumer;
	private File contenue;
	LogIn frame = new LogIn();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterSoumission frame = new AjouterSoumission();
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
	public AjouterSoumission() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("donner les information de l'article");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 21, 255, 25);
		contentPane.add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(105, 68, 218, 25);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 131, 46, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Code");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(32, 66, 63, 25);
		contentPane.add(lblNewLabel_2);
		
		T2 = new JTextField();
		T2.setBounds(105, 125, 218, 25);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Taille");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(32, 195, 46, 19);
		contentPane.add(lblNewLabel_3);
		
		T3 = new JTextField();
		T3.setBounds(105, 191, 218, 25);
		contentPane.add(T3);
		T3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("MotCle");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(32, 261, 46, 19);
		contentPane.add(lblNewLabel_4);
		
		T4 = new JTextField();
		T4.setBounds(105, 257, 218, 25);
		contentPane.add(T4);
		T4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("List Auteur");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(32, 337, 77, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea T5 = new JTextArea();
		T5.setBounds(105, 334, 218, 72);
		contentPane.add(T5);
		
		JLabel lblNewLabel_6 = new JLabel("Contenue");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(32, 457, 69, 25);
		contentPane.add(lblNewLabel_6);
		
		T6 = new JTextField();
		T6.setBounds(105, 449, 218, 32);
		contentPane.add(T6);
		T6.setColumns(10);
		JFrame fenetre = new JFrame("Insertion de fichier");
		JButton btnNewButton = new JButton("Selectionner le contenue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					JFileChooser fileChooser = new JFileChooser();
	                int resultat = fileChooser.showOpenDialog(fenetre);
	                if (resultat == JFileChooser.APPROVE_OPTION) {
	                    contenue = fileChooser.getSelectedFile();
	                    T6.setText(contenue.getName());
					
				}
			}
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(363, 449, 255, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Resumer");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(32, 514, 69, 25);
		contentPane.add(lblNewLabel_7);
		
		T7 = new JTextField();
		T7.setBounds(105, 514, 218, 31);
		contentPane.add(T7);
		T7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Selectionner le resumer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				JFileChooser fileChooser = new JFileChooser();
                int resultat = fileChooser.showOpenDialog(fenetre);
                if (resultat == JFileChooser.APPROVE_OPTION) {
                    resumer = fileChooser.getSelectedFile();
                    T7.setText(resumer.getName());
                    
			}
            
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(363, 512, 255, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editeur  && MotCle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> listId =new ArrayList<Integer>();
				ArrayList<String> listMot =new ArrayList<String>();
				listId=getIdEditeur ( );
			for(Integer i : listId)
			{
				listMot =getMotCle(i);
				 MotCle.append("Editeur : "+i+" "+listMot+"\n");
			}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(363, 131, 255, 32);
		contentPane.add(btnNewButton_2);
		
		 MotCle = new JTextArea();
		MotCle.setBounds(363, 191, 585, 215);
		contentPane.add(MotCle);
		
		JLabel lblNewLabel_8 = new JLabel("Donner les information de la soumission");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(679, 21, 269, 21);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Code Soumission");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(679, 68, 123, 25);
		contentPane.add(lblNewLabel_9);
		
		S1 = new JTextField();
		S1.setBounds(812, 63, 136, 25);
		contentPane.add(S1);
		S1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Code Editeur");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(679, 135, 123, 28);
		contentPane.add(lblNewLabel_10);
		
		S2 = new JTextField();
		S2.setBounds(812, 131, 136, 25);
		contentPane.add(S2);
		S2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Valide");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_corr=frame.id_corr;
			if(!T1.getText().isEmpty()&&!T2.getText().isEmpty()
					&&!T3.getText().isEmpty()&&!T4.getText().isEmpty()
					&&!T5.getText().isEmpty()&&!T6.getText().isEmpty()
					&&!T7.getText().isEmpty())
			{
				
				FileInputStream Resumer = null;
				try {
					Resumer = new FileInputStream(resumer);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.print("resumer");
					e1.printStackTrace();
				}
				FileInputStream Contenue = null;
				try {
					Contenue = new FileInputStream(contenue);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.print("contenue");
				}
				
				saveArticle(Integer.parseInt(T1.getText()),
				T2.getText(),Integer.parseInt(T3.getText()),
				Resumer,Contenue,T5.getText(),T4.getText(),id_corr);	
			
			}
			else {

				JOptionPane.showMessageDialog(btnNewButton_3 ,"entre tous les champ de l'article" );
		   
			}
			
			if(!S1.getText().isEmpty()&&!S2.getText().isEmpty())
			{
				saveSoumission(Integer.parseInt(S1.getText()),id_corr,Integer.parseInt(S2.getText()),Integer.parseInt(T1.getText()));
			}
			else
			{
				JOptionPane.showMessageDialog(btnNewButton_3 ,"entre tous les champ de soumission" );
				   
			}

			}
			
			

		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(867, 502, 89, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Retour");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Soumission frame = new Soumission();
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(735, 502, 89, 37);
		contentPane.add(btnNewButton_4);
	}
	
	Connection con=ConnectionMySql .getConnection();
	private ArrayList<String> getMotCle(Integer code ) {
		ArrayList<String> listMotcle=new ArrayList<String>();
	    
        try {
        	
			
        	 PreparedStatement statement = con.prepareStatement("select mot from motcle where id_ed=?");
        	 statement.setInt(1, code);
			
        	 ResultSet resultat = statement.executeQuery();
             String Mot;
        	 while (resultat.next()) {
 			    Mot=resultat.getString("mot");
 			   listMotcle.add(Mot);   
 			}
        	 
             statement.close();
			
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
        }
		return listMotcle; 
		
    }
	
	private ArrayList<Integer> getIdEditeur ( ) {
	       
		ArrayList<Integer>  listId= new ArrayList<Integer>();
        try {
        	
        	java.sql.Statement statement = con.createStatement();
			String requette="select distinct id_ed from motcle";
			
			ResultSet resultat = statement.executeQuery(requette);
			 int id_editeur;
			while (resultat.next()) {
			    id_editeur=resultat.getInt("id_ed");
			    listId.add(id_editeur);   
			}
             statement.close();
			
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "recuperation des donnees : " + ex.getMessage());
        }
		return listId; 
		
    }

	private void saveArticle(Integer id,String titre ,int taille,
			InputStream resumer,InputStream contenue,String auteur,
			String motcle,Integer id_corr)
	{
		 try {
	        	
				PreparedStatement statement =  con.prepareStatement("INSERT INTO article (id_article  , titre, taille, resumer, contenue, motCle, evalue, id_corr ,listAuteur ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				statement.setInt(1,id);
				statement.setString(2, titre);
				statement.setInt(3,taille);
				statement.setBinaryStream(4, resumer);
				statement.setBinaryStream(5, contenue);
				statement.setString(6, motcle);
				statement.setString(7, "false");
				statement.setInt(8, id_corr);
				statement.setString(9, auteur);
				
				int resultat = statement.executeUpdate();
	            if (resultat > 0) {
	                JOptionPane.showMessageDialog(this, "article enregistrées avec succès !");
	                
	            }
	            statement.close();
	            
	        
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "recuperation des donnees de l'article: " + ex.getMessage());
	        } 
	}
	
private void saveSoumission(Integer soumission,Integer correspondant,Integer editeur,Integer article) {
        
        
        try {
        	
            PreparedStatement statement = con.prepareStatement("INSERT INTO soumission (id_soum,id_corr,id_editeur,id_article,decision_editeur,dateSoumission ) VALUES ( ?, ?, ?, ?, ?, ?)");
           String date=String.valueOf(LocalDate.now());
            statement.setInt(1, soumission);
            statement.setInt(2, correspondant);
            statement.setInt(3, editeur);
            statement.setInt(4, article);
            statement.setString(5, "cette article est au cours d'evaluation");
            statement.setString(6, date);
            int resultat = statement.executeUpdate();
            if (resultat > 0) {
                JOptionPane.showMessageDialog(this, "Soumission enregistrées avec succès !");
                
            }
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données : " + ex.getMessage());
        } 
    }
}
