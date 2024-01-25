package lesInterface;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Soumission extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Soumission frame = new Soumission();
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
	public Soumission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter Soumission");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjouterSoumission frame = new AjouterSoumission();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(242, 195, 215, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier Soumission");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifierSoumission frame = new ModifierSoumission();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(242, 361, 215, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn frame = new LogIn();
				frame.setVisible(true);
			
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(242, 516, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Suivre Soumission");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuivreSoumission frame = new SuivreSoumission();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(128, 128, 192));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(537, 195, 215, 56);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Supprimer Article");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerArticle frame = new SupprimerArticle();
				frame.setVisible(true);	
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(128, 128, 192));
		btnNewButton_4.setBounds(537, 361, 215, 56);
		contentPane.add(btnNewButton_4);
	}
}
