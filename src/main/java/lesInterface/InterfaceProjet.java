package lesInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceProjet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceProjet frame = new InterfaceProjet();
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
	public InterfaceProjet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Editeur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInEditeur frame = new LogInEditeur();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(142, 386, 250, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Gestion des publication scientifique");
		lblNewLabel.setBackground(new Color(128, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 76, 861, 76);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Evaluateur");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEvaluateur frame = new LoginEvaluateur();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 128, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(598, 386, 250, 60);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log In");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn frame = new LogIn();
				frame.setVisible(true);	
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(885, 11, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sing Up");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingUp frame = new SingUp();
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(885, 42, 89, 23);
		contentPane.add(btnNewButton_4);
	}
	
	
}
